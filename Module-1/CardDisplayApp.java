import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class CardDisplayApp extends Application {

    private static final int NUM_CARDS = 52;
    private static final int CARDS_TO_DISPLAY = 4;
    private static final String CARD_PATH = "cards"; // folder should be in project root

    private HBox cardBox;

    @Override
    public void start(Stage primaryStage) {
        // Main layout
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);

        // Box for displaying cards
        cardBox = new HBox(10);
        cardBox.setAlignment(Pos.CENTER);

        // Button to refresh cards
        Button refreshButton = new Button("Refresh");

        // Load initial cards
        displayRandomCards();

        // Lambda expression for refresh button action
        refreshButton.setOnAction(e -> displayRandomCards());

        root.getChildren().addAll(cardBox, refreshButton);

        Scene scene = new Scene(root, 500, 300);
        primaryStage.setTitle("Random Card Display");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Function to randomly display 4 cards
    private void displayRandomCards() {
        cardBox.getChildren().clear();

        ArrayList<Integer> cardNumbers = new ArrayList<>();
        for (int i = 1; i <= NUM_CARDS; i++) {
            cardNumbers.add(i);
        }

        Collections.shuffle(cardNumbers);

        for (int i = 0; i < CARDS_TO_DISPLAY; i++) {
            String imagePath = CARD_PATH + "/" + cardNumbers.get(i) + ".png";
            File file = new File(imagePath);
            if (file.exists()) {
                Image image = new Image(file.toURI().toString());
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(100);
                imageView.setPreserveRatio(true);
                cardBox.getChildren().add(imageView);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
