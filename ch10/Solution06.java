package practice.CCAssignment.ch10;

/**
 *
 * @author Akash Gandotra
 */
public class Solution06 {

    /**
     * This method attempts to find the location of a given string in a sorted
     * array of strings that is interspersed with empty strings.
     *
     * Assumption: Case of string matters. Impact: The algorithm uses a case
     * sensitive approach.
     *
     * Time Complexity: O(log n)
     *
     * @param str string to search for
     * @param strArr string array
     * @return index of string in array if found, -1 otherwise
     */
    public static int sparseSearch(String str, String[] strArr) {
        if (str == null || str.isEmpty()) {
            return -1;
        }

        if (strArr == null || strArr.length == 0) {
            return -1;
        }

        return sparseBinarySearch(str, strArr, 0, strArr.length - 1);
    }

    /**
     * This method implements a modified binary search algorithm to find the
     * location of a given string in a sorted array of strings that is
     * interspersed with empty strings.
     *
     * Time Complexity: O(log n)
     *
     * @param str string to search for
     * @param strArr string array
     * @param begin starting index for search
     * @param end ending index for search
     * @return index of string in array if found, -1 otherwise
     */
    public static int sparseBinarySearch(String str, String[] strArr, int begin, int end) {
        if(begin>end)
            return -1;
        int mid = (begin + end) / 2;
        
        /**
         * If string at mid index itself is an empty string, we move the
         * midValue to the closest string in the either direction.
         */
        if (strArr[mid].isEmpty()) {
            int left = mid - 1;
            int right = mid + 1;
            while(true) {
                if (left < begin && right > end) {
                    return -1;
                }
                else if(left>= begin && !strArr[left].isEmpty()){
                    mid = left;
                    break;
                }
                else if(right<= end && !strArr[right].isEmpty()){
                    mid = right;
                    break;
                }
                left--;
                right++;
            }
        }

        if (str.equals(strArr[mid])) {
            return mid;
        } 
        if (strArr[mid].compareTo(str) < 0) {
            return sparseBinarySearch(str, strArr, mid + 1, end);
        } else {
            return sparseBinarySearch(str, strArr, begin, mid - 1);
        }
    }

    public static void main(String args[]) {
        String[] strArr = new String[]{"at", "", "", "", "ball", "", "", "", "", "", "", "car", "", "", "", "dad", "", "", ""};
        String[] strArr2 = new String[]{"car", "", "", "", "dad"};
        Solution06 obj = new Solution06();
        System.out.println(sparseSearch("dad", strArr));
    }
}
