package phase1.gamecenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ConnectNumbersRankingsActivity extends AppCompatActivity {

    Button connectThreeRankings;
    Button connectFourRankings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_numbers_rankings);
        connectThreeRankings = findViewById(R.id.connect_three_rankings);
        connectFourRankings = findViewById(R.id.connect_four_rankings);

        connectThreeRankings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConnectNumbersRankingsActivity.this, ConnectThreeRankingsMainActivity.class);
                startActivity(intent);
            }
        });

        connectFourRankings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConnectNumbersRankingsActivity.this, ConnectFourRankingsMainActivity.class);
                startActivity(intent);
            }
        });
    }
}
