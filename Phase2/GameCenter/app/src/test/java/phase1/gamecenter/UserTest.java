package phase1.gamecenter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {
    GameManager testerGM = new GameManager();
    User user = new User("testing@gmail.com", "tester", testerGM);

    @Test
    public void testGetEmail() {
        assertEquals("testing@gmail.com", user.getEmail());
    }

    @Test
    public void testGetName() {
        assertEquals("tester", user.getName());
    }

    @Test
    public void testSetUserEmail() {
        user.setUserEmail("setEmail@gmail.com");
        assertEquals("setEmail@gmail.com", user.getEmail());
    }

    @Test
    public void testSetName() {
        user.setName("setName");
        assertEquals("setName", user.getName());
    }


}
