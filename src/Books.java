import javafx.scene.image.Image;

public class Books {
    private Image image;
    private String Name;
    private String Author;
    private int Price;

    public Books(String Name, String Author, int Price, String imagePath) {
        this.Name = Name;
        this.Author = Author;
        this.Price = Price;
        this.image = new Image(imagePath);
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
}