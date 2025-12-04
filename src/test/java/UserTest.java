
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserTest {
    private final User user1;

    public UserTest() {
        user1 = new User("sadra");

    }

    @Test
    public void testAddUser() {
        assertNotNull(user1.getUserID(), "User-ID cant be null");
        assertEquals(10, user1.getUserID().length(), "User-ID must have length 10, meaning name input is in the wrong format.");
    }


}
