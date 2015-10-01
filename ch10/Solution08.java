package practice.CCAssignment.ch10;

import java.util.BitSet;

/**
 *
 * @author Akash Gandotra
 */
public class Solution08 {

    /**
     * Print duplicate elements in the array.
     * Available memory : 4 kilobytes
     * 
     * This method uses a Bit set of size 32000.
     * Set the bit for each element to true while traversing through array.
     * When a bit is already set, print that number.
     * 
     * @param arr array of number from 1 to N, where N is at most 32,000
     */
    public static void printDuplicates(int[] arr) {
        BitSet bitset = new BitSet(32001);
        for (int num : arr) {
            if (bitset.get(num)) {
                System.out.println(num);
            }
            bitset.set(num);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 5, 6, 7, 8, 8};
        printDuplicates(arr);
    }
}
