/*
 * Name: Amit Rizal
 * Date: 2025-03-30
 * Assignment: Module 2 - Random Data File Write and Read
 * Purpose: This program reads and displays the contents of the file.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadData {
    public static void main(String[] args) {
        String filename = "AmitRizal_datafile.dat";

        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            System.out.println("Contents of '" + filename + "':\n");
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file '" + filename + "' does not exist.");
        }
    }
}
