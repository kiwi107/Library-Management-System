
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

    public Books[] DeleteBook(VBox vbox, Books b[], int index, Text bookName, Text authorName, Text publishDate,
            HBox buttoms) {
        // remove from GUI
        vbox.getChildren().removeAll(bookName, authorName, publishDate, buttoms);
        // remove from bay
        // Books newB[] = new Books[b.length - 1];
        // int c = 0;

        // for (int d = 0; d < b.length; d++) {
        // if (d != index) {
        // newB[c] = b[d];
        // c++;
        // }
        // }

        // b = newB;
        // return b;

        // if (b == null || index < 0
        // || index >= b.length) {

        // return b;
        // }

        // Create another bay of size one less
        Books[] newB = new Books[b.length - 1];

        // Copy the elements except the index
        // from original bay to the other bay
        for (int i = 0, k = 0; i < b.length; i++) {

            // if the index is
            // the removal element index
            if (i == index) {
                continue;
            }

            // if the index is not
            // the removal element index
            newB[k++] = b[i];
        }

        // return the resultant bay
        return newB;

    }

    public void RentBook() {

    }

}
