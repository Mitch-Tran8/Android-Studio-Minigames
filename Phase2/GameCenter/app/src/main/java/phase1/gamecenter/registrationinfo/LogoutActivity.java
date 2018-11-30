package phase1.gamecenter.registrationinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Logout activity class. Allow the user to choose whether they want to log out and exit the game,
 * and save their games if so.
 */

public class LogoutActivity extends AppCompatActivity {

    /**
     * button that leads user to the login page after they signed out.
     *
     * @param loginPageButton
     */
    Button loginPageButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(LogoutActivity.this, LoginActivity.class));
        Toast.makeText(LogoutActivity.this, "Logout Succesful", Toast.LENGTH_LONG).show();


    }


}
