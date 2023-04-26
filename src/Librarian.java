import java.util.Arrays;

import javafx.scene.control.TextField;
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

    public Books[] AddBook(Books b[], String name, String author, String publishDate) {
        Books newBook[] = new Books[b.length + 1];
        for (int j = 0; j < b.length; j++) {

            newBook[j] = b[j];

        }
        newBook[b.length] = new Books(name, author, publishDate);
        return newBook;

    }

    public Books[] searchBooks(Books[] orgBooks, TextField searchField) {
        int j = 0;
        Books[] newBooks = new Books[orgBooks.length];
        for (int i = 0; i < orgBooks.length; i++) {
            if (orgBooks[i].getName().toLowerCase().contains(searchField.getText().toLowerCase())) {
                newBooks[j] = orgBooks[i];
                j++;
            }
        }
        // make size dependable on search
        return Arrays.copyOf(newBooks, j);
    }

}
