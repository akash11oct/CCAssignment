package practice.CCAssignment.ch2;

/**
 *
 * @author Akash Gandotra
 */
public class Solution04 {

    /**
     * Partition a linked list around a value x such that all nodes less than x
     * come before all nodes greater than or equal to x, while preserving order.
     * 
     * We traverse the list and prepare two lists - one for elements smaller
     * than x and one for other elements. Finally we concatenate these lists.
     * Also, if one of these lists is empty, we simply return the other one.
     * 
     * @param head
     * @param x
     * @return partitioned list
     */
    public static ListNode partition(ListNode head, int x) {
        ListNode smaller = null;
        ListNode other = null;
        ListNode smallerHead = null;
        ListNode otherHead = null;
        ListNode it = head;

        while (it != null) {
            if (it.val < x) {
                if (smaller == null) {
                    smaller = it;
                    smallerHead = smaller;
                } else {
                    smaller.next = it;
                    smaller = smaller.next;
                }
                it = it.next;
            } else {
                if (other == null) {
                    other = it;
                    otherHead = other;
                } else {
                    other.next = it;
                    other = other.next;
                }
                it = it.next;
            }
        }
        //If one of these lists is empty, return the other one.
        //Otherwise, concatenate the lists and return.
        if (other == null) {
            return smallerHead;
        }
        other.next = null;
        if (smaller == null) {
            return otherHead;
        }
        smaller.next = otherHead;
        return smallerHead;
    }
    
    public static void main(String[] args) {
        //Prepare List [3,2,1,2,3]
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        
        ListUtility.printList(n1);
                
        System.out.println("Partitioned at 3: "); 
        ListUtility.printList(partition(n1,3));
    }

}
