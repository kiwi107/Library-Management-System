public class Books {
    String Name;
    String Author;
    String publishDate;

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

}