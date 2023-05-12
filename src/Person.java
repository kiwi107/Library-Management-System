import java.util.Arrays;

import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public abstract class Person {
    private String ID;
    private String Password;
    private String Type;
    private String FirstName;
    private String LastName;
    private String Address;
    private String Email;
    private String CellPhone;
    private boolean isBlocked;
    private Books rentedBooks[];
    private Books BoughtBooks[];
    private int total = 0;

    public Person() {
    }

    public Person(String ID, String Password, String Type, String FirstName, String LastName, String Address,
            String Email, String CellPhone, boolean isBlocked) {
        this.ID = ID;
        this.Password = Password;
        this.Type = Type;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Address = Address;
        this.Email = Email;
        this.CellPhone = CellPhone;
        this.isBlocked = isBlocked;
        rentedBooks = new Books[0];
        BoughtBooks = new Books[0];
    }

    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return this.Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getType() {
        return this.Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getFirstName() {
        return this.FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return this.LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getAddress() {
        return this.Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getCellPhone() {
        return this.CellPhone;
    }

    public void setCellPhone(String CellPhone) {
        this.CellPhone = CellPhone;
    }

    public boolean isIsBlocked() {
        return this.isBlocked;
    }

    public boolean getIsBlocked() {
        return this.isBlocked;
    }

    public void setIsBlocked(boolean isBlocked) {
        this.isBlocked = isBlocked;
    }

    public Books[] getRentedBooks() {
        return this.rentedBooks;
    }

    public Books[] getBoughtBooks() {
        return this.BoughtBooks;
    }

    public void setBoughtBooks(Books[] BoughtBooks) {
        this.BoughtBooks = BoughtBooks;
    }

    public void setRentedBooks(Books[] rentedBooks) {
        this.rentedBooks = rentedBooks;
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    // called in the book scene & it adds the book to the rented books array
    public void RentBook(Person p[], Books b[], int LoggedInUser, int index) {
        Books newRented[] = new Books[rentedBooks.length + 1];
        for (int j = 0; j < rentedBooks.length; j++) {
            newRented[j] = rentedBooks[j];
        }

        newRented[rentedBooks.length] = b[index];
        rentedBooks = newRented;
        // total = total + rentedBooks[rentedBooks.length - 1].getPrice();
        total = total + b[index].getPrice();

    }

    public void removeFromCart(Person p[], int LoggedInUser, GridPane gridpane, HBox bookinfo,
            int index) {
        // remove from GUI
        gridpane.getChildren().remove(bookinfo);

        // remove from array
        Books newB[] = new Books[rentedBooks.length - 1];
        int c = 0;

        for (int i = 0; i < rentedBooks.length; i++) {
            if (i != index) {
                newB[c] = rentedBooks[i];
                c++;

            }

        }
        // p[LoggedInUser].setTotal(getTotal() -
        // p[LoggedInUser].getRentedBooks()[index].getPrice());
        total = total - rentedBooks[index].getPrice();

        rentedBooks = newB;
    }

    public void checkout(Person p[], int LoggedInUser) {
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

    public Books[] searchBooks(Books orgBooks[], Books b[], TextField searchField) {

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

    public void returnBooks(GridPane gridpane, VBox bookinfo, int index) {
        // remove from GUI
        gridpane.getChildren().remove(bookinfo);

        // remove from array
        Books newBoughtBooks[] = new Books[BoughtBooks.length - 1];
        int c = 0;

        for (int d = 0; d < BoughtBooks.length; d++) {
            if (d != index) {
                newBoughtBooks[c] = BoughtBooks[d];
                c++;
            }
        }

        BoughtBooks = newBoughtBooks;
    }
}
