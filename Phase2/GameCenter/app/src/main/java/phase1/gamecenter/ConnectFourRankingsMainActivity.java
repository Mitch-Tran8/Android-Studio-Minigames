package phase1.gamecenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ConnectFourRankingsMainActivity extends AppCompatActivity {
    Button twoPlayersRankings;
    Button artificialIntelRankings;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_four_ranking_mainscreen);
        twoPlayersRankings = findViewById(R.id.two_player_rankings_button);
        artificialIntelRankings = findViewById(R.id.artificial_intel_rankings_button);

        twoPlayersRankings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConnectFourRankingsMainActivity.this, ConnectFourRankings2PlayersActivity.class);
                startActivity(intent);
            }
        });

        artificialIntelRankings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }
}
