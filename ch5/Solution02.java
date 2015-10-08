package practice.CCAssignment.ch5;

/**
 *
 * @author Akash Gandotra
 */
public class Solution02 {

    /**
     * This method prints the binary representation of a real number between 0 
     * and 1
     * @param d double value
     * @return binary representation of d
     */
    public static String binaryToString(double d) {
        if (d >= 1 || d <= 0) {
            return "ERROR";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(".");
        while (d > 0) {
            //Return binary string with a max length of 32 characters.
            if (sb.length() >= 32) {
                return sb.toString();
            }
            double r = d * 2;
            if (r >= 1) {
                sb.append(1);
                d = r - 1;
            } else {
                sb.append(0);
                d = r;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(binaryToString(.72));
        System.out.println(binaryToString(.25));
        System.out.println(binaryToString(.50));
        System.out.println(binaryToString(.75));
    }
}
