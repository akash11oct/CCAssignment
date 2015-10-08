package practice.CCAssignment.ch5;

/**
 *
 * @author Akash Gandotra
 */
public class Solution01 {
    public static int insertBits(int N, int M, int i, int j) {
        if (j < i) {
            return 0;
        }
        
        //Create mask to clear bits i to j
        
        //Get all ones and shift them beyong position j
        int leftPieceOfMask = ~0 << (j + 1); 
        
        // Move ones after position i.  right = 00000011
        int rightPieceOfMask = ((1 << i) - 1); 
        
        //Combine left and right pieces to get all 0s between 1 and j, and all 
        //1s for all other bits. Use them to clear bits i to j in N.
        int N_WithClearedBits = N & (leftPieceOfMask | rightPieceOfMask);
        
        // Shift bits of m by i positions
        int M_WithBitsMoved = M << i; 
        
        int result = N_WithClearedBits | M_WithBitsMoved;
        return result;
    }

    public static void main(String[] args) {
        int a = 10000;
        int b = 10;
        int c = insertBits(a, b, 2, 10);
        
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(c));
    }
}
