/**
 * Author: Amit Rizal
 * Date: 04/03/2025
 * Course: CSD-420 - Advanced Java Programming
 * Module: Module 3 Programming Assignment
 * 
 * Purpose:
 * This program creates an ArrayList with 50 random integers from 1 to 20,
 * then removes duplicates using a generic static method and prints both lists.
 */

import java.util.ArrayList;
import java.util.Random;

public class Module3Assignment {

    /**
     * This generic static method removes duplicates from an ArrayList.
     * 
     * @param list The input ArrayList with potential duplicates
     * @param <E>  The generic type
     * @return A new ArrayList with duplicates removed
     */
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> uniqueList = new ArrayList<>();

        for (E item : list) {
            if (!uniqueList.contains(item)) {
                uniqueList.add(item);
            }
        }

        return uniqueList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        // Fill the ArrayList with 50 random integers between 1 and 20
        for (int i = 0; i < 50; i++) {
            numbers.add(random.nextInt(20) + 1); // 1 to 20
        }

        // Print original list
        System.out.println("Original List (50 random numbers from 1 to 20):");
        System.out.println(numbers);

        // Remove duplicates using the generic method
        ArrayList<Integer> noDuplicates = removeDuplicates(numbers);

        // Print the list without duplicates
        System.out.println("\nList after removing duplicates:");
        System.out.println(noDuplicates);
    }
}
