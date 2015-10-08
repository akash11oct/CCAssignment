package practice.CCAssignment.ch5;

/**
 *
 * @author Akash Gandotra
 */
public class Solution04 {

    public static int getNextLargest(int num) {
        int x = 0;
        int y = 0;
        int z = num;
        while (((z & 1) == 0) && (z != 0)) {
            x++;
            z >>= 1;
        }

        while ((z & 1) == 1) {
            y++;
            z >>= 1;
        }
        
        if (x + y == 31 || x + y == 0) {
            return -1;
        }

        return num + (1 << x) + (1 << (y - 1)) - 1;
    }

    public static int getNextSmallest(int num) {
        int x = 0;
        int y = 0;
        int z = num;
        while (((z & 1) == 1) && (z != 0)) {
            y++;
            z >>= 1;
        }

        if (z == 0) {
            return -1;
        }

        while ((z & 1) == 0 && (z != 0)) {
            x++;
            z >>= 1;
        }

        return num - (1 << y) - (1 << (x - 1)) + 1;
    }

    public static void main(String[] args) {
        int n = 1000;
        int nextSmallest = getNextSmallest(n);
        int nextLargest = getNextLargest(n);
        System.out.println(n + ": " + Integer.toBinaryString(n));
        System.out.println("next smallest = " + nextSmallest + ":  " + Integer.toBinaryString(nextSmallest));
        System.out.println("next largest  = " + nextLargest + ": " + Integer.toBinaryString(nextLargest));
        /* Output: 
        1000: 1111101000
        next smallest = 996:  1111100100
        next largest  = 1008: 1111110000
        */
    }

}
