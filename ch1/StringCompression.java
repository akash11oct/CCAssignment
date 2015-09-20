package practice.CCAssignment.ch1;

/**
 *
 * @author Akash Gandotra
 */
public class StringCompression {
    
    /**
     * Compress string using counts of repeated characters.
     * 
     * Prepare compressed string by comparing consecutive characters and keeping 
     * count if they are identical. When they aren't, we add the character with
     * the count to result string, and proceed with the rest of string.
     */ 
    public String compressString(String str){
        if(str == null || str.length() == 0)
            return str;
        
        StringBuffer finalStr = new StringBuffer("");
        
        //Assuming this procedure is case insensitive.
        str = str.toLowerCase();
        int count = 1; //Count number of occurrences of characters
        for(int i=1;i<str.length();i++){
            if(str.charAt(i) == str.charAt(i-1)){
                count++;
            }
            else{
                finalStr.append(str.charAt(i-1));
                finalStr.append(""+count);
                count = 1;
            }
        }   
        
        finalStr.append(str.charAt(str.length()-1));
        finalStr.append(""+count);
        
        //If compressed string does not become smaller, return original string.
        if(finalStr.length() >= str.length())
            return str;
        
        return finalStr.toString();
    }
    
    public static void main(String args[]){
        StringCompression obj = new StringCompression();
        System.out.println(obj.compressString("aaabbcddaaa")); //test%20string
        System.out.println(obj.compressString("AbBBDDCCEEE")); //te%20st%20str%20ing
    }
    
}
