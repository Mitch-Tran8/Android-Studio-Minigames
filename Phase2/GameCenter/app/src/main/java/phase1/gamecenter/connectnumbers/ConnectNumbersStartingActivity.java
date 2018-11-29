package phase1.gamecenter.connectnumbers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import phase1.gamecenter.R;

public class ConnectNumbersStartingActivity extends AppCompatActivity {

    Button onePlayer;
    Button twoPlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_numbers_complexity);

        Button onePlayer = findViewById(R.id.one_player_button);
        Button twoPlayer = findViewById(R.id.two_player_button);

        onePlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConnectNumbersStartingActivity.this, ConnectThreeDifficultyActivity.class);
                startActivity(intent);
            }
        });

        twoPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConnectNumbersStartingActivity.this, ConnectNumbersSelectActivity.class);
                startActivity(intent);
            }
        });

    }
}
