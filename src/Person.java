import java.util.Arrays;

import javafx.scene.control.TextField;

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

    // setterfor
    public void setBoughtBooks(Books[] BoughtBooks) {
        this.BoughtBooks = BoughtBooks;
    }

    // setter for rented books
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
