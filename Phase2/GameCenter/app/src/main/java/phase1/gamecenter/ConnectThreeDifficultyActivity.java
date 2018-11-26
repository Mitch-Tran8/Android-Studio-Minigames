package phase1.gamecenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Class controlling the option to pick AI or Two Player connect four game mode.
 */

public class ConnectThreeDifficultyActivity extends AppCompatActivity {

    /**
     * Button for the option to play against AI.
     */
    Button easyDifficulty;

    /**
     * Button for the two player game option.
     */
    Button hardDifficulty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_three_difficulty);

        easyDifficulty = findViewById(R.id.easy_button);
        hardDifficulty = findViewById(R.id.hard_button);

/*        artificialIntel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConnectNumbersStartingActivity.this, ConnectFourMainActivity.class);
                startActivity(intent);
            }
        });*/

        easyDifficulty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConnectThreeDifficultyActivity.this, ConnectThreeAIEasyMainActivity.class);
                startActivity(intent);
            }
        });

    }
}
