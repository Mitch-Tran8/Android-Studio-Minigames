package phase1.gamecenter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class LeaderboardActivity extends AppCompatActivity {
    /**
     * A list of the leeaderboard scores.
     */
    ArrayList<Pair<String, Integer>> leaderBoardScores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        getLeaderBoardScores();
    }

    /**
     * gets the scores from firebase and sets it as a list to userScores.
     */
    private void getLeaderBoardScores(){
        final DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Leaderboards").child("Sliding Tiles");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<Pair<String, Integer>> leaderScores = new ArrayList<Pair<String, Integer>>();
                for (DataSnapshot ds: dataSnapshot.getChildren()){
                    Integer score = ds.child("score").getValue(int.class);
                    String user = ds.child("user").getValue(String.class);
                    Pair<String, Integer> pair = new Pair(user, score);
                    leaderScores.add(pair);
                }

                Collections.sort(leaderScores, new Comparator<Pair<String, Integer>>() {
                    @Override
                    public int compare(Pair<String, Integer> o1, Pair<String, Integer> o2) {
                        int dif = o1.second.compareTo(o2.second);
                        dif = -(dif);
                        return dif;
                    }
                });

                leaderBoardScores = leaderScores;
                setUpRankings();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    /**
     * returns this user's user ID.
     * @return
     */

    private void setUpRankings(){


        TextView name1 = findViewById(R.id.text1);
        name1.setText(String.valueOf(leaderBoardScores.get(0).first));

        TextView name2 = findViewById(R.id.text2);
        name2.setText(String.valueOf(leaderBoardScores.get(1).first));

        TextView name3 = findViewById(R.id.text3);
        name3.setText(String.valueOf(leaderBoardScores.get(2).first));

        TextView name4 = findViewById(R.id.text4);
        name4.setText(String.valueOf(leaderBoardScores.get(3).first));

        TextView name5 = findViewById(R.id.text5);
        name5.setText(String.valueOf(leaderBoardScores.get(4).first));

        TextView score1 = findViewById(R.id.user1);
        score1.setText(String.valueOf(leaderBoardScores.get(0).second));

        TextView score2 = findViewById(R.id.user2);
        score2.setText(String.valueOf(leaderBoardScores.get(1).second));

        TextView score3 = findViewById(R.id.user3);
        score3.setText(String.valueOf(leaderBoardScores.get(2).second));

        TextView score4 = findViewById(R.id.user4);
        score4.setText(String.valueOf(leaderBoardScores.get(3).second));

        TextView score5 = findViewById(R.id.user5);
        score5.setText(String.valueOf(leaderBoardScores.get(4).second));
    }

}