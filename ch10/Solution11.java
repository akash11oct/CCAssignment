package practice.CCAssignment.ch10;

/**
 *
 * @author Akash Gandotra
 */
public class Solution11 {

    /**
     * Sort an array into an alternating sequence of peaks and valleys.
     * A peak is an element which is greater than or equal to the adjacent
     * integers.
     * A valley is an element which is less than or equal to the adjacent 
     * integers.
     * 
     * This method iterates through the array finding the biggest integer in
     * every three integers and adjusting its place as a peak. The valleys 
     * are created automatically.
     * @param arr 
     */
    public static void createPeaksAndValleys(int[] arr) {
        for (int i = 1; i < arr.length; i = i+2) {            
            if(arr[i] > arr[i-1] && arr[i] > arr[i+1])
                continue;
            
            if(arr[i-1] > arr[i+1])
                swap(arr,i,i-1);
            else
                swap(arr,i,i+1);
        }
    }
    
    /**
     * This method swaps integers at given indexes in an array.
     * @param arr array on integers
     * @param a index1 
     * @param b index2
     */
    public static void swap(int[] arr, int a, int b) {            
            int tmp = arr[a];
            arr[a] = arr[b];
            arr[b] = tmp;
        
    }

    public static void main(String[] args) {
        int[] arr = new int[]{13, 6, 5, 1, 16, 15, 20};
        createPeaksAndValleys(arr);
        for (int i : arr) {
            System.out.print(i + "  ");
        }

        System.out.println();
    }

}
