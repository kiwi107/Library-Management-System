import java.util.Arrays;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

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
    public void DisplayRentedBooks(Librarian p[], int LoggedInUser, GridPane gridPane, ScrollPane scrollPane) {
        VBox rentedVBox;
        int row = 1;
        int col = 0;
        for (int j = 0; j < p[LoggedInUser].getRentedBooks().length; j++) {

            if (p[LoggedInUser].getRentedBooks()[j] != null) {
                ImageView imageView = new ImageView(p[LoggedInUser].getRentedBooks()[j].getImage());
                imageView.setFitWidth(120);
                imageView.setFitHeight(170);
                Text rentedName = new Text(p[LoggedInUser].getRentedBooks()[j].getName());

                rentedName.setStyle("-fx-font: 17 arial;-fx-font-weight: bold;");

                Text rentedAuther = new Text(p[LoggedInUser].getRentedBooks()[j].getAuthor());

                rentedAuther.setStyle("-fx-font: 13 arial;");
                Text rentedDate = new Text(p[LoggedInUser].getRentedBooks()[j].getPublishDate());

                rentedDate.setStyle("-fx-font: 13 arial;");
                rentedVBox = new VBox();
                rentedVBox.getChildren().addAll(imageView, rentedName, rentedAuther, rentedDate);
                rentedVBox.setAlignment(Pos.CENTER);

                gridPane.add(rentedVBox, col, row);
                col++;
                // 3 books per column
                if (col == 3) {
                    col = 0;
                    row++;
                }
                // trigger scroll to bottom
                double maxValue = scrollPane.getVmax();
                scrollPane.setVvalue(maxValue);

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

    public Books[] searchBooks(Books orgBooks[], TextField searchField) {

        int foundBooks = 0;
        Books[] newBooks = new Books[orgBooks.length];
        for (int i = 0; i < orgBooks.length; i++) {
            if (orgBooks[i].getName().toLowerCase().contains(searchField.getText().toLowerCase())) {
                newBooks[foundBooks] = orgBooks[i];
                foundBooks++;
            }
        }
        // make size dependable on found books in search
        return Arrays.copyOf(newBooks, foundBooks);
    }

}
