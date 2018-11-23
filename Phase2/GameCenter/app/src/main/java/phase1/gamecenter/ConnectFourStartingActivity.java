package phase1.gamecenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ConnectFourStartingActivity extends AppCompatActivity {

    /**
     * Button that allows user to start the connect four game.
     */
    Button startGame;

    /**
     * Button that allows the user to view rankings for the connect four game.
     */
    Button rankings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_four_starting);

        startGame = findViewById(R.id.start_game_button);
        rankings = findViewById(R.id.rankings_button);

        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConnectFourStartingActivity.this, ConnectFourPlayersActivity.class);
                startActivity(intent);
            }
        });

        /*rankings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConnectFourStartingActivity.this, ConnectFourPlayersActivity.class);
                startActivity(intent);
            }
        });*/

    }
}
