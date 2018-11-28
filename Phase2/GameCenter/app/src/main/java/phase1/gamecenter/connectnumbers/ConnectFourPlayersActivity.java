package phase1.gamecenter.connectnumbers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import phase1.gamecenter.R;

/**
 * Class controlling the option to pick AI or Two Player connect four game mode.
 */

public class ConnectFourPlayersActivity extends AppCompatActivity {

    /**
     * Button for the option to play against AI.
     */
    Button artificialIntel;

    /**
     * Button for the two player game option.
     */
    Button twoPlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_four_complexity);

        artificialIntel = findViewById(R.id.artificial_intel_button);
        twoPlayers = findViewById(R.id.two_player_button);

/*        artificialIntel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConnectNumbersStartingActivity.this, ConnectFourMainActivity.class);
                startActivity(intent);
            }
        });*/

        twoPlayers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConnectFourPlayersActivity.this, ConnectFourMainActivity.class);
                startActivity(intent);
            }
        });


        artificialIntel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConnectFourPlayersActivity.this, ConnectFourDifficultyActivity.class);
                startActivity(intent);
            }
        });

    }
}
