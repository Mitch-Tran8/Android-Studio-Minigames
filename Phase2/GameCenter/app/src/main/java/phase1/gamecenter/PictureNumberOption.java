package phase1.gamecenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class PictureNumberOption extends AppCompatActivity {

    /**
     * the button to choose number tile game
     */
    Button number_button;

    /**
     * the button the choose picture game instead
     */
    Button picture_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_number_option);
        number_button = findViewById(R.id.number_button);
        picture_button = findViewById(R.id.picture_button);

        /**
         * activate number button
         * If number button clicked, take user to number game's BoardComplexity page
         */
        number_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PictureNumberOption.this, BoardComplexity.class);
                startActivity(i);
            }
        });

        /**
         * activate picture button
         * If picture button clicked, take user to upload a picture page from their photo gallery
         */
        picture_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
