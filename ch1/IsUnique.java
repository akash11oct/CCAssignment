package practice.CCAssignment.ch1;

import java.util.Arrays;

/**
 *
 * @author Akash Gandotra
 */
public class IsUnique {
    
    /**
     * Check if string has unique characters
     * Uses a boolean array of size 256 assuming ASCII character set
     * 
     * Loop over string setting boolean at index represented by character to 
     * true. If a true value is encountered for a character, it means that the
     * character has been encountered before, so we return false.
     * 
     * @param str string to test
     * @return true if string has unique characters
     */
    public boolean isStringUnique(String str){
        /*Return false for null or empty string 
          Return false is length>256 since that means at least one character 
          must have been repeated. */
        if(str == null || str.length()==0 || str.length()>256){
            return false;
        }
        
        boolean result = true;
        boolean arr[] = new boolean[256];
        for(int i = 0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(arr[ch] == true){
                result = false;
                break;
            }
            arr[ch] = true;
        }
        return result;
    }
    
    /**
     * Check if string has unique characters
     * Convert string into character array and sort the array in O(nlogn).
     * Then check to see if any consecutive characters are same.
     * @param str string to test
     * @return true if string has unique characters
     */
    public boolean isStringUniqueWithoutAdditionalDS(String str){
        /*Return false for null or empty string 
          Return false is length>256 since that means at least one character 
          must have been repeated. */
        if(str == null || str.length()==0 || str.length()>256){
            return false;
        }
        
        char[] charsInStr = str.toCharArray();
        Arrays.sort(charsInStr);
        for(int i = 0; i<charsInStr.length-1; i++){
            if(charsInStr[i] == charsInStr[i+1]){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String args[]){
        IsUnique obj = new IsUnique();
        System.out.println(obj.isStringUnique("abcde"));
        System.out.println(obj.isStringUniqueWithoutAdditionalDS("abcde"));
        System.out.println(obj.isStringUnique("abcdea"));
        System.out.println(obj.isStringUniqueWithoutAdditionalDS("abcdea"));
    }
}
