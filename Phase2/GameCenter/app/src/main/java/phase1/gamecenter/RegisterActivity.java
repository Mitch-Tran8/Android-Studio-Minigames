package phase1.gamecenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


/**
 * Register activity class. Allow the user to make a new account and save info onto firebase
 */
public class RegisterActivity extends AppCompatActivity {

    /**
     * the user chooses a name, saved as nameField
     */
    private EditText nameField;
    /**
     * user chooses a password, saved as passwordField
     */
    private EditText passwordField;
    /**
     * user's email
     */
    private EditText emailField;

    /**
     * the button that allows user to register, sends information to firebase
     */
    private Button register_button;

    /**
     * Firebase auth
     */
    private FirebaseAuth mAuth;
    /**
     * Firebase auth listener
     */
    private FirebaseAuth.AuthStateListener mAuthListener;
    /**
     * Firebase database
     */
    private DatabaseReference databaseReference;

    private GameManager games;
    private Game game;

    /**
     * Regex expression for password strength: must be at least 6 characters long and have one letter
     * and on number.
     */
    String passwordPattern = "(?=.*[0-9])(?=.*[a-zA-Z])[0-9a-zA-Z]{6,}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("users");

        nameField = (EditText) findViewById(R.id.nameField);
        passwordField = (EditText) findViewById(R.id.passwordField);
        emailField = (EditText) findViewById(R.id.emailField);
        register_button = (Button) findViewById(R.id.register_button);
        game = new Game("Sliding Tiles", 4, 4);
        games = new GameManager(game);


        /**
         * Activate the register button
         */
        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRegister();
            }
        });

    }

    /**
     * This registers the user and saves their information in firebase
     */
    private void startRegister() {
        final String name = nameField.getText().toString().trim();
        final String email = emailField.getText().toString().trim();
        final String password = passwordField.getText().toString().trim();

        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(email)) {
            if (Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.matches(passwordPattern)) {

                /**
                 * create new user
                 */
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<com.google.firebase.auth.AuthResult> task) {
                        if (task.isSuccessful()) {

                            String user_id = mAuth.getCurrentUser().getUid();
                            FirebaseUser currUser = mAuth.getCurrentUser();
                            UserProfileChangeRequest changeRequest = new UserProfileChangeRequest.Builder().setDisplayName(name).build();
                            currUser.updateProfile(changeRequest);

                            User users = new User(email, name, games);
                            ArrayList scores = new ArrayList();
                            scores.add(new Pair<>("score1", 0));
                            scores.add(new Pair<>("score2", 0));
                            scores.add(new Pair<>("score3", 0));
                            scores.add(new Pair<>("score4", 0));
                            scores.add(new Pair<>("score5", 0));

                            databaseReference.child(user_id).setValue(users);
                            databaseReference.child(user_id).child("Game Collection").setValue(games);
                            DatabaseReference ref = databaseReference.child(user_id).child("Game Collection").child("Sliding tiles").child("userscores");
                            for (int i = 1; i < 6; i++){
                                ref.child("score"+ String.valueOf(i)).setValue(0);
                            }

                                    Log.d(RegisterActivity.class.getSimpleName(), "Authentication successful");

                            Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(i);

                        } else {
                            Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches() && !password.matches(passwordPattern)) {
                emailField.setError("Please enter a valid email address!");
                passwordField.setError("Password must be at least 6 characters long and contain at least one letter and one number.");
            }
            else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailField.setError("Please enter a valid email address!");
            }
            else if(!password.matches(passwordPattern)) {
                passwordField.setError("Password must be at least 6 characters long and contain at least one letter and one number.");
            }
        }
    }

    /**
     * goes to next activity, which would be the login screen, after registration is succesful.
     */
    private void createAuthStateListener() {
        mAuthListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                final FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Intent intent = new Intent(RegisterActivity.this, StartingActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }
            }

        };
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

}
