package practice.CCAssignment.ch1;

/**
 *
 * @author Akash Gandotra
 */
public class Solution03 {
    
    /**
     * Replace spaces in string with "%20"
     * Start replacing the spaces from the end of string.
     */ 
    public String modifyString(String str){
        if(str == null || str.length() == 0 || str.indexOf(' ')<0)
            return str;
        
        str = str.trim();
        int count = 0; //Count number of spaces in string
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == ' ')
                count++;
        }
        
        //Take character array of length of final string that we compute
        //using number of spaces in original string.
        int finalLength = str.length() + count*2;
        char[] finalStr = new char[finalLength];
        int finalStrCtr = finalLength-1;
        
        //Replace every space in original string by %20 
        for(int i = str.length()-1; i>=0; i--){
            char ch = str.charAt(i);
            if(ch == ' '){                
                finalStr[finalStrCtr--] = '0';
                finalStr[finalStrCtr--] = '2';
                finalStr[finalStrCtr--] = '%';
            }
            else{
                finalStr[finalStrCtr--] = ch;
            }
        }
        return new String(finalStr);        
    }
    
    public static void main(String args[]){
        Solution03 obj = new Solution03();
        System.out.println(obj.modifyString("test string")); //test%20string
        System.out.println(obj.modifyString("te st str ing")); //te%20st%20str%20ing
        System.out.println(obj.modifyString("t es t st rin g ")); //t%20es%20t%20st%20rin%20g
        System.out.println(obj.modifyString("Mr John Smith   ")); //Mr%20John%20Smith
    }
}
