/**
 * Name: Amit Rizal
 * Date: 04/26/2025
 * Assignment: Module 7 Programming Assignment - Four Circles with CSS
 * Purpose: This program displays four circles using external CSS for styling, demonstrating
 *          the use of JavaFX style classes and IDs.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class FourCirclesCSS extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create 4 circles
        Circle c1 = new Circle(50);
        c1.getStyleClass().add("plaincircle"); // class for white fill/black stroke

        Circle c2 = new Circle(50);
        c2.setId("redcircle"); // id for red fill/red stroke

        Circle c3 = new Circle(50);
        c3.setId("greencircle"); // id for green fill/green stroke

        Circle c4 = new Circle(50);
        c4.getStyleClass().add("plaincircle"); // class for white fill/black stroke
        c4.getStyleClass().add("circleborder"); // add dashed border style

        // Arrange the circles in an HBox with spacing
        HBox root = new HBox(20, c1, c2, c3, c4);
        root.setStyle("-fx-alignment: center; -fx-padding: 30;");

        // Load the external CSS file
        Scene scene = new Scene(root, 500, 200, Color.LIGHTGRAY);
        scene.getStylesheets().add("mystyle.css");

        primaryStage.setTitle("Four Circles Styled with CSS");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Test code (main method)
    public static void main(String[] args) {
        launch(args);
    }
}
