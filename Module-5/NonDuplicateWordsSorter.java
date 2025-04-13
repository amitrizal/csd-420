// Author: Amit Rizal
// Date: 04/12/2025
// Assignment: Module-5 - Non-Duplicate Words Sorter
// Purpose: This program reads words from a file, removes duplicates,
// and displays them in ascending and descending order.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class NonDuplicateWordsSorter {
    public static void main(String[] args) {
        String fileName = "collection_of_words.txt";
        Set<String> wordSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

        // Read the file and add words to TreeSet (automatically removes duplicates)
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNext()) {
                String word = scanner.next().replaceAll("[^a-zA-Z]", ""); // Remove punctuation
                if (!word.isEmpty()) {
                    wordSet.add(word.toLowerCase());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            return;
        }

        // Display words in ascending order
        System.out.println("Non-duplicate words in ascending order:");
        for (String word : wordSet) {
            System.out.println(word);
        }

        // Display words in descending order
        System.out.println("\nNon-duplicate words in descending order:");
        List<String> descList = new ArrayList<>(wordSet);
        Collections.reverse(descList);
        for (String word : descList) {
            System.out.println(word);
        }
    }
}
