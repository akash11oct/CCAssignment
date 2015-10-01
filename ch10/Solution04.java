package practice.CCAssignment.ch10;

/**
 * This class represents an array-like data structure called Listy that lacks a
 * size method. It does, however, have an elementAt(i) method that returns the 
 * element at index i in O(1) time. If i is beyond the bounds of Listy, it 
 * returns -1. For this reason, the Listy only supports positive integers.
 * 
 * Time Complexity: O(n)
 * 
 * @author Akash Gandotra
 */
class Listy{
    private int[] array;
   
    public Listy(int[] arr){
        this.array = arr;
    }
    
    /**
     * This method returns the element at index i in O(1) time
     * @param i index 
     * @return element at index i
     */
    public int elementAt(int i){
        if(i >= array.length)
            return -1;
        
        return array[i];
    }     
}

/**
 * This class contains a Listy which contains sorted, positive integers 
 * and implements a search method that finds the index at which an element x
 * occurs. If x occurs multiple times, the method returns any index.
 * 
 * @author Akash Gandotra
 */
class SortedSearchListy {   
    Listy list;
    
    public SortedSearchListy(Listy list){
        this.list = list;
    }
    
    /**
     * This method implements search for a value in a Listy.
     * 
     * @param data value to search for
     * @return index of data if found, -1 otherwise.
     */
    public int searchListy(int data){        
        if(list == null || list.elementAt(0) == -1)
            return -1;
        
        return searchListy(data, 0, 1);
    } 
    
    /**
     * This method implements search for a value in a Listy.
     * 
     * This method attempts to find the higher end of Listy by doubling the
     * end index each time. Once we find an end index such that the Listy array
     * is smaller than that, we simply run a slightly modified binary search 
     * for these bounds.
     * 
     * Also, if we the value we are searching for is greater than the value at
     * end index, we search for the value starting at the next index.
     * @param data value to search for
     * @param begin begin index
     * @param end end index
     * @return index of data if found, -1 otherwise.
     */
    public int searchListy(int data, int begin, int end){
        if(begin > end)
            return -1;
        
        if(data == list.elementAt(begin))
            return begin;
        
        if(data == list.elementAt(end))
            return end;
        
        /*
        * If we the value we are searching for is greater than the value at
        * end index, we search for the value starting at the next index.
        */
        if(data > list.elementAt(end))
            begin = end+1;
        
        //Find the upper bound for data
        if(list.elementAt(end) == -1 || data < list.elementAt(end))
            return binarySearch(data, begin, end);
        
        return searchListy(data, begin, end*2);
    }
    
    /**
     * This method implements binary search for Listy.
     * @param data value to find in array.
     * @param begin begin index
     * @param end end index within the bounds of Listy
     * @return index of element if found, -1 otherwise.
     */
    public int binarySearch(int data, int begin, int end){
        if(begin > end)
            return -1;
        
        int mid = (begin+end)/2;
        int midValue = list.elementAt(mid);
        if(data == midValue)
            return mid;
        else if(data < midValue || midValue == -1)
            return binarySearch(data, begin, mid-1);
        else
            return binarySearch(data, mid+1, end);
    }
}

public class Solution04 {  
    
    public static void main(String args[]) {
        int[] array = new int[]{1,2,4,7,8,9};
        Listy list = new Listy(array);
        SortedSearchListy listy = new SortedSearchListy(list);
        System.out.println(listy.searchListy(1)); //0
        System.out.println(listy.searchListy(2)); //1
        System.out.println(listy.searchListy(3)); //-1
        System.out.println(listy.searchListy(4)); //2
        System.out.println(listy.searchListy(5)); //-1
        System.out.println(listy.searchListy(7)); //3
        System.out.println(listy.searchListy(8)); //4
        System.out.println(listy.searchListy(9)); //5
        System.out.println(listy.searchListy(10)); //-1
    }
}
