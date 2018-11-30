package phase1.gamecenter.registrationinfo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import phase1.gamecenter.R;

/**
 * the leader board activity
 */
public class LeaderboardActivity extends AppCompatActivity {

    /**
     * an arraylist of the scores in leaderboard
     */
    private ArrayList<Pair<String, Integer>> leaderBoardScores;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        getLeaderBoardScores("Colour Tiles");


        TabLayout tabLayout = findViewById(R.id.TabLayout);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    getLeaderBoardScores("Colour Tiles");
                } else if (tab.getPosition() == 1) {
                    getLeaderBoardScores("Sliding Tiles");
                } else {
                    getLeaderBoardScores("Connect 34");
                }

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
    private void getLeaderBoardScores(final String game) {
        final DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Leaderboards").child(game);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<Pair<String, Integer>> leaderScores = new ArrayList<Pair<String, Integer>>();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
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
                setUpRankings(game);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    /**
     * sets up the rankings
     */
    private void setUpRankings(String game) {

        TextView title = findViewById(R.id.LeaderBoardTitle);
        title.setText(game + "Rankings");

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
