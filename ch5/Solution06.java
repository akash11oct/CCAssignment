package practice.CCAssignment.ch5;

/**
 *
 * @author Akash Gandotra
 */
public class Solution06 {
    
  public static int getNumFlipBitsToConvert(int x, int y) {
    int num = 0;
    while (x > 0 || y > 0) {
      int bitX = x & 1;
      int bitY = y & 1;
      if (bitX != bitY)
        num++;
      x >>= 1;
      y >>= 1;
    }
    return num;
  }
  
  public static void main(String[] args) {
    System.out.println(getNumFlipBitsToConvert(29, 15));   //2
    System.out.println(getNumFlipBitsToConvert(1024, 15)); //5
    System.out.println(getNumFlipBitsToConvert(15, 29));   //2
    System.out.println(getNumFlipBitsToConvert(15, 1024)); //5
  }
    
}
