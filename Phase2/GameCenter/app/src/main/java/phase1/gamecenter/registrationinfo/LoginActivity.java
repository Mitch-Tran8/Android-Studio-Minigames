package phase1.gamecenter.registrationinfo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import phase1.gamecenter.GameCenterMainActivity;
import phase1.gamecenter.R;

/**
 * The login activity, has a register option
 */
public class LoginActivity extends AppCompatActivity {

    /**
     * The login button
     */
    Button loginButton;
    /**
     * The progress bar
     */
    ProgressBar mProgressBar;
    /**
     * The register button that leads to the register page
     */
    Button go_to_register_button;
    /**
     * The email as typed in by user
     */
    private EditText emailField;
    /**
     * The password as typed in by user
     */
    private EditText passwordField;
    /**
     * The current user's id
     */
    private String user_id;
    /**
     * Firebase auth
     */
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mAuth.getInstance().getCurrentUser() != null) {
            startActivity(new Intent(LoginActivity.this, GameCenterMainActivity.class));
            finish();
        }
        setContentView(R.layout.activity_login);

        loginButton = findViewById(R.id.login_button);
        go_to_register_button = findViewById(R.id.go_to_register_button);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar2);
        mProgressBar.setVisibility(View.GONE);
        emailField = findViewById(R.id.login_email);
        passwordField = findViewById(R.id.login_password);
        mAuth = FirebaseAuth.getInstance();

        /**
         * activate register button
         * If register button clicked, take user to RegisterActivity page
         */

        go_to_register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgressBar.setVisibility(View.VISIBLE);
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });

        /**
         * activate login button
         * let user know if task was succesful or not
         * if it is, take to game page. If not, try again.
         */
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth mFirebaseAuth = FirebaseAuth.getInstance();

                mFirebaseAuth.signInWithEmailAndPassword(emailField.getText().toString(), passwordField.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            mProgressBar.setVisibility(View.VISIBLE);

                            user_id = mAuth.getCurrentUser().getUid();
                            Toast.makeText(LoginActivity.this, "Login Succesful", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(LoginActivity.this, GameCenterMainActivity.class);
                            i.putExtra("user_id", user_id);
                            startActivity(i);

                        } else {
                            Log.e("Error", task.getException().toString());
                            Toast.makeText(LoginActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();

                        }

                    }
                });
            }
        });


    }

}
