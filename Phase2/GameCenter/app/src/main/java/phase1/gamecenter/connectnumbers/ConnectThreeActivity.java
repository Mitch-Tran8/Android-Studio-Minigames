package phase1.gamecenter.connectnumbers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import phase1.gamecenter.R;

public class ConnectThreeActivity  extends AppCompatActivity {

    Button connectThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_numbers_main_connect3_only);
        connectThree = findViewById(R.id.connect_three_button);

        connectThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConnectThreeActivity.this, ConnectThreeDifficultyActivity.class);
                startActivity(intent);
            }
        });
    }
}
