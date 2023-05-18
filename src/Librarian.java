import java.util.Arrays;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class Librarian extends Person {

    public Librarian() {
        super();
    }

    public Librarian(String ID, String Password, String Type, String FirstName, String LastName, String Address,
            String Email, String CellPhone, boolean isBlocked) {
        super(ID, Password, Type, FirstName, LastName, Address, Email, CellPhone, isBlocked);

    }

    // called in the book scene & creates a new book array with size -1
    public Books[] DeleteBook(GridPane gridpane, VBox bookinfo, Books b[], int index) {
        // remove from GUI
        gridpane.getChildren().remove(bookinfo);

        // remove from array
        Books newB[] = new Books[b.length - 1];
        int c = 0;

        for (int d = 0; d < b.length; d++) {
            if (d != index) {
                newB[c] = b[d];
                c++;
            }
        }

        return newB;
    }

    // overloading the delete book method to work with HBox

    public Books[] AddBook(Books b[], String name, String author, int price, String imgPath) {
        Books newBook[] = new Books[b.length + 1];
        for (int j = 0; j < b.length; j++) {

            newBook[j] = b[j];

        }
        newBook[b.length] = new Books(name, author, price, imgPath);
        return newBook;

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

    public Person[] DeleteUser(GridPane gridpane, VBox user, Person p[], int index) {
        // remove from GUI
        gridpane.getChildren().remove(user);

        // remove from array
        Person newP[] = new Person[p.length - 1];
        int c = 0;

        for (int d = 0; d < p.length; d++) {
            if (d != index) {
                newP[c] = p[d];
                c++;
            }
        }

        return newP;
    }

    public Person[] AddUser(Person p[], String ID, String Password, String Type, String FirstName, String LastName,
            String Address,
            String Email, String CellPhone) {
        Person newPerson[] = new Person[p.length + 1];
        for (int j = 0; j < p.length; j++) {

            newPerson[j] = p[j];

        }
        if (Type.equals("Reader"))
            newPerson[p.length] = new Reader(ID, Password, Type, FirstName, LastName, Address, Email, CellPhone,
                    false);
        else
            newPerson[p.length] = new Librarian(ID, Password, Type, FirstName, LastName, Address, Email, CellPhone,
                    false);

        return newPerson;
    }

}
