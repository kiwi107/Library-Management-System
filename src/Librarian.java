import java.util.Arrays;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

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
    public Books[] DeleteBook(Librarian p[], int LoggedInUser, GridPane gridpane, HBox bookinfo, Books b[], int index) {
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
        p[LoggedInUser].setTotal(getTotal() - p[LoggedInUser].getRentedBooks()[index].getPrice());

        return newB;
    }

    public Books[] AddBook(Books b[], String name, String author, int price) {
        Books newBook[] = new Books[b.length + 1];
        for (int j = 0; j < b.length; j++) {

            newBook[j] = b[j];

        }
        newBook[b.length] = new Books(name, author, price);
        return newBook;

    }

}
