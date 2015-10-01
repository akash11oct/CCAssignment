package practice.CCAssignment.ch10;

/**
 *
 * @author Akash Gandotra
 */
public class Solution05 {

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
        if (str == null || str.equals("")) {
            return -1;
        }

        if (strArr == null || strArr.length == 0) {
            return -1;
        }

        int begin = 0;
        int end = strArr.length - 1;

        while (strArr[begin].equals("")) {
            begin++;
            if (begin > end) {
                return -1;
            }
        }

        while (strArr[end].equals("")) {
            end--;
            if (begin > end) {
                return -1;
            }
        }

        return sparseBinarySearch(str, strArr, begin, end);
    }

    /**
     * This method implements a modified binary search algorithm to find the
     * location of a given string in a sorted array of strings that is
     * interspersed with empty strings.
     * 
     * @param str string to search for
     * @param strArr string array
     * @param begin starting index for search
     * @param end ending index for search
     * @return index of string in array if found, -1 otherwise
     */
    public static int sparseBinarySearch(String str, String[] strArr, int begin, int end) {
        if (begin > end) {
            return -1;
        }
        int mid = (begin + end) / 2;

        /**
         * If string at mid index itself is an empty string, we move the
         * midValue to the closest string in the either direction.
         */
        String midValue = strArr[mid];
        if (midValue.equals("")) {
            int left = mid - 1;
            int right = mid + 1;
            while (strArr[left].equals("") && strArr[right].equals("")) {
                if (left > begin) {
                    left--;
                }
                if (right < end) {
                    right++;
                }
            }
            mid = (strArr[left].equals("")) ? right : left;
            midValue = strArr[mid];
        }

        if (str.equals(strArr[mid])) {
            return mid;
        } else if (str.compareTo(midValue) < 0) {
            return sparseBinarySearch(str, strArr, begin, mid - 1);
        } else {
            return sparseBinarySearch(str, strArr, mid + 1, end);
        }
    }

    public static void main(String args[]) {
        String[] strArr = new String[]{"at", "", "", "", "ball", "", "", "", "", "", "", "car", "", "", "", "dad", "", "", ""};
        Solution05 obj = new Solution05();
        System.out.println(sparseSearch("ball", strArr)); //4
    }

}
