package phase1.gamecenter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UploadAPicture extends AppCompatActivity {

    Button uploadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_apicture);
        uploadButton = findViewById(R.id.upload_button);

        /**
         * activate upload button
         * If upload button clicked, take user to photo library?
         */
        uploadButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });
    }


}
