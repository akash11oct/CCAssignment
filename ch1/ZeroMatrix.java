package practice.CCAssignment.ch1;

import java.util.ArrayList;

/**
 *
 * @author Akash Gandotra
 */
public class ZeroMatrix {

    /**
     * For every element in arr with a zero value, set the entire row and column
     * to zero.
     * 
     * Traverse the matrix and record the rows and columns we need to set to 
     * zero. For each such row and column, set them to zero by traversing again.
     * @param arr 
     */
    public static void setZeroMatrix(int[][] arr) {
        int n = arr.length;
        ArrayList<Integer> zeroRows = new ArrayList<Integer>();
        ArrayList<Integer> zeroCols = new ArrayList<Integer>();
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                if(arr[i][j] == 0){
                    zeroRows.add(i);
                    zeroCols.add(j);
                }
            }
        }
        for (int i : zeroRows) {
            for (int j = 0; j < n ; j++) {
                arr[i][j] = 0;
            }
        }
        for (int i = 0; i < n ; i++) {
            for (int j : zeroCols) {
                arr[i][j] = 0;
            }
        }
    }

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
            {1, 2, 0, 4, 5},
            {6, 7, 8, 0, 10},
            {11, 12, 13, 14, 15},
            {16, 0, 18, 19, 20},
            {21, 22, 23, 24, 25}
        };
        System.out.println("Original Matrix");
        printMatrix(arr);
        setZeroMatrix(arr);
        System.out.println("Zero Matrix");
        printMatrix(arr);
    }
    
}
