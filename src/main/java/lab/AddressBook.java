package lab;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id = null;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<BuddyInfo> buddies;

    public AddressBook() {
        buddies = new ArrayList<BuddyInfo>();
    }

    public AddressBook(List<BuddyInfo> buddies) { this.buddies = buddies; }

    public void addBuddy(BuddyInfo buddy) {
        buddies.add(buddy);
    }

    public void removeBuddy(BuddyInfo buddy) {
        buddies.remove(buddy);
    }

    public void removeBuddy(int index) {
        buddies.remove(index);
    }

    public String getBuddy(int index) {
        return buddies.get(index).toString();
    }

    public List<BuddyInfo> getBuddies() {
        return buddies;
    }

    public int getSize() { return buddies.size(); }

    public void setBuddies(List<BuddyInfo> buddies) {
        this.buddies = buddies;
    }

    @Override
    @Transient
    public String toString() {
        return "AddressBook{" +
                "buddies=" + buddies.toString() +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        AddressBook bookObj = (AddressBook) obj;

        return (id.equals(bookObj.id)) && (buddies.equals(bookObj.buddies));
    }
}
