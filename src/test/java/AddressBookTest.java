import junit.framework.TestCase;

import javax.persistence.*;
import lab.BuddyInfo;
import lab.AddressBook;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AddressBookTest extends TestCase {
    public void testAddBuddy() throws Exception {
        AddressBook addressBook = new AddressBook();
        Collection<BuddyInfo> buddies = addressBook.getBuddies();

        assertEquals(buddies.size(), 0);

        BuddyInfo testBuddy = new BuddyInfo("Cyrus", "555-555-5555");
        addressBook.addBuddy(testBuddy);

        assertEquals(buddies.size(), 1);
    }

    public void testRemoveBuddy() throws Exception {
        AddressBook addressBook = new AddressBook();
        Collection<BuddyInfo> buddies = addressBook.getBuddies();

        assertEquals(buddies.size(), 0);

        BuddyInfo testBuddy = new BuddyInfo("Cyrus", "555-555-5555");
        addressBook.addBuddy(testBuddy);

        assertEquals(buddies.size(), 1);

        addressBook.removeBuddy(testBuddy);

        assertEquals(buddies.size(), 0);
    }
}
