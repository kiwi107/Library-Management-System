import javafx.animation.ScaleTransition;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GUI {
    Librarian librarian;
    Books books;
    Stage stage;
    Scene scene;

    // constructor
    public GUI(Stage stage, Scene scene) {
        this.stage = stage;
    }

    // public void showScene(Scene scene) {

    // }

    public Scene CreateFirstScene(Scene SecondSceneL, Scene SecondSceneR) {
        Text title = new Text("Welcome to Library Management System");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 50));
        // librarians buttons
        Image librariansImage = new Image("img/Librarians.png");
        ImageView librariansView = new ImageView(librariansImage);
        librariansView.setFitWidth(300);
        librariansView.setFitHeight(300);

        Text librariansText = new Text("sign in as Librarian");
        librariansText.setFont(Font.font("Arial", 15));

        Button Lsignin = new Button();
        Lsignin.setStyle("-fx-background-color: #ffffff; -fx-border-color: black; -fx-border-width: 2px;");

        // hover effect
        Lsignin.setOnMouseEntered(event -> {
            ScaleTransition scaleTransition = new ScaleTransition();
            scaleTransition.setNode(Lsignin);
            Lsignin.setStyle("-fx-background-color: #ffffff; -fx-border-color: darkblue; -fx-border-width: 2px;");
            scaleTransition.setDuration(Duration.millis(300));
            scaleTransition.setToX(1.05);
            scaleTransition.setToY(1.05);
            scaleTransition.play();
        });
        Lsignin.setOnMouseExited(event -> {
            ScaleTransition scaleTransition = new ScaleTransition();
            scaleTransition.setNode(Lsignin);
            Lsignin.setStyle("-fx-background-color: #ffffff; -fx-border-color: black; -fx-border-width: 2px;");
            scaleTransition.setDuration(Duration.millis(300));
            scaleTransition.setToX(1.0);
            scaleTransition.setToY(1.0);
            scaleTransition.play();
        });

        VBox LibVbox = new VBox();
        LibVbox.getChildren().addAll(librariansView, librariansText);
        LibVbox.setAlignment(Pos.CENTER);
        Lsignin.setGraphic(LibVbox);

        Lsignin.setOnAction(e -> {
            stage.setTitle("Library Management System");
            stage.setScene(SecondSceneL);
            stage.show();
        });

        // readers buttons
        Image readersImage = new Image("img/Reader.png");
        ImageView readersView = new ImageView(readersImage);
        readersView.setFitWidth(300);
        readersView.setFitHeight(300);
        Text readerText = new Text("Sign in as Reader");
        readerText.setFont(Font.font("Arial", 15));
        Button Rsignin = new Button();
        Rsignin.setStyle("-fx-background-color: #ffffff;-fx-border-color: black; -fx-border-width: 2px;");

        Rsignin.setOnMouseEntered(event -> {
            ScaleTransition scaleTransition = new ScaleTransition();
            scaleTransition.setNode(Rsignin);
            Rsignin.setStyle("-fx-background-color: #ffffff; -fx-border-color: darkblue; -fx-border-width: 2px;");

            scaleTransition.setDuration(Duration.millis(300));
            scaleTransition.setToX(1.05);
            scaleTransition.setToY(1.05);
            scaleTransition.play();
        });

        Rsignin.setOnMouseExited(event -> {
            ScaleTransition scaleTransition = new ScaleTransition();
            scaleTransition.setNode(Rsignin);
            Rsignin.setStyle("-fx-background-color: #ffffff; -fx-border-color: black; -fx-border-width: 2px;");
            scaleTransition.setDuration(Duration.millis(300));
            scaleTransition.setToX(1.0);
            scaleTransition.setToY(1.0);
            scaleTransition.play();
        });
        VBox ReaderVbox = new VBox();
        ReaderVbox.getChildren().addAll(readersView, readerText);
        ReaderVbox.setAlignment(Pos.CENTER);
        Rsignin.setGraphic(ReaderVbox);

        Rsignin.setOnAction(e -> {

            stage.setTitle("Library Management System");
            stage.setScene(SecondSceneR);
            stage.show();
        });

        HBox row0 = new HBox();
        row0.getChildren().addAll(title);
        row0.setAlignment(Pos.CENTER);

        HBox row1 = new HBox();
        row1.getChildren().addAll(Lsignin, Rsignin);
        row1.setAlignment(Pos.CENTER);
        row1.setSpacing(100);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(row0, row1);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(50);
        return new Scene(vBox, 1200, 600);
    }
}
