import java.util.Arrays;
import javafx.scene.control.TextField;

public class Reader extends Person {
    // constructor
    public Reader(String ID, String Password, String Type, String FirstName, String LastName, String Address,
            String Email, String CellPhone, boolean isBlocked) {
        super(ID, Password, Type, FirstName, LastName, Address, Email, CellPhone, isBlocked);
    }

    public Person[] searchUsers(Person orgUsers[], Person p[], TextField searchField) {

        int foundUsers = 0;
        Person[] newPerson = new Person[orgUsers.length];

        for (int i = 0; i < orgUsers.length; i++) {
            String searchCriteria = orgUsers[i].getFirstName().toLowerCase() + " "
                    + orgUsers[i].getLastName().toLowerCase();
            if (searchCriteria.contains(searchField.getText().toLowerCase())) {
                newPerson[foundUsers] = orgUsers[i];
                foundUsers++;
            }
        }
        // make size dependable on found books in search
        return Arrays.copyOf(newPerson, foundUsers);
    }
}
