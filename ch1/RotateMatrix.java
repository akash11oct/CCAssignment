package practice.CCAssignment.ch1;

/**
 *
 * @author Akash Gandotra
 */
public class RotateMatrix {

    /**
     * Rotate matrix by 90 degrees by performing a circular rotation on each
     * layer, moving top edge to right edge, right to bottom, and so on.
     * @param arr 
     */
    public static void rotateMatrix(int[][] arr) {
        int n = arr.length;
        int i, j, k, tmp = 0;
        for (i = 0; i < n / 2; i++) {
            int limit = n - 1 - i;
            for (j = i, k = limit; j < limit; j++, k--) {
                tmp = arr[j][limit];
                arr[j][limit] = arr[i][j];
                arr[i][j] = arr[k][i];
                arr[k][i] = arr[limit][k];
                arr[limit][k] = tmp;
            }
        }
    }

    /**
     * Print a matrix to standard output.
     * @param arr 
     */
    public static void printMatrix(int[][] arr) {
        int n = arr.length;
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25}
        };
        System.out.println("Original Matrix");
        printMatrix(arr);
        rotateMatrix(arr);
        System.out.println("Rotated Matrix");
        printMatrix(arr);
    }
}
