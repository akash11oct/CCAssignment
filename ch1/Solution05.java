package practice.CCAssignment.ch1;

/**
 *
 * @author Akash Gandotra
 */
public class Solution05 {
    
    /**
     * Check if strings are one (or zero) edit away.
     */ 
    public boolean areStringsOneAway(String str1, String str2){
        //Return false if either of two strings are null
        if(str1 == null || str2 == null){
            return false;
        }
        
        //Return true if strings are same.
        if(str1.equals(str2)){
            return true;
        }
        
        //Return false is length of strings differs by 2 or more.
        if(str1.length()-str2.length()>=2 || str1.length()-str2.length()<=-2){
            return false;
        }
        
        int numEdits = 0;
        /**
         * Two Cases:
         * Case1: Length of strings are equal.
         * Only possible scenario where such strings are 'One Away' is when not 
         * more than one character doesn't match in strings.
         */
        if(str1.length() == str2.length()){
            for(int i = 0; i<str1.length(); i++){
                if(str1.charAt(i) != str2.charAt(i)){
                    numEdits++;
                }
                if(numEdits>1)
                    return false;
            }
        }
        /**
         * Two Cases:
         * Case2: Length of strings are not equal.
         * We find shorter and longer string.
         * Only possible scenario where such strings are 'One Away' is when 
         * longer character has one extra character, so that if we skip over 
         * that character, all others must match.
         */
        else{
            String st1 = (str1.length()<str2.length())?str1:str2;
            String st2 = (str1.length()<str2.length())?str2:str1;
            for(int i = 0,j=0; i<st1.length(); i++,j++){
                if(st1.charAt(i) != st2.charAt(j)){
                    numEdits++;
                    j++;
                }
                if(numEdits>1)
                    return false;                
            }
        }
        return true;
    }
    
    public static void main(String args[]){
        Solution05 obj = new Solution05();
        System.out.println(obj.areStringsOneAway("bale","pae")); //true
        System.out.println(obj.areStringsOneAway("pales","pale"));//true
        System.out.println(obj.areStringsOneAway("pale","bale")); //true
        System.out.println(obj.areStringsOneAway("pale","bake")); //false
    }
    
    
    
}
