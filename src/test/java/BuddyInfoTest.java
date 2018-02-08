import junit.framework.TestCase;

import lab.BuddyInfo;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BuddyInfoTest extends TestCase {
    public void testSetName() throws Exception {
        BuddyInfo testBuddy = new BuddyInfo("Cyrus", "555-555-5555");

        testBuddy.setName("Rob");

        assertEquals("Rob", testBuddy.getName());
    }

    public void testSetPhoneNumber() throws Exception {
        BuddyInfo testBuddy = new BuddyInfo("Cyrus", "555-555-5555");

        testBuddy.setPhoneNumber("666-666-6666");

        assertEquals("666-666-6666", testBuddy.getPhoneNumber());
    }

    public void testGetName() throws Exception {
        BuddyInfo testBuddy = new BuddyInfo("Cyrus", "555-555-5555");

        assertEquals(testBuddy.getName(), "Cyrus");
    }

    public void testGetPhoneNumber() throws Exception {
        BuddyInfo testBuddy = new BuddyInfo("Cyrus", "555-555-5555");

        assertEquals(testBuddy.getPhoneNumber(), "555-555-5555");
    }
}