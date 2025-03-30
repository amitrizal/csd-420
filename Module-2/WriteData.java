/*
 * Name: Amit Rizal
 * Date: 2025-03-30
 * Assignment: Module 2 - Random Data File Write and Read
 * Purpose: This program writes random integers and doubles to a file.
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class WriteData {
    public static void main(String[] args) {
        String filename = "AmitRizal_datafile.dat";
        Random rand = new Random();

        int[] integers = new int[5];
        double[] doubles = new double[5];

        // Generate random values
        for (int i = 0; i < 5; i++) {
            integers[i] = rand.nextInt(100) + 1;
            doubles[i] = Math.round((rand.nextDouble() * 100.0) * 100.0) / 100.0;
        }

        try (FileWriter writer = new FileWriter(filename, true)) { // append mode
            writer.write("Random Integers: ");
            for (int i : integers) {
                writer.write(i + ", ");
            }
            writer.write("\nRandom Doubles: ");
            for (double d : doubles) {
                writer.write(d + ", ");
            }
            writer.write("\n----------------------------------------\n");
            System.out.println("Data written to '" + filename + "'.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
