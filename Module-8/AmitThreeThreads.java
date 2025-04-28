/**
 * Name: Amit Rizal
 * Date: 04/27/2025
 * Assignment: Module 8 Programming Assignment - Three Threads
 * Purpose: This program creates three threads to print random letters,
 *          random digits, and random special characters into a JavaFX TextArea.
 *          Each thread outputs at least 10,000 characters.
 */

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class AmitThreeThreads extends Application {

    // Number of characters to generate for each set
    private static final int COUNT = 10000;

    @Override
    public void start(Stage primaryStage) {
        // Create the text area to display output
        TextArea textArea = new TextArea();
        textArea.setWrapText(true);
        textArea.setEditable(false);

        VBox root = new VBox(textArea);
        Scene scene = new Scene(root, 800, 600);

        primaryStage.setTitle("Three Threads Output");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Start the three threads
        new Thread(() -> printRandomLetters(textArea)).start();
        new Thread(() -> printRandomDigits(textArea)).start();
        new Thread(() -> printRandomSpecials(textArea)).start();
    }

    // Thread 1: Output random letters
    private void printRandomLetters(TextArea textArea) {
        Random rand = new Random();
        for (int i = 0; i < COUNT; i++) {
            char letter = (char) ('a' + rand.nextInt(26));
            Platform.runLater(() -> textArea.appendText(String.valueOf(letter)));
        }
    }

    // Thread 2: Output random digits
    private void printRandomDigits(TextArea textArea) {
        Random rand = new Random();
        for (int i = 0; i < COUNT; i++) {
            char digit = (char) ('0' + rand.nextInt(10));
            Platform.runLater(() -> textArea.appendText(String.valueOf(digit)));
        }
    }

    // Thread 3: Output random special characters
    private void printRandomSpecials(TextArea textArea) {
        Random rand = new Random();
        char[] specials = {'!', '@', '#', '$', '%', '&', '*'};
        for (int i = 0; i < COUNT; i++) {
            char special = specials[rand.nextInt(specials.length)];
            Platform.runLater(() -> textArea.appendText(String.valueOf(special)));
        }
    }

    // Simple test code to verify character generators
    public static void main(String[] args) {
        // Uncomment the line below to test without JavaFX
        // testRandomGenerators();

        // Run the JavaFX application
        launch(args);
    }

    // Test method (not GUI) to check if generators produce correct count
    public static void testRandomGenerators() {
        Random rand = new Random();
        char[] specials = {'!', '@', '#', '$', '%', '&', '*'};
        int countLetters = 0, countDigits = 0, countSpecials = 0;

        for (int i = 0; i < COUNT; i++) {
            char letter = (char) ('a' + rand.nextInt(26));
            if (letter >= 'a' && letter <= 'z') countLetters++;
        }
        for (int i = 0; i < COUNT; i++) {
            char digit = (char) ('0' + rand.nextInt(10));
            if (digit >= '0' && digit <= '9') countDigits++;
        }
        for (int i = 0; i < COUNT; i++) {
            char special = specials[rand.nextInt(specials.length)];
            for (char s : specials) if (special == s) countSpecials++;
        }
        System.out.println("Letters: " + countLetters);
        System.out.println("Digits: " + countDigits);
        System.out.println("Specials: " + countSpecials);
    }
}
