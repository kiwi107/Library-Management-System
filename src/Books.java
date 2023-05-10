import javafx.scene.image.Image;

public class Books {
    private Image image;
    private String Name;
    private String Author;
    private String publishDate;

    public Books(String Name, String Author, String publishDate, String imagePath) {
        this.Name = Name;
        this.Author = Author;
        this.publishDate = publishDate;
        this.image = new Image(imagePath);
    }

    public Books(String Name, String Author, String publishDate) {
        this.Name = Name;
        this.Author = Author;
        this.publishDate = publishDate;

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

    public String getPublishDate() {
        return this.publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public Image getImage() {
        return this.image;
    }
}