package phase1.gamecenter;

import android.support.annotation.NonNull;
import android.util.Pair;

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

public class ScoreBoardUpdater {
    int userScore;
    String gameName;

    public ScoreBoardUpdater(int score, String name){
        userScore = score;
        gameName = name;
    }

    public void updateUserScoreBoard(){

        final String user_id = FirebaseAuth.getInstance().getCurrentUser().getUid();
        final DatabaseReference ref = FirebaseDatabase.getInstance().getReference("users").child(user_id).child("Game Collection").child(gameName);

        ref.child("userscores").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Long longScore = new Long(userScore);
                ArrayList<Long> scores = new ArrayList<Long>();
                ArrayList<Long> newScores = new ArrayList<Long>();
                HashMap<String, Long> map = (HashMap<String, Long>) dataSnapshot.getValue();
                for (HashMap.Entry <String, Long> entry: map.entrySet()){
                    scores.add(entry.getValue());
                }
                Collections.sort(scores, Collections.reverseOrder());

                for (int i = 0; i < scores.size(); i++) {
                    Long compare = scores.get(i);
                    if (compare < longScore) {
                        newScores.add(longScore);
                        newScores.add(compare);
                        for (int a = i+1 ; a < scores.size(); a++){
                            Long comp = scores.get(a);
                            newScores.add(comp);
                        }
                        break;
                    }
                    else {newScores.add(compare);}
                }

                for (int i = 0; i < scores.size(); i++) {
                    String position = "score" + String.valueOf(i + 1);
                    ref.child("userscores").child(position).setValue(newScores.get(i));

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void updateLeaderBoard(){
        final DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Leaderboards").child(gameName);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<Pair<String, Integer>> leaderScores = new ArrayList<Pair<String, Integer>>();
                ArrayList<Pair<String, Integer>> newLeaderScores = new ArrayList<Pair<String, Integer>>();
                String userName = FirebaseAuth.getInstance().getCurrentUser().getDisplayName();
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

                for (int i = 0; i < leaderScores.size(); i++){
                    Pair<String, Integer> curPair = leaderScores.get(i);
                    Integer compare = leaderScores.get(i).second;
                    if (compare < userScore) {
                        Pair<String, Integer> newPair = new Pair(userName, userScore);
                        newLeaderScores.add(newPair);
                        newLeaderScores.add(curPair);
                        for (int a = i+1 ; a < leaderScores.size(); a++){
                            Pair addPair = leaderScores.get(a);
                            newLeaderScores.add(addPair);
                        }
                        break;
                    }
                    else {newLeaderScores.add(curPair);}
                }

                for (int i = 0; i < leaderScores.size(); i++) {
                    String position = "score" + String.valueOf(i + 1);
                    String positionName = newLeaderScores.get(i).first;
                    Integer positionScore = newLeaderScores.get(i).second;
                    ref.child(position).child("score").setValue(positionScore);
                    ref.child(position).child("user").setValue(positionName);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
