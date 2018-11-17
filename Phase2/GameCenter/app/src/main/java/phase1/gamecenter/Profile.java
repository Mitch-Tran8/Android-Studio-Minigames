package phase1.gamecenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * the user's profile
 */
public class Profile extends AppCompatActivity {

    /*
     * the log out button
     */
    Button logOutButton;

    /**
     * The current user's Id
     */
    private String user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        logOutButton = findViewById(R.id.logout_button);

        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Profile.this, LogoutActivity.class);
                i.putExtra("user_id", user_id);
                startActivity(i);
            }
        });
    }
}
