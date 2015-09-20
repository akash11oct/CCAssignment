package practice.CCAssignment.ch1;

import java.util.BitSet;

/**
 *
 * @author Akash Gandotra
 */
public class PalindromePermutation {
    
    /**
     * Check if string is a permutation of a palindrome
     * Use a bit vector to set and clear bits for index represented by 
     * characters in string. 
     * A string is a permutation of a palindrome if all characters have even 
     * number of occurrences in string; except for one character that may have
     * an odd number of occurrences.
     * So, for every character in string we set the bit if not already set, and 
     * clear it if already set. At the end, we must have either zero or one set 
     * bits in the bit set. If we find more than one set bits, the string cannot
     * be a permutation of a palindrome.
     * 
     * Note: We ignore spaces.
     */ 
    public boolean isStringPalindromePermutation(String str){
        //Return false if string is null or empty
        if(str == null || str.length() == 0)
            return false;
        
        //Return true if string is empty or only consists of spaces.
        if(str.length() == 0 || str.trim().length() == 0){
            return true;
        }
        
        str = str.trim().toLowerCase();
        BitSet chars = new BitSet();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == ' ')
                continue;
            if(chars.get(str.charAt(i)))
                chars.set(str.charAt(i),false);
            else
                chars.set(str.charAt(i),true);
        }
        int first = chars.nextSetBit(0);
        if(first > 0 ){
            int second = chars.nextSetBit(first+1);
            if(second > 0)
                return false;
        }
        
        return true;        
    }
    
    public static void main(String args[]){
        PalindromePermutation obj = new PalindromePermutation();
        System.out.println(obj.isStringPalindromePermutation("test")); //false
        System.out.println(obj.isStringPalindromePermutation("lool")); //true
        System.out.println(obj.isStringPalindromePermutation("madam")); //true
        System.out.println(obj.isStringPalindromePermutation("Tact coa")); //true
    }
}
