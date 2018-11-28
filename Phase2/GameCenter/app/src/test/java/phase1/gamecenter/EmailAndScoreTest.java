package phase1.gamecenter;

import org.junit.Test;

import phase1.gamecenter.registrationinfo.EmailAndScore;

import static org.junit.Assert.assertEquals;

public class EmailAndScoreTest {

    private EmailAndScore emailAndScore = new EmailAndScore("tester@gmail.com", 900);

    @Test
    public void testGetUserEmail() {
        assertEquals("tester@gmail.com", emailAndScore.getUserEmail());
    }

    @Test
    public void testGetGameScore() {
        assertEquals(900, emailAndScore.getGameScore());
    }
}
