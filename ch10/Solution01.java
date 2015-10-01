package practice.CCAssignment.ch10;

import java.util.Arrays;

/**
 * This class implements an algorithm to merge a sorted array into another
 * sorted array. The bigger sorted array is big enough to accommodate the
 * other array.
 * 
 * @author Akash Gandotra
 */
class SortedMerge {

    private Integer[] mySortedArray;
    private Integer size;

    public SortedMerge(Integer[] array) {
        this.mySortedArray = array;
        this.size = array.length;
    }

    /**
     * Merge sortedArr2 into mySortedArray in sorted order.
     * 
     * We shift the elements in mySortedArray to the end. 
     * We keep three pointers to track the starting indexes of mySortedArray 
     * array elements, sortedArr2 elements and the starting index for the 
     * final merged mySortedArray which starts from 0th index. 
     * 
     * Now we keep moving these pointer and adding 
     * elements from mySortedArray or sortedArr2 back into the mySortedArray 
     * depending on which of those elements is smaller.
     * 
     * @param sortedArr2 array to be merged into mySortedArray
     */
    public void mergeSorted(Integer[] sortedArr2) {        
        //Count the number of elements in mySortedArray
        int count=0;
        for(;count<size && mySortedArray[count]!=null ;count++);
        
        //Copy these elements to the end of array
        for(int i=0;i<count;i++){
            mySortedArray[size-count+i] = mySortedArray[i];
            mySortedArray[i] = null;
        }
        
        //Merge 
        int a = size-count; //Starting Index for mySortedArray elements
        int b = 0; //Starting Index for sortedArr2 elements
        int c = 0; //Starting Index for merged mySortedArray
        while(b<sortedArr2.length && a<size){
            if(sortedArr2[b]<mySortedArray[a]){
                mySortedArray[c++] = sortedArr2[b++];
            }
            else{
                mySortedArray[c++] = mySortedArray[a++];
            }
        }        
        
        //Copy remaining elements from sortedArr2
        while(b<sortedArr2.length){
                mySortedArray[c++] = sortedArr2[b++];
        }        
        
        //Copy remaining elements from mySortedArray      
        while(a<size){
                mySortedArray[c++] = mySortedArray[a++];
        }        
        
        /**
         * Set the leftover elements in mySortedArray to null so as to not leave
         * two copies of some elements.
         * 
         * This case only arises when the array is larger than the combined 
         * number of elements in both arrays. 
         */
        while(c<size){
                mySortedArray[c++] = null;
        }        
    }

    /**
     * Print elements of mySortedArray
     */
    public void printArray() {
        System.out.println(Arrays.toString(mySortedArray));
    }
}

public class Solution01 {

    public static void main(String args[]) {
        Integer[] arrayA = new Integer[]{1, 2, 11, 12, null, null, null, null, null, null, null, null};
        Integer[] arrayB = new Integer[]{3, 4, 5, 6, 7, 8, 9, 10};
        SortedMerge obj = new SortedMerge(arrayA);
        
        obj.printArray();
        //Before merge : [1, 2, 11, 12, null, null, null, null, null, null, null, null]
        
        obj.mergeSorted(arrayB);
        
        obj.printArray();
        //After merge  : [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
        System.out.println();
        
        arrayA = new Integer[]{1, 4, 7, 8, 9, 15, null, null, null, null, null, null, null};
        arrayB = new Integer[]{2, 3, 5, 11, 12, 16};
        obj = new SortedMerge(arrayA);
        
        obj.printArray();
        //Before merge : [1, 4, 7, 8, 9, 15, null, null, null, null, null, null, null]
        
        obj.mergeSorted(arrayB);
        
        obj.printArray();
        //After merge  : [1, 2, 3, 4, 5, 7, 8, 9, 11, 12, 15, 16, null]
    }
}
