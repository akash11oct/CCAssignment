package practice.CCAssignment.ch5;

/**
 *
 * @author Akash Gandotra
 */
public class Solution03 {

    public static int flipBitToWin(int num) {
        /* If all 1s, this is already the longest sequence. */
        if (~num == 0) {
            return Integer.BYTES * 8;
        }

        int currLen = 0;
        int prevLen = 0;
        int maxLen = 1;
        while (num != 0) {
            if ((num & 1) == 1) {
                currLen++;
            } else if ((num & 1) == 0) {
                prevLen = (num & 2) == 0 ? 0 : currLen;
                currLen = 0;
            }
            int len = prevLen + currLen + 1;
            if(len > maxLen)
                maxLen = len;
            num >>>= 1;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(flipBitToWin(32));
    }
}
