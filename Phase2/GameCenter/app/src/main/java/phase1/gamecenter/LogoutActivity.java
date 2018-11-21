package phase1.gamecenter;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
     */
    Button loginPageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseAuth.getInstance().signOut();
        Toast.makeText(LogoutActivity.this, "Logout Succesful", Toast.LENGTH_LONG).show();
        setContentView(R.layout.activity_login);
    }
}