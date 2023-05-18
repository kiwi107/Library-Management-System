import javafx.scene.image.Image;

public class Books {
    private Image image;
    private String Name;
    private String Author;
    private int Price;
    private Person rentedBy[];

    public Books(String Name, String Author, int Price, String imagePath) {
        this.Name = Name;
        this.Author = Author;
        this.Price = Price;
        this.image = new Image(imagePath);
        rentedBy = new Person[0];
    }

    public Books(String Name, String Author, int Price) {
        this.Name = Name;
        this.Author = Author;
        this.Price = Price;

    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAuthor() {
        return this.Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public int getPrice() {
        return this.Price;
    }

    public Image getImage() {
        return this.image;
    }

    public Person[] getRentedBy() {
        return this.rentedBy;
    }

    public void setRentedBy(Person rentedBy[]) {
        this.rentedBy = rentedBy;
    }
}