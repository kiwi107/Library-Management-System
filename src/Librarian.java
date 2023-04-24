import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.scene.text.Text;

public class Librarian extends Person {
    private Books rentedBooks[];

    public Librarian() {
        super();
    }

    public Librarian(String ID, String Password, String Type, String FirstName, String LastName, String Address,
            String Email, String CellPhone, boolean isBlocked) {
        super(ID, Password, Type, FirstName, LastName, Address, Email, CellPhone, isBlocked);
        rentedBooks = new Books[10];

    }

    public Books[] getRentedBooks() {
        return this.rentedBooks;
    }

    // called in the book scene & creates a new book array with size -1
    public Books[] DeleteBook(VBox vbox, Books b[], int index, Text bookName, Text authorName, Text publishDate,
            HBox buttoms) {
        // remove from GUI
        vbox.getChildren().removeAll(bookName, authorName, publishDate, buttoms);

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

        // if (b == null || index < 0
        // || index >= b.length) {

        // return b;
        // }

        // // Create another bay of size one less
        // Books[] newB = new Books[b.length - 1];

        // // Copy the elements except the index
        // // from original bay to the other bay
        // for (int i = 0, k = 0; i < b.length; i++) {

        // // if the index is
        // // the removal element index
        // if (i == index) {
        // continue;
        // }

        // // if the index is not
        // // the removal element index
        // newB[k++] = b[i];
        // }

        // // return the resultant bay
        // return newB;

    }

    // called in the book scene & it adds the book to the rented books array
    public void RentBook(Librarian p[], Books b[], int LoggedInUser, int index) {
        for (int j = 0; j < p[LoggedInUser].getRentedBooks().length; j++) {
            if (p[LoggedInUser].getRentedBooks()[j] == null) {
                p[LoggedInUser].getRentedBooks()[j] = b[index];
                break;
            }

        }

    }

    // called in the profile scene & it displays the rented books array as gui
    public void DisplayRentedBooks(Librarian p[], int LoggedInUser, GridPane gridPane) {
        VBox rentedVBox;
        int row = 1;
        int col = 1;
        for (int j = 0; j < p[LoggedInUser].getRentedBooks().length; j++) {

            if (p[LoggedInUser].getRentedBooks()[j] != null) {
                Text rentedName = new Text(p[LoggedInUser].getRentedBooks()[j].getName());

                rentedName.setStyle("-fx-font: 17 arial;-fx-font-weight: bold;");

                Text rentedAuther = new Text(p[LoggedInUser].getRentedBooks()[j].getAuthor());

                rentedAuther.setStyle("-fx-font: 13 arial;");
                Text rentedDate = new Text(p[LoggedInUser].getRentedBooks()[j].getPublishDate());

                rentedDate.setStyle("-fx-font: 13 arial;");
                rentedVBox = new VBox();
                rentedVBox.getChildren().addAll(rentedName, rentedAuther, rentedDate);

                gridPane.add(rentedVBox, col, row);
                row++;
                // 6 books per column
                if (row == 7) {
                    row = 1;
                    col++;
                }

                // break;
            }

        }
    }

}
