import java.util.Arrays;
import javafx.util.Duration;
import javafx.animation.ScaleTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUI {
    private Stage stage;
    private Scene firstScene;
    private Scene secondSceneL;
    private Scene secondSceneR;
    private Scene thirdSceneL;
    private Scene thirdSceneR;
    private BorderPane profileBorderPane;
    private GridPane usersGridPane;
    private BorderPane borderPaneBooks;
    private BorderPane borderPaneCart;
    private Person p[];
    private Books b[];
    private Books orgBooks[];
    private int LoggedInUser;
    private Librarian librarian;
    private boolean isLibrarian;
    private boolean iscart;

    public GUI(Stage stage, Person p[], Books b[], Books orgBooks[]) {
        this.stage = stage;
        this.p = p;
        this.b = b;
        this.orgBooks = orgBooks;

    }

    public void showScene(Scene scene) {
        stage.setTitle("Library Management System");
        stage.setScene(scene);
        stage.show();

    }

    public Scene CreateFirstScene() {
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
            isLibrarian = true;
            secondSceneL = createSecondScene();
            showScene(secondSceneL);
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
            isLibrarian = false;
            secondSceneR = createSecondScene();
            showScene(secondSceneR);
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
        firstScene = new Scene(vBox, 1200, 600);
        return firstScene;
    }

    public Scene createSecondScene() {

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // back to first scene
        Button backButton = new Button("Back");
        HBox backHBox = new HBox(backButton);
        backHBox.setAlignment(Pos.CENTER);
        backButton.setOnAction(event -> {
            showScene(firstScene);
        });

        Text text;
        Image Image;

        if (isLibrarian) {
            text = new Text("Librarian Sign in");
            Image = new Image("img/Librarians.png");
        } else {
            text = new Text("Reader Sign in");
            Image = new Image("img/Reader.png");
        }
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

            Boolean LoggedIn = false;
            for (int i = 0; i < p.length; i++) {
                if (isLibrarian) {
                    if (emailField.getText().equals(p[i].getEmail())
                            && passwordField.getText().equals(p[i].getPassword()) &&
                            p[i].getType().equals("Librarian")) {
                        LoggedInUser = i;
                        thirdSceneR = createThirdScene();
                        showScene(thirdSceneR);
                        LoggedIn = true;
                        break;

                    } else {

                        LoggedIn = false;
                    }
                } else {
                    if (emailField.getText().equals(p[i].getEmail())
                            && passwordField.getText().equals(p[i].getPassword()) &&
                            p[i].getType().equals("Reader")) {
                        LoggedInUser = i;
                        thirdSceneR = createThirdScene();
                        showScene(thirdSceneR);
                        LoggedIn = true;
                        break;

                    } else {

                        LoggedIn = false;
                    }
                }

            }
            if (LoggedIn == false) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Wrong Email or Password");
                if (isLibrarian) {
                    alert.setContentText("Try again, and make sure you are a librarian");
                } else {
                    alert.setContentText("Try again, and make sure you are a reader");
                }

                alert.showAndWait();

            }

            if (p[LoggedInUser] instanceof Librarian) {
                librarian = (Librarian) p[LoggedInUser];

            }

            // thirdSceneR = LibrarianScene();
            // showScene(thirdSceneL);

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

        if (isLibrarian) {
            secondSceneL = new Scene(stackPane, 1200, 600);
            return secondSceneL;
        } else {

            secondSceneR = new Scene(stackPane, 1200, 600);
            return secondSceneR;

        }
        // secondSceneL = new Scene(stackPane, 1200, 600);
        // return secondSceneL;
    }

    public Scene createThirdScene() {
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
            BorderPane infoGridPane = profile(borderPane);
            borderPane.setCenter(infoGridPane);
        });

        Button usersButton = new Button("Users");
        usersButton.setStyle("-fx-background-color: #333333; -fx-text-fill: white;");
        usersButton.setFont(Font.font("Arial", 17));
        usersButton.setPrefWidth(200);
        usersButton.setOnAction(event -> {
            GridPane usersGridPane = users();
            borderPane.setCenter(usersGridPane);
        });

        Button booksButton = new Button("Books");
        booksButton.setStyle("-fx-background-color: #333333; -fx-text-fill: white;");
        booksButton.setFont(Font.font("Arial", 17));
        booksButton.setPrefWidth(200);
        booksButton.setOnAction(event -> {
            BorderPane booksBorderPane = books(borderPane);
            borderPane.setCenter(booksBorderPane);
        });

        Button signOutButton = new Button("Sign Out");
        signOutButton.setStyle("-fx-background-color: #333333; -fx-text-fill: white;");
        signOutButton.setFont(Font.font("Arial", 17));
        signOutButton.setPrefWidth(200);
        signOutButton.setOnAction(event -> {

            showScene(firstScene);
        });

        Button cartButton = new Button("Cart");
        cartButton.setStyle("-fx-background-color: #333333; -fx-text-fill: white;");
        cartButton.setFont(Font.font("Arial", 17));
        cartButton.setPrefWidth(200);
        cartButton.setOnAction(event -> {
            if (iscart) {
                borderPane.setRight(null);
                iscart = false;
            } else {
                BorderPane cartScrollPane = Cart(borderPane);
                cartScrollPane.setPrefWidth(300);

                cartScrollPane.setStyle("-fx-border-color: #333333; -fx-border-width: 2px;");

                borderPane.setRight(cartScrollPane);
                iscart = true;
            }

        });

        // make button by default clicked
        myProfileButton.requestFocus();
        myProfileButton.fire();

        navbar.setAlignment(Pos.CENTER);
        if (isLibrarian == false) {
            navbar.getChildren().addAll(title, myProfileButton, booksButton, cartButton, signOutButton);

        } else {
            navbar.getChildren().addAll(title, myProfileButton, usersButton, booksButton, cartButton, signOutButton);
        }

        borderPane.setTop(navbar);
        thirdSceneL = new Scene(borderPane, 1200, 600);
        return thirdSceneL;
    }

    public BorderPane profile(BorderPane borderPane) {
        GridPane infoGridPane = new GridPane();
        infoGridPane.setPadding(new Insets(20));

        GridPane rentedGridPane = new GridPane();
        rentedGridPane.setHgap(30);
        rentedGridPane.setVgap(20);
        rentedGridPane.setAlignment(Pos.CENTER);

        infoGridPane.setVgap(20);

        Label infoText = new Label("Personal Info");
        infoText.setPadding(new Insets(10));
        infoText.setFont(Font.font("Arial", FontWeight.BOLD, 40));

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

        Label rentedText = new Label("Rented Books");
        rentedText.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        rentedText.setPadding(new Insets(10, 10, 10, 40));

        infoGridPane.add(idBox, 0, 0);
        infoGridPane.add(nameBox, 0, 1);
        infoGridPane.add(emailBox, 0, 2);
        infoGridPane.add(addressBox, 0, 3);
        infoGridPane.add(phoneBox, 0, 4);
        infoGridPane.add(typeBox, 0, 5);

        for (int i = 0; i < 5; i++) {
            RowConstraints row = new RowConstraints(50);
            infoGridPane.getRowConstraints().add(row);
        }
        ScrollPane infoScrollPane = new ScrollPane(infoGridPane);
        infoScrollPane.setFitToWidth(true);
        BorderPane infoBorderPane = new BorderPane();
        infoBorderPane.setStyle("-fx-border-color: #333333; -fx-border-width: 2px;");
        infoBorderPane.setTop(infoText);
        infoBorderPane.setCenter(infoScrollPane);

        BorderPane rentedBorderPane = new BorderPane();
        rentedBorderPane.setStyle("-fx-border-color: #333333; -fx-border-width: 2px;");
        rentedBorderPane.setTop(rentedText);

        ScrollPane rentedScrollPane = new ScrollPane(rentedGridPane);
        rentedScrollPane.setFitToWidth(true);

        rentedBorderPane.setCenter(rentedScrollPane);

        profileBorderPane = new BorderPane();
        profileBorderPane.setLeft(infoBorderPane);
        profileBorderPane.setCenter(rentedBorderPane);

        int row = 1;
        int col = 0;

        for (int j = 0; j < p[LoggedInUser].getBoughtBooks().length; j++) {

            ImageView imageView = new ImageView(p[LoggedInUser].getBoughtBooks()[j].getImage());
            imageView.setFitWidth(120);
            imageView.setFitHeight(170);
            Text rentedName = new Text(p[LoggedInUser].getBoughtBooks()[j].getName());

            rentedName.setStyle("-fx-font: 17 arial;-fx-font-weight: bold;");

            Text rentedAuther = new Text(p[LoggedInUser].getBoughtBooks()[j].getAuthor());
            rentedAuther.setStyle("-fx-font: 13 arial;");

            Button returnButton = new Button("Return");

            VBox rentedVBox = new VBox(imageView, rentedName, rentedAuther, returnButton);
            rentedVBox.setPadding(new Insets(10, 10, 10, 10));
            final int index = j;
            returnButton.setOnAction(e -> {
                p[LoggedInUser].returnBooks(rentedGridPane, rentedVBox, index);
                BorderPane profilBorderPane = profile(borderPane);
                borderPane.setCenter(profilBorderPane);
            });

            rentedVBox.setAlignment(Pos.CENTER);

            rentedGridPane.add(rentedVBox, col, row);
            col++;
            // 3 books per column
            if (col == 3) {
                col = 0;
                row++;
            }

        }

        return profileBorderPane;
    }

    public GridPane users() {
        usersGridPane = new GridPane();
        return usersGridPane;
    }

    public BorderPane books(BorderPane borderPane) {
        borderPaneBooks = new BorderPane();
        ScrollPane scrollPaneBooks = new ScrollPane();
        GridPane gridPane = new GridPane();

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(15);
        int row = 0;
        int col = 0;

        for (int i = 0; i < b.length; i++) {
            final int index = i;// setonaction msh radia ta5od 3'ir final? tb ezzay w final mabtt3'airsh!!!

            ImageView imageView = new ImageView(b[i].getImage());
            imageView.setFitWidth(120);
            imageView.setFitHeight(170);
            Text bookName = new Text(b[i].getName());
            bookName.setFont(Font.font("Arial", FontWeight.BOLD, 13));
            Text bookAuthor = new Text(b[i].getAuthor());
            bookAuthor.setFont(Font.font("Arial", 10));
            Text price = new Text(String.valueOf(b[i].getPrice()));
            price.setFont(Font.font("Arial", 10));

            Button deleteBook = new Button("Delete");
            Button rentBook = new Button("Rent");
            HBox buttons;
            if (isLibrarian == false) {

                buttons = new HBox(rentBook);
            } else {
                buttons = new HBox(rentBook, deleteBook);
            }

            buttons.setAlignment(Pos.CENTER);
            buttons.setSpacing(10);

            VBox bookInfo = new VBox(imageView, bookName, bookAuthor, price, buttons);
            bookInfo.setSpacing(10);
            bookInfo.setPadding(new Insets(10));
            bookInfo.setAlignment(Pos.CENTER);

            rentBook.setOnAction(e -> {
                p[LoggedInUser].RentBook(p, b, LoggedInUser, index);
                BorderPane cartScrollPane = Cart(borderPane);
                cartScrollPane.setPrefWidth(300);
                cartScrollPane.setStyle("-fx-border-color: #333333; -fx-border-width: 2px;");
                borderPane.setRight(cartScrollPane);
                iscart = true;

            });

            deleteBook.setOnAction(e -> {
                b = librarian.DeleteBook(gridPane, bookInfo, b, index);
                BorderPane booksGridPane = books(borderPane);
                borderPane.setCenter(booksGridPane);
                orgBooks = Arrays.copyOf(b, b.length);

            });

            // 7 books per column
            if (col % 5 == 0) {
                row++;
                col = 0;
            }
            col++;

            gridPane.add(bookInfo, col, row);

        }

        Button addBook = new Button("Add Book");
        addBook.setOnAction(e -> {
            b = orgBooks;// solves the problem of adding book during search
            // without the books was being added to the search results not the originalarray

            Label nameLabel = new Label("Book Name");
            TextField nameField = new TextField();

            Label autherLabel = new Label("Book Author");
            TextField autherField = new TextField();

            Label priceLabel = new Label("price");
            TextField priceField = new TextField();

            Button addButton = new Button("Add Book");
            GridPane addBookGridPane = new GridPane();
            addBookGridPane.add(nameLabel, 0, 0);
            addBookGridPane.add(nameField, 1, 0);
            addBookGridPane.add(autherLabel, 0, 1);
            addBookGridPane.add(autherField, 1, 1);
            addBookGridPane.add(priceLabel, 0, 2);
            addBookGridPane.add(priceField, 1, 2);
            addBookGridPane.add(addButton, 1, 3);
            Stage addBookStage = new Stage();
            Scene addBookScene = new Scene(addBookGridPane, 300, 200);
            addBookStage.setScene(addBookScene);
            addBookStage.show();

            addButton.setOnAction(e1 -> {
                b = librarian.AddBook(b, nameField.getText(), autherField.getText(),
                        Integer.parseInt(priceField.getText()));
                addBookStage.close();

                BorderPane addBookScrollPane = books(borderPane);
                borderPane.setCenter(addBookScrollPane);

                // trigger scroll to bottom
                double maxValue = scrollPaneBooks.getVmax();
                scrollPaneBooks.setVvalue(maxValue);

                orgBooks = Arrays.copyOf(b, b.length);// update orgBooks array
            });

        });

        Button searchButton = new Button("search");
        TextField searchField = new TextField();

        HBox searchBox = new HBox(searchField, searchButton);
        searchBox.setSpacing(10);
        Region region = new Region();
        HBox.setHgrow(region, Priority.ALWAYS);
        HBox Add_Search = new HBox(addBook, region, searchBox);

        Add_Search.setPadding(new Insets(20, 20, 20, 20));

        searchButton.setOnAction(e -> {

            b = p[LoggedInUser].searchBooks(orgBooks, b, searchField);
            if (b.length == 0) {

                Text errorMessage = new Text("No books are found");
                errorMessage.setFont(Font.font("Arial", FontWeight.BOLD, 20));
                HBox errorBox = new HBox(errorMessage);
                errorBox.setPadding(new Insets(20, 20, 20, 20));
                errorBox.setAlignment(Pos.CENTER);

                VBox sr = new VBox(Add_Search, errorBox);
                sr.setSpacing(40);

                borderPane.setCenter(sr);

            } else {
                BorderPane booksGridPane = books(borderPane);
                borderPane.setCenter(booksGridPane);
            }

        });
        if (isLibrarian == false) {
            addBook.setVisible(false);

        }

        scrollPaneBooks.setContent(gridPane);
        scrollPaneBooks.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER); // Disable horizontal scroll bar
        scrollPaneBooks.setFitToWidth(true);
        scrollPaneBooks.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        borderPaneBooks.setCenter(scrollPaneBooks);

        borderPaneBooks.setTop(Add_Search);

        return borderPaneBooks;
    }

    public BorderPane Cart(BorderPane borderPane) {
        borderPaneCart = new BorderPane();

        Label cartText = new Label("Cart");
        cartText.setPadding(new Insets(10));

        cartText.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        Button hideButton = new Button("X");
        hideButton.setOnAction(event -> {
            borderPane.setRight(null);
        });
        Region region = new Region();
        HBox.setHgrow(region, Priority.ALWAYS);
        borderPaneCart.setTop(new HBox(cartText, region, hideButton));

        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20));
        ScrollPane scrollPane = new ScrollPane(gridPane);

        int row = 0;
        int col = 0;
        for (int j = 0; j < p[LoggedInUser].getRentedBooks().length; j++) {

            if (p[LoggedInUser].getRentedBooks()[j] != null) {
                ImageView imageView = new ImageView(p[LoggedInUser].getRentedBooks()[j].getImage());
                imageView.setFitWidth(60);
                imageView.setFitHeight(100);

                Text rentedName = new Text(p[LoggedInUser].getRentedBooks()[j].getName());
                rentedName.setStyle("-fx-font: 13 arial;-fx-font-weight: bold;");

                Text rentedDate = new Text(String.valueOf(p[LoggedInUser].getRentedBooks()[j].getPrice()) + " EGP");

                rentedDate.setStyle("-fx-font: 13 arial;");
                Button deleteButton = new Button("Delete");

                VBox rentedVBox = new VBox(rentedName, rentedDate);
                rentedVBox.setAlignment(Pos.CENTER);
                Region region2 = new Region();
                HBox.setHgrow(region2, Priority.ALWAYS);
                HBox rentedHBox = new HBox(imageView, rentedVBox, region2, deleteButton);
                rentedHBox.setAlignment(Pos.CENTER_LEFT);
                rentedHBox.setPrefWidth(250);

                final int index = j;
                deleteButton.setOnAction(e -> {

                    p[LoggedInUser].removeFromCart(p, LoggedInUser, gridPane, rentedHBox, index);
                    BorderPane cartScrollPane = Cart(borderPane);
                    cartScrollPane.setPrefWidth(300);
                    cartScrollPane.setStyle("-fx-border-color: #333333; -fx-border-width: 2px;");
                    borderPane.setRight(cartScrollPane);

                });

                rentedHBox.setAlignment(Pos.CENTER);

                gridPane.add(rentedHBox, col, row);
                row++;

            }

        }
        Label totalText = new Label("Total: " + String.valueOf(p[LoggedInUser].getTotal()) + " EGP");
        totalText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        Button checkoutButton = new Button("Checkout");
        checkoutButton.setOnAction(e -> {
            p[LoggedInUser].checkout(p, LoggedInUser);

            // empty rented books array & total to be ready for another transcation
            p[LoggedInUser].setRentedBooks(new Books[0]);
            p[LoggedInUser].setTotal(0);

            borderPaneCart.setBottom(null);
            Label confirmation = new Label("Transcation Completed");
            Label confirmation2 = new Label("go to profile to view your books");
            confirmation.setFont(Font.font("Arial", FontWeight.BOLD, 20));
            confirmation2.setFont(Font.font("Arial", FontWeight.BOLD, 17));

            Button goToProfile = new Button("Go to Profile");
            goToProfile.setOnAction(event -> {
                BorderPane profileBorderPane = profile(borderPane);
                borderPane.setCenter(profileBorderPane);
                borderPane.setRight(null);

            });
            VBox confirmationVBox = new VBox(confirmation, confirmation2, goToProfile);
            confirmationVBox.setAlignment(Pos.CENTER);
            borderPaneCart.setCenter(confirmationVBox);
        });
        VBox cartButton = new VBox(totalText, checkoutButton);
        cartButton.setAlignment(Pos.CENTER);
        checkoutButton.setPadding(new Insets(10));
        totalText.setPadding(new Insets(10));
        borderPaneCart.setBottom(cartButton);
        borderPaneCart.setCenter(scrollPane);
        if (p[LoggedInUser].getRentedBooks().length == 0) {
            Label emptyCart = new Label("Your cart is empty");
            Label emptyCart2 = new Label("Go to books");
            Label emptyCart3 = new Label("to start shoping");
            VBox emptyCartVBox = new VBox(emptyCart, emptyCart2, emptyCart3);
            emptyCartVBox.setAlignment(Pos.CENTER);
            emptyCart.setFont(Font.font("Arial", FontWeight.BOLD, 20));
            emptyCart2.setFont(Font.font("Arial", FontWeight.BOLD, 20));
            emptyCart3.setFont(Font.font("Arial", FontWeight.BOLD, 20));
            borderPaneCart.setCenter(emptyCartVBox);
            borderPaneCart.setBottom(null);
        }

        return borderPaneCart;
    }

}
