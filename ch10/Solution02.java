package practice.CCAssignment.ch10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * This class implements an algorithm to group the anagrams together in a group
 * of strings.
 * 
 * @author Akash Gandotra
 */
class AnagramGroup {

    private String[] strings;

    public AnagramGroup(String[] stringArr) {
        this.strings = stringArr;
    }

    /**
     * Group anagrams together.
     * 
     * Different strings that are anagrams are identical when sorted.
     * This method sorts the characters in each string and uses that as a key
     * for a map that stores all strings that are anagrams of this key string
     * in a list.
     * Finally, we rebuild the array from this map of lists of strings.
     * 
     * Time Complexity : O(n log n)
     */
    private void groupAnagrams() {
        HashMap<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();
        for (String str : strings) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            LinkedList<String> list = map.get(sorted);
            if (list == null) {
                list = new LinkedList<String>();
                map.put(sorted, list);
            }
            list.add(str);
        }
        int index = 0;
        for(String str: map.keySet()){
            LinkedList<String> list = map.get(str);
            while(!list.isEmpty()){
                strings[index++] = list.removeLast();
            }
        }
    }

    /**
     * Print the strings in Anagram groups.
     */
    public void printAnagramGroup() {
        groupAnagrams();
        for (String s : strings) {
            System.out.println(s);
        }
    }

}

public class Solution02 {

    public static void main(String args[]) {
        String[] strArr = new String[]{"iceman", "cbda", "cinema", "abcd", "hello", "mainec", "bcda"};
        AnagramGroup obj = new AnagramGroup(strArr);
        obj.printAnagramGroup();
        /**
         *  hello
            mainec
            cinema
            iceman
            bcda
            abcd
            cbda
         */
    }
}
