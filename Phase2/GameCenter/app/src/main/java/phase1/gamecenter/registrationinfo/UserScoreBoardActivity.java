package phase1.gamecenter.registrationinfo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import phase1.gamecenter.R;

/**
 * UserScoreBoardActivity. The user's personal scoreboard.
 */

public class UserScoreBoardActivity extends AppCompatActivity {
    /**
     * A list of the user's scores.
     */

    private ArrayList<Long> userScores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_score_board);
        getUserScores("Colour Tiles");

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0){getUserScores("Colour Tiles");}
                else if (tab.getPosition() == 1){getUserScores("Sliding Tiles");}
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    /**
     * gets the scores from firebase and sets it as a list to userScores.
     */
    private void getUserScores(final String game) {
        String user_id = FirebaseAuth.getInstance().getCurrentUser().getUid();
        final DatabaseReference ref = FirebaseDatabase.getInstance().getReference("users").child(user_id).child("Game Collection").child(game);
        ref.child("userscores").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<Long> scores = new ArrayList<Long>();
                HashMap<String, Long> map = (HashMap<String, Long>) dataSnapshot.getValue();
                for (HashMap.Entry<String, Long> entry : map.entrySet()) {
                    scores.add(entry.getValue());
                }
                Collections.sort(scores, Collections.<Long>reverseOrder());
                userScores = scores;

                showScores(game);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void showScores(String game){

        TextView textViewName = findViewById(R.id.UserNameTitle);
        textViewName.setText(FirebaseAuth.getInstance().getCurrentUser().getDisplayName()+ "'s " + game + " Scoreboard");

        TextView textView1 = findViewById(R.id.text1);
        textView1.setText(String.valueOf(userScores.get(0)));

        TextView textView2 = findViewById(R.id.text2);
        textView2.setText(String.valueOf(userScores.get(1)));

        TextView textView3 = findViewById(R.id.text3);
        textView3.setText(String.valueOf(userScores.get(2)));

        TextView textView4 = findViewById(R.id.text4);
        textView4.setText(String.valueOf(userScores.get(3)));

        TextView textView5 = findViewById(R.id.text5);
        textView5.setText(String.valueOf(userScores.get(4)));
    }



}