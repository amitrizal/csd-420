/**
 * Author: Amit Rizal
 * Date: 04/03/2025
 * Course: CSD-420 - Advanced Java Programming
 * Module: Module 4 Programming Assignment
 *
 * Purpose:
 * This program compares traversal times of a LinkedList using:
 * - an Iterator
 * - the get(index) method
 * for both 50,000 and 500,000 integer elements.
 */

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTraversalBenchmark {

    // Fills a LinkedList with integers from 0 to size-1
    public static LinkedList<Integer> fillList(int size) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        return list;
    }

    // Traverses the LinkedList using an Iterator
    public static long traverseUsingIterator(LinkedList<Integer> list) {
        long startTime = System.nanoTime();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next(); // Access element
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    // Traverses the LinkedList using get(index)
    public static long traverseUsingGet(LinkedList<Integer> list) {
        long startTime = System.nanoTime();
        for (int i = 0; i < list.size(); i++) {
            list.get(i); // Random access
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static void runTest(int size) {
        System.out.println("\n--- Traversal Test for size: " + size + " ---");

        LinkedList<Integer> list = fillList(size);

        long iteratorTime = traverseUsingIterator(list);
        System.out.println("Iterator traversal time: " + iteratorTime / 1_000_000.0 + " ms");

        long getTime = traverseUsingGet(list);
        System.out.println("get(index) traversal time: " + getTime / 1_000_000.0 + " ms");

        // Commented explanation
        System.out.println("\n[Observation for " + size + " elements]:");
        System.out.println("Iterator is much faster because get(index) in LinkedList is O(n), causing O(n^2) traversal time.");
        System.out.println("Iterator accesses each node sequentially, which is efficient for LinkedList.\n");
    }

    public static void main(String[] args) {
        runTest(50_000);     // Test for 50,000 elements
        runTest(500_000);    // Test for 500,000 elements
    }
}


/*
Comment on Results:

For 50,000 elements, the iterator took only ~2 ms, while get(index) took ~836 ms.
For 500,000 elements, the iterator remained efficient (~4 ms), but get(index) would take exponentially longer due to LinkedList's O(n) access time for get(index).

Conclusion:
Using an iterator is the most efficient way to traverse a LinkedList.
The get(index) method is inefficient because each access requires scanning from the head node.
This difference becomes significantly more noticeable as the list size increases.
*/
