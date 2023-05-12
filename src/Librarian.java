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
    private Books rentedBooks[];
    private Books BoughtBooks[];
    private int total = 0;

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Librarian() {
        super();
    }

    public Librarian(String ID, String Password, String Type, String FirstName, String LastName, String Address,
            String Email, String CellPhone, boolean isBlocked) {
        super(ID, Password, Type, FirstName, LastName, Address, Email, CellPhone, isBlocked);
        rentedBooks = new Books[0];
        BoughtBooks = new Books[0];

    }

    public Books[] getRentedBooks() {
        return this.rentedBooks;
    }

    public Books[] getBoughtBooks() {
        return this.BoughtBooks;
    }

    // setter for rented books
    public void setRentedBooks(Books[] rentedBooks) {
        this.rentedBooks = rentedBooks;
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
        total = total - p[LoggedInUser].getRentedBooks()[index].getPrice();

        return newB;
    }

    // called in the book scene & it adds the book to the rented books array
    public void RentBook(Librarian p[], Books b[], int LoggedInUser, int index) {
        Books newRented[] = new Books[rentedBooks.length + 1];
        for (int j = 0; j < rentedBooks.length; j++) {
            newRented[j] = rentedBooks[j];
        }

        newRented[rentedBooks.length] = b[index];
        rentedBooks = newRented;
        total = total + rentedBooks[rentedBooks.length - 1].getPrice();

    }

    public void checkout(Librarian p[], int LoggedInUser) {
        Books newBoughtBooks[] = new Books[rentedBooks.length];
        for (int i = 0; i < rentedBooks.length; i++) {
            newBoughtBooks[i] = rentedBooks[i];
        }
        Books bothArrays[] = new Books[BoughtBooks.length + newBoughtBooks.length];
        // concatenating array to save the bought books from previous purchases
        System.arraycopy(BoughtBooks, 0, bothArrays, 0, BoughtBooks.length);
        System.arraycopy(newBoughtBooks, 0, bothArrays, BoughtBooks.length, newBoughtBooks.length);
        BoughtBooks = bothArrays;

    }

    // called in the profile scene & it displays the rented books array as gui
    public void DisplayRentedBooks(Librarian p[], int LoggedInUser, GridPane gridPane, ScrollPane scrollPane) {
        // VBox rentedVBox;
        int row = 1;
        int col = 0;
        for (int j = 0; j < p[LoggedInUser].getBoughtBooks().length; j++) {

            if (p[LoggedInUser].getBoughtBooks()[j] != null) {
                ImageView imageView = new ImageView(p[LoggedInUser].getBoughtBooks()[j].getImage());
                imageView.setFitWidth(120);
                imageView.setFitHeight(170);
                Text rentedName = new Text(p[LoggedInUser].getBoughtBooks()[j].getName());

                rentedName.setStyle("-fx-font: 17 arial;-fx-font-weight: bold;");

                Text rentedAuther = new Text(p[LoggedInUser].getBoughtBooks()[j].getAuthor());
                rentedAuther.setStyle("-fx-font: 13 arial;");

                Button returnButton = new Button("Return");

                VBox rentedVBox = new VBox(imageView, rentedName, rentedAuther, returnButton);
                rentedVBox.setPadding(new Insets(10, 10, 10, 10));
                final int index = j;
                returnButton.setOnAction(e -> {
                    BoughtBooks = DeleteBook(gridPane, rentedVBox, BoughtBooks, index);
                });

                rentedVBox.setAlignment(Pos.CENTER);

                gridPane.add(rentedVBox, col, row);
                col++;
                // 3 books per column
                if (col == 3) {
                    col = 0;
                    row++;
                }
                // trigger scroll to bottom
                // double maxValue = scrollPane.getVmax();
                // scrollPane.setVvalue(maxValue);

            }

        }
    }

    public Books[] AddBook(Books b[], String name, String author, int price) {
        Books newBook[] = new Books[b.length + 1];
        for (int j = 0; j < b.length; j++) {

            newBook[j] = b[j];

        }
        newBook[b.length] = new Books(name, author, price);
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
