import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
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
    int LoggedInUser;
    Books b[] = new Books[20];
    Books orgBooks[] = new Books[b.length];
    Librarian p[] = new Librarian[2];

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

        for (int j = 0; j < b.length; j++) {
            orgBooks[j] = b[j];
        }

        p[0] = new Librarian("21P0223", "k", "Librarian", "Karim", "Sherif", "heliopolis",
                "karim", "01112653391", false);
        p[1] = new Librarian("21P0064", "o", "Librarian", "Omar", "Korkor", "nozha",
                "omar", "01112653391", false);

        GUI gui = new GUI(stage, p, b, LoggedInUser, orgBooks);
        FirstScene = gui.CreateFirstScene();
        SecondSceneL = gui.Librarian_SignIn_Scene();
        SecondSceneR = Reader_SignIn_Scene();
        ThirdSceneR = gui.LibrarianScene();
        showScene(FirstScene);

    }

    void showScene(Scene scene) {
        stage.setTitle("Library Management System");
        stage.setScene(scene);
        stage.show();
    }

    private Scene Reader_SignIn_Scene() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // back to first scene
        Button backButton = new Button("Back");
        HBox backHBox = new HBox(backButton);
        backHBox.setAlignment(Pos.CENTER);
        backButton.setOnAction(event -> {
            showScene(FirstScene);
        });

        Text text = new Text("Reader Sign in");
        Image Image = new Image("img/Reader.png");
        ImageView View = new ImageView(Image);
        View.setFitWidth(300);
        View.setFitHeight(300);

        VBox titleBox = new VBox(text, View);
        titleBox.setAlignment(Pos.CENTER);
        titleBox.setSpacing(10);

        text.setFont(Font.font("Arial", FontWeight.BOLD, 50));

        Label emailLabel = new Label("Email");
        TextField emailField = new TextField();

        Label passwordLabel = new Label("Password");
        PasswordField passwordField = new PasswordField();

        Button signInButton = new Button("Sign In");

        HBox hBox = new HBox(signInButton);
        hBox.setAlignment(Pos.CENTER);

        gridPane.add(titleBox, 0, 0, 2, 1);
        gridPane.add(emailLabel, 0, 2);
        gridPane.add(emailField, 1, 2);
        gridPane.add(passwordLabel, 0, 3);
        gridPane.add(passwordField, 1, 3);
        gridPane.add(hBox, 0, 5, 2, 1);
        gridPane.add(backHBox, 0, 6, 2, 1);

        Rectangle rectangle = new Rectangle(700, 560, Color.TRANSPARENT);
        rectangle.setStroke(Color.BLACK);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(rectangle, gridPane);
        stackPane.setPrefSize(rectangle.getWidth(), rectangle.getHeight());
        return new Scene(stackPane, 1200, 600);

    }

}
