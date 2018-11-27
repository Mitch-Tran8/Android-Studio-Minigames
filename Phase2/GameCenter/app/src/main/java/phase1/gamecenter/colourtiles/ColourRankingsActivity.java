package phase1.gamecenter.colourtiles;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import phase1.gamecenter.R;

public class ColourRankingsActivity extends AppCompatActivity {

    Button connect3;
    Button connect4;
    Button connect5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rankings_screen_connect_numbers);

        connect3 = findViewById(R.id.rankings_3x3);
        connect5 = findViewById(R.id.rankings_5x5);

        connect3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ColourRankingsActivity.this, ColourScoreBoard3x3.class);
                startActivity(intent);
            }
        });


        connect5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ColourRankingsActivity.this, ColourScoreBoard5x5.class);
                startActivity(intent);
            }
        });


    }
}
