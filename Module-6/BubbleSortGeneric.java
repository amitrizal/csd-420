/*
 * Amit Rizal
 * 04/19/2025
 * CSD-420 Module 6 Programming Assignment
 * 
 * This program demonstrates two generic methods to perform bubble sort:
 * 1. One using Comparable<E>
 * 2. One using Comparator<? super E>
 * 
 * The purpose is to reinforce sorting fundamentals and show how Java generics can
 * be applied to sort various types of data with reusable code.
 */

import java.util.Arrays;
import java.util.Comparator;

public class BubbleSortGeneric {

    // Method 1: Generic bubble sort using Comparable
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - i - 1; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    System.out.println("Switch made (Comparable)");
                }
            }
            System.out.println("Pass " + (i + 1) + ": " + Arrays.toString(list));
        }
    }

    // Method 2: Generic bubble sort using Comparator
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - i - 1; j++) {
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    System.out.println("Switch made (Comparator)");
                }
            }
            System.out.println("Pass " + (i + 1) + ": " + Arrays.toString(list));
        }
    }

    // Main test method
    public static void main(String[] args) {
        System.out.println("----- Using Comparable -----");
        Integer[] numbers = {5, 3, 4, 9, 0, 1, 2, 7, 6, 8};
        bubbleSort(numbers); // Using Comparable
        System.out.println("Sorted (Comparable): " + Arrays.toString(numbers));

        System.out.println("\n----- Using Comparator -----");
        String[] names = {"Zebra", "Apple", "Orange", "Banana"};
        bubbleSort(names, new AlphabeticalComparator()); // Using Comparator
        System.out.println("Sorted (Comparator): " + Arrays.toString(names));
    }
}

// Example Comparator class for strings
class AlphabeticalComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return s1.compareToIgnoreCase(s2); // Case-insensitive alphabetical order
    }
}
