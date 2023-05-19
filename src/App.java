import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {
    private Stage stage;
    private Scene FirstScene;
    private Scene SecondSceneR;
    private Scene SecondSceneL;
    private Scene ThirdSceneR;
    private Scene ThirdSceneL;
    private BorderPane profileBorderPane;
    private GridPane usersGridPane;
    private BorderPane borderPaneBooks;
    private BorderPane cartBorderPane;
    // int LoggedInUser;
    Books b[] = new Books[20];
    Books orgBooks[] = new Books[b.length];
    Person p[] = new Person[4];
    Person orgUsers[] = new Person[p.length];

    public static void main(String[] args) {

        Application.launch(args);

    }

    @Override
    public void start(Stage primaryStage) {

        stage = primaryStage;

        b[0] = new Books("The Alchemist", "Paulo Coelho", 88, "img/avatar.jpeg");
        b[1] = new Books("Little Women", "Louisa May", 68, "img/avatar.jpeg");
        b[2] = new Books("Harry Potter", "J.K.Rowling", 19, "img/avatar.jpeg");
        b[3] = new Books("The Lord of the Rings", "J.R.R.Tolkien", 54, "img/avatar.jpeg");
        b[4] = new Books("The Hobbit", "J.R.R.Tolkien", 37, "img/avatar.jpeg");
        b[5] = new Books("The Da Vinci Code", "Dan Brown", 23, "img/avatar.jpeg");
        b[6] = new Books("Redeeming Love", "Francine Rivers", 99, "img/avatar.jpeg");
        b[7] = new Books("The Hunger Games", "Suzanne Collins", 28, "img/avatar.jpeg");
        b[8] = new Books("The Maze Runner", "James Dashner", 29, "img/avatar.jpeg");
        b[9] = new Books("The Fault in Our Stars", "John Green", 212, "img/avatar.jpeg");
        b[10] = new Books("Avatar the last airbender", "Michael Dante DiMartino", 25, "img/avatar.jpeg");
        b[11] = new Books("The Twilight Saga", "Stephenie Meyer", 25, "img/avatar.jpeg");
        b[12] = new Books("it ends with us", "Colleen Hoover", 216, "img/avatar.jpeg");
        b[13] = new Books("Confess", "Colleen Hoover", 216, "img/avatar.jpeg");
        b[14] = new Books("The Book of Three", "Lloyd Alexander", 196, "img/avatar.jpeg");
        b[15] = new Books("The Chronicles of Narnia", "C.S.Lewis", 1950, "img/avatar.jpeg");
        b[16] = new Books("Atomic Habits", "James Clear", 218, "img/avatar.jpeg");
        b[17] = new Books("The Magician's Nephew", "C.S.Lewis", 195, "img/avatar.jpeg");
        b[18] = new Books("think like a monk", "Jay Shetty", 219, "img/avatar.jpeg");
        b[19] = new Books("The Silver Chair", "C.S.Lewis", 195, "img/avatar.jpeg");

        p[0] = new Librarian("21p0223", "k", "Librarian", "Karim", "Sherif", "heliopolis",
                "karim", "01112342391", false);
        p[1] = new Librarian("21p0065", "o", "Librarian", "Omar", "Korkor", "nozha",
                "omar", "01234343391", false);
        p[2] = new Reader("21p0100", "e", "Reader", "ezz", "eldin", "nozha",
                "ezz", "0114355391", false);
        p[3] = new Reader("21P0105", "a", "Reader", "ali", "refaat", "tagamo3",
                "ali", "01135435545", false);
        // org arrays for search
        for (int j = 0; j < b.length; j++) {
            orgBooks[j] = b[j];
        }
        for (int j = 0; j < p.length; j++) {
            orgUsers[j] = p[j];
        }
        GUI gui = new GUI(stage, p, b, orgBooks, orgUsers);

        FirstScene = gui.CreateFirstScene();
        SecondSceneL = gui.createSecondScene();
        SecondSceneR = gui.createSecondScene();
        ThirdSceneL = gui.createThirdScene();
        showScene(FirstScene);

    }

    void showScene(Scene scene) {
        stage.setTitle("Library Management System");
        stage.setScene(scene);
        stage.show();
    }

}
