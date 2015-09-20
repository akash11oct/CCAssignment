package practice.CCAssignment.ch1;

/**
 *
 * @author Akash Gandotra
 */
public class CheckPermutation {
    
    /**
     * Check if two strings are permutations of each other by checking if they 
     * have same frequency of each character.
     * Uses a integer array of size 256 assuming ASCII character set 
     * 
     * Use this array to record number of occurrences of each character in first
     * string by incrementing value at index for each character by 1.
     * For second string, we do the same except we decrement values by 1.
     * Now, if strings were permutations, each value in array must be zero. 
     * If not, we return false.
     * 
     * @param str1 string to test
     * @param str2 string to test
     * @return true if strings are permutations of each other
     */
    public boolean areStringsPermutations(String str1, String str2){
        /*Return false if either of two strings are null or empty
          Return false is length of two strings are different. */
        if(str1 == null || str2 == null || str1.length()==0 || str2.length()==0 || str1.length() != str2.length()){
            return false;
        }
        
        //Return true if strings are same.
        if(str1.equals(str2)){
            return true;
        }
        
        int arr[] = new int[256];
        for(int i = 0; i<str1.length(); i++){
            arr[str1.charAt(i)]++;
        }
        for(int i = 0; i<str2.length(); i++){
            arr[str1.charAt(i)]--;
        }
        for(int i = 0; i<256; i++){
            if(arr[i]!=0)
                return false;
        }
        return true;
    }
        
    public static void main(String args[]){
        CheckPermutation obj = new CheckPermutation();
        System.out.println(obj.areStringsPermutations("abcde","ebdca")); //true
        System.out.println(obj.areStringsPermutations("abcde","ebda")); //false
        System.out.println(obj.areStringsPermutations("iceman","cinema")); //true
        System.out.println(obj.areStringsPermutations("iceman","cinemaa")); //false
    }
}
