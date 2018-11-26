package phase1.gamecenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ConnectThreeRankingsMainActivity extends AppCompatActivity {
    Button twoPlayersRankings;
    Button artificialIntelRankings;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_three_rankings_mainscreen);
        twoPlayersRankings = findViewById(R.id.two_players_rankings_button);
        artificialIntelRankings = findViewById(R.id.artificial_intel_rankings_button);

        twoPlayersRankings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConnectThreeRankingsMainActivity.this, ConnectThreeRankings2PlayersActivity.class);
                startActivity(intent);
            }
        });

        artificialIntelRankings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConnectThreeRankingsMainActivity.this, ConnectThreeRankings1PlayerActivity.class);
                startActivity(intent);
            }
        });
    }
}
