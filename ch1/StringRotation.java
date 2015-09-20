package practice.CCAssignment.ch1;

/**
 *
 * @author Akash Gandotra
 */
public class StringRotation {
    
    /**
     * Check is string1 is a rotation of string2 using one call to isSubstring 
     * method.
     * 
     * @param s1
     * @param s2
     * @return if string1 is a rotation of string2
     */ 
    public boolean checkStringRotation(String s1, String s2){
        /*Return false if either of two strings are null or empty
          Return false is length of two strings are different. */
        if(s1 == null || s2 == null || s1.length()==0 || s2.length()==0 || s1.length() != s2.length()){
            return false;
        }
        
        //Return true if strings are same.
        if(s1.equals(s2)){
            return true;
        }
        
        /**
         * If string1 is a rotation of string2, string1 is definitely a 
         * substring of string2 appended to itself.
         * For eg, s1 = water, s2 = terwa, s2+s2 = terwaterwa = ter +"water"+ wa
         */        
        String s3 = s2+s2;
        if(isSubstring(s3,s1))
            return true;    
        
        return false;    
    }
    
    public boolean isSubstring(String s1, String s2){
        return s1.contains(s2);
    }
        
    public static void main(String args[]){
        StringRotation obj = new StringRotation();
        System.out.println(obj.checkStringRotation("abcde","cdeab")); //true
        System.out.println(obj.checkStringRotation("waterbottle","erbottlewat")); //true
        System.out.println(obj.checkStringRotation("iceman","cinema")); //false
    }
}
