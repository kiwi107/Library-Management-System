
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.scene.text.Text;

public class Librarian extends Person {
    Books Rented[];

    public Librarian() {
        super();
    }

    public Librarian(String ID, String Password, String Type, String FirstName, String LastName, String Address,
            String Email, String CellPhone, boolean isBlocked) {
        super(ID, Password, Type, FirstName, LastName, Address, Email, CellPhone, isBlocked);

    }

    public void DeleteBook(VBox vbox, Books b[], int index, Text bookName, Text authorName, Text publishDate,
            HBox buttoms) {

        vbox.getChildren().removeAll(bookName, authorName, publishDate, buttoms);

    }

    public void RentBook() {

    }

}
