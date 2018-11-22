package phase1.gamecenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ConnectFourPlayersActivity extends AppCompatActivity {

    Button artificialIntel;
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
                Intent intent = new Intent(ConnectFourStartingActivity.this, ConnectFourMainActivity.class);
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

    }
}
