package lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressBookController {
    private final AddressBookRepository addressBookRepository;
    private final BuddyInfoRepository buddyInfoRepository;

    @Autowired
    public AddressBookController(AddressBookRepository addressBookRepository, BuddyInfoRepository buddyInfoRepository) {
        this.addressBookRepository = addressBookRepository;
        this.buddyInfoRepository = buddyInfoRepository;
    }

    @RequestMapping("/createAddressBook")
    public AddressBook addressBook() {
        AddressBook addressBook = new AddressBook();
        addressBookRepository.save(addressBook);
        return addressBook;
    }

    @RequestMapping("/addBuddy")
    public AddressBook addBuddy(@RequestParam(value = "name") String name, @RequestParam(value = "bookID") Long id) {
        AddressBook addressBook = addressBookRepository.findOne(id);
        BuddyInfo buddy = buddyInfoRepository.findByName(name);

        addressBook.addBuddy(buddy);

        addressBookRepository.save(addressBook);
        return addressBook;
    }

    @RequestMapping("/removeBuddy")
    public AddressBook removeBuddy(@RequestParam(value = "name") String name, @RequestParam(value = "bookID") Long id) {
        AddressBook addressBook = addressBookRepository.findOne(id);
        BuddyInfo buddy = buddyInfoRepository.findByName(name);

        addressBook.removeBuddy(buddy);
        addressBookRepository.save(addressBook);
        return addressBook;
    }
}
