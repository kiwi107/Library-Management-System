import javafx.util.Duration;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
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
    Books b[] = new Books[20];
    Librarian p[] = new Librarian[2];

    public static void main(String[] args) {

        Application.launch(args);

    }

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;

        b[0] = new Books("The Alchemist", "Paulo Coelho", "1988");
        b[1] = new Books("Little Women", "Louisa May", "1968");
        b[2] = new Books("Harry Potter", "J.K.Rowling", "1997");
        b[3] = new Books("The Lord of the Rings", "J.R.R.Tolkien", "1954");
        b[4] = new Books("The Hobbit", "J.R.R.Tolkien", "1937");
        b[5] = new Books("The Da Vinci Code", "Dan Brown", "2003");
        b[6] = new Books("Redeeming Love", "Francine Rivers", "1991");
        b[7] = new Books("The Hunger Games", "Suzanne Collins", "2008");
        b[8] = new Books("The Maze Runner", "James Dashner", "2009");
        b[9] = new Books("The Fault in Our Stars", "John Green", "2012");
        b[10] = new Books("Avatar the last airbender", "Michael Dante DiMartino", "2005");
        b[11] = new Books("The Twilight Saga", "Stephenie Meyer", "2005");
        b[12] = new Books("it ends with us", "Colleen Hoover", "2016");
        b[13] = new Books("Confess", "Colleen Hoover", "2016");
        b[14] = new Books("The Book of Three", "Lloyd Alexander", "1964");
        b[15] = new Books("The Chronicles of Narnia", "C.S.Lewis", "1950");
        b[16] = new Books("Atomic Habits", "James Clear", "2018");
        b[17] = new Books("The Magician's Nephew", "C.S.Lewis", "1955");
        b[18] = new Books("think like a monk", "Jay Shetty", "2019");
        b[19] = new Books("The Silver Chair", "C.S.Lewis", "1953");

        p[0] = new Librarian("21P0223", "k", "Librarian", "Karim", "Sherif", "heliopolis",
                "karim", "01112653391", false);
        p[1] = new Librarian("21P0064", "o", "Librarian", "Omar", "Korkor", "nozha",
                "omar", "01112653391", false);

        FirstScene = CreateFirstScene();
        ShowScene(FirstScene);
        SecondSceneR = Librarian_SignIn_Scene();
        SecondSceneL = Reader_SignIn_Scene();

    }

    void ShowScene(Scene scene) {
        stage.setTitle("Library Management System");
        stage.setScene(scene);
        stage.show();
    }

    private Scene CreateFirstScene() {

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
            ShowScene(SecondSceneR);
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

            ShowScene(SecondSceneL);
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

    private Scene Librarian_SignIn_Scene() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // back to first scene
        Button backButton = new Button("Back");
        HBox backHBox = new HBox(backButton);
        backHBox.setAlignment(Pos.CENTER);
        backButton.setOnAction(event -> {
            ShowScene(FirstScene);
        });

        Text text = new Text("Librarian Sign in");
        Image Image = new Image("img/Librarians.png");
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

        signInButton.setOnAction(event -> {
            // Boolean LoggedIn = false;
            // int LoggedInUser = 0;
            // for (int i = 0; i < p.length; i++) {

            // if (emailField.getText().equals(p[i].getEmail())
            // && passwordField.getText().equals(p[i].getPassword()) &&
            // p[i].getType().equals("Librarian")) {
            // LoggedInUser = i;
            // ThirdSceneR = LibrarianScene(LoggedInUser);
            // ShowScene(ThirdSceneR);
            // LoggedIn = true;
            // break;

            // } else {

            // LoggedIn = false;
            // }

            // }
            // if (LoggedIn == false) {
            // Alert alert = new Alert(AlertType.ERROR);
            // alert.setTitle("Error");
            // alert.setHeaderText("Wrong Email or Password");
            // alert.setContentText("Try again");
            // alert.showAndWait();

            // }

            int LoggedInUser = 0;
            ThirdSceneR = LibrarianScene(LoggedInUser);
            ShowScene(ThirdSceneR);

        });

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
            ShowScene(FirstScene);
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

    private Scene LibrarianScene(int LoggedInUser) {
        BorderPane borderPane = new BorderPane();
        HBox navbar = new HBox();
        navbar.setPrefHeight(40);
        navbar.setPadding(new Insets(5, 0, 5, 30));
        navbar.setStyle("-fx-background-color: #333333;");

        Text title = new Text("Navigation");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        title.setFill(Color.WHITE);

        Button myProfileButton = new Button("My Profile");
        myProfileButton.setStyle("-fx-background-color: #333333; -fx-text-fill: white;");
        myProfileButton.setFont(Font.font("Arial", 17));
        myProfileButton.setPrefWidth(200);
        myProfileButton.setOnAction(event -> {
            GridPane profileGridPane = profile(LoggedInUser, borderPane);
            borderPane.setCenter(profileGridPane);
        });
        // make button by default clicked
        myProfileButton.requestFocus();
        myProfileButton.fire();

        Button usersButton = new Button("Users");
        usersButton.setStyle("-fx-background-color: #333333; -fx-text-fill: white;");
        usersButton.setFont(Font.font("Arial", 17));
        usersButton.setPrefWidth(200);
        usersButton.setOnAction(event -> {
            GridPane usersGridPane = users(LoggedInUser);
            borderPane.setCenter(usersGridPane);
        });

        Button booksButton = new Button("Books");
        booksButton.setStyle("-fx-background-color: #333333; -fx-text-fill: white;");
        booksButton.setFont(Font.font("Arial", 17));
        booksButton.setPrefWidth(200);
        booksButton.setOnAction(event -> {
            ScrollPane booksGridPane = books(LoggedInUser, borderPane);
            borderPane.setCenter(booksGridPane);
        });

        Button signOutButton = new Button("Sign Out");
        signOutButton.setStyle("-fx-background-color: #333333; -fx-text-fill: white;");
        signOutButton.setFont(Font.font("Arial", 17));
        signOutButton.setPrefWidth(200);
        signOutButton.setOnAction(event -> {
            ShowScene(FirstScene);
        });

        navbar.setAlignment(Pos.CENTER);
        navbar.getChildren().addAll(title, myProfileButton, usersButton, booksButton, signOutButton);

        borderPane.setTop(navbar);
        Scene scene = new Scene(borderPane, 1200, 600);
        return scene;

    }

    private GridPane profile(int LoggedInUser, BorderPane borderPane) {
        GridPane gridPane = new GridPane();
        ScrollBar scrollBar = new ScrollBar();
        gridPane.setHgap(80);
        gridPane.setVgap(20);
        gridPane.setPadding(new Insets(20, 20, 20, 20));

        Text personal = new Text("Personal Information");
        personal.setFont(Font.font("Arial", FontWeight.BOLD, 40));

        Font labelFont = Font.font("Arial", FontWeight.BOLD, 20);
        Font valueFont = Font.font("Arial", 20);

        Text ID = new Text("ID: ");
        ID.setFont(labelFont);

        Text IDValue = new Text(p[LoggedInUser].getID());
        IDValue.setFont(valueFont);

        Text Name = new Text("Name: ");
        Name.setFont(labelFont);

        Text nameValue = new Text(p[LoggedInUser].getFirstName() + " " + p[LoggedInUser].getLastName());
        nameValue.setFont(valueFont);

        Text Email = new Text("Email: ");
        Email.setFont(labelFont);

        Text emailValue = new Text(p[LoggedInUser].getEmail());
        emailValue.setFont(valueFont);

        Text Address = new Text("Address: ");
        Address.setFont(labelFont);

        Text addressValue = new Text(p[LoggedInUser].getAddress());
        addressValue.setFont(valueFont);

        Text Phone = new Text("Phone: ");
        Phone.setFont(labelFont);

        Text phoneValue = new Text(p[LoggedInUser].getCellPhone());
        phoneValue.setFont(valueFont);

        Text Type = new Text("Type: ");
        Type.setFont(labelFont);

        Text typeValue = new Text(p[LoggedInUser].getType());
        typeValue.setFont(valueFont);

        HBox idBox = new HBox(ID, IDValue);
        HBox nameBox = new HBox(Name, nameValue);
        HBox emailBox = new HBox(Email, emailValue);
        HBox addressBox = new HBox(Address, addressValue);
        HBox phoneBox = new HBox(Phone, phoneValue);
        HBox typeBox = new HBox(Type, typeValue);

        VBox rentedBox = new VBox();
        Text Rented = new Text("Rented Books");
        Rented.setFont(Font.font("Arial", FontWeight.BOLD, 40));

        rentedBox.getChildren().add(Rented);
        rentedBox.setSpacing(30);
        rentedBox.setPadding(new Insets(10));
        gridPane.add(personal, 0, 0);
        gridPane.add(idBox, 0, 1);
        gridPane.add(nameBox, 0, 2);
        gridPane.add(emailBox, 0, 3);
        gridPane.add(addressBox, 0, 4);
        gridPane.add(phoneBox, 0, 5);
        gridPane.add(typeBox, 0, 6);
        gridPane.add(rentedBox, 1, 0);

        for (int i = 0; i < 6; i++) {
            RowConstraints row = new RowConstraints(50);
            gridPane.getRowConstraints().add(row);
        }

        p[LoggedInUser].DisplayRentedBooks(p, LoggedInUser, gridPane);

        // print array of rented books
        for (int i = 0; i < p[LoggedInUser].getRentedBooks().length; i++) {
            if (p[LoggedInUser].getRentedBooks()[i] != null) {
                System.out.println(p[LoggedInUser].getRentedBooks()[i].getName());

            }
        }

        return gridPane;
    }

    private GridPane users(int LoggedInUser) {
        GridPane gridPane = new GridPane();
        return gridPane;
    }

    private ScrollPane books(int LoggedInUser, BorderPane borderPane) {
        GridPane gridPane = new GridPane();
        int row = 1;
        int col = 0;

        for (int i = 0; i < b.length; i++) {

            Text bookName = new Text(b[i].getName());
            bookName.setFont(Font.font("Arial", FontWeight.BOLD, 20));
            Text bookAuthor = new Text(b[i].getAuthor());
            bookAuthor.setFont(Font.font("Arial", 20));
            Text Date = new Text(b[i].getPublishDate());
            Date.setFont(Font.font("Arial", 20));

            VBox bookInfo = new VBox();
            bookInfo.setSpacing(10);
            bookInfo.setPadding(new Insets(10));

            final int index = i;

            Button rentBook = new Button("Rent");
            rentBook.setOnAction(e -> {
                p[LoggedInUser].RentBook(p, b, LoggedInUser, index);
                GridPane profileGridPane = profile(LoggedInUser, borderPane);
                borderPane.setCenter(profileGridPane);

            });

            Button deleteBook = new Button("Delete");

            HBox buttons = new HBox(rentBook, deleteBook);
            buttons.setSpacing(10);
            deleteBook.setOnAction(e -> {

                b = p[LoggedInUser].DeleteBook(bookInfo, b, index, bookName, bookAuthor, Date, buttons);
                ScrollPane booksGridPane = books(LoggedInUser, borderPane);
                borderPane.setCenter(booksGridPane);

            });

            bookInfo.getChildren().addAll(bookName, bookAuthor, Date, buttons);

            // 5 books per row
            if (col % 4 == 0) {
                row++;
                col = 0;
            }
            col++;

            gridPane.add(bookInfo, col, row);

        }

        ScrollPane scrollPane = new ScrollPane(gridPane); // wrap GridPane in ScrollPane
        scrollPane.setFitToWidth(true);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS); // set vertical scroll bar policy

        // rest of the code remains the same

        return scrollPane;
    }

}
