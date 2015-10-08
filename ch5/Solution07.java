package practice.CCAssignment.ch5;

/**
 *
 * @author Akash Gandotra
 */
public class Solution07 {

    public static int swapOddEvenBits(int x) {
        return (((x & 0xaaaaaaaa) >>> 1) |
                ((x & 0x55555555) << 1));
    }

    public static void main(String[] args) {
        System.out.println(swapOddEvenBits(1000));
        System.out.println(Integer.toBinaryString(1000));
        System.out.println(Integer.toBinaryString(swapOddEvenBits(1000)));
    }
}
