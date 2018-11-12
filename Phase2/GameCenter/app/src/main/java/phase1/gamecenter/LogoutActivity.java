package phase1.gamecenter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Logout activity class. Allow the user to choose whether they want to log out and exit the game,
 * and save their games if so.
 */
public class LogoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
    }


}
