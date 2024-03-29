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

public class ConnectNumbersSelectActivity extends AppCompatActivity {

    /**
     * Button for the option to play against AI.
     */
    Button connectThree;

    /**
     * Button for the two player game option.
     */
    Button connectFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_numbers_main);

        connectThree = findViewById(R.id.connect_three_button);
        connectFour = findViewById(R.id.connect_four_button);


        connectThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConnectNumbersSelectActivity.this, ConnectThreeMainActivity.class);
                startActivity(intent);
            }
        });


        connectFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConnectNumbersSelectActivity.this, ConnectFourMainActivity.class);
                startActivity(intent);
            }
        });

    }
}
