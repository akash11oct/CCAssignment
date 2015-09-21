package practice.CCAssignment.ch2;

import java.util.HashSet;

/**
 *
 * @author Akash Gandotra
 */
public class Solution01 {
    
    /**
     * Remove Duplicates from unsorted List
     * Traverse the list adding node values to a set. If a node has a value that
     * is already present in the set, remove the node.
     * O(n) Time and Space Complexity
     * @param head head of list
     * @return head of list with no duplicates
     */
    public static ListNode removeDuplicatesFromUnsortedList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode tmp = null;
        HashSet<Integer> values = new HashSet<Integer>();
        values.add(head.val);
        while(curr != null){
            if(values.contains(curr.val)){
                prev.next = curr.next;
                tmp = curr;
                curr = curr.next;
                tmp.next = null;
            }
            else{
                values.add(curr.val);
                prev = curr;
                curr = curr.next;
            }
        }
        return head;        
    } 
    
    /**
     * Remove Duplicates from unsorted List without additional space
     * Sort the list in O(n logn) time and then remove duplicates in O(n)
     * O(n logn) Time Complexity and O(1) Space Complexity
     * @param head head of list
     * @return head of list with no duplicates
     */
    public static ListNode removeDuplicates(ListNode head) {
        ListNode sorted = sortList(head);
        ListNode result = removeDuplicatesFromSortedList(sorted);
        return result;
    }
    
    /**
     * Remove Duplicates from sorted List
     * O(n) Time Complexity and O(1) Space Complexity
     * @param head head of list
     * @return head of list with no duplicates
     */
    public static ListNode removeDuplicatesFromSortedList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode tmp = null;
        while(curr != null){
            if(curr.val == prev.val){
                prev.next = curr.next;
                tmp = curr;
                curr = curr.next;
                tmp.next = null;
            }
            else{
                prev = curr;
                curr = curr.next;
            }
        }
        return head;        
    } 
    
    /**
     * Sort Linked List using merge sort technique in O(nlogn) time.
     * @param head head of list
     * @return head of sorted list
     */
    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode t1= head;
        ListNode t2= head;
        ListNode prev= head;
        while(t2!=null && t2.next!=null){
            prev = t1;
            t1 = t1.next;
            t2 = t2.next.next;
        }
        prev.next = null;
        
        ListNode h1 = sortList(head);
        ListNode h2 = sortList(t1);
        ListNode h = null;
        ListNode it = null;
        boolean first = true;
        while(h1!=null && h2!=null){
            if(h1.val<h2.val){
                if(first){
                    h = h1;
                    it = h;
                    first = false;
                }
                else{
                    it.next = h1;
                    it = h1;
                }
                h1 = h1.next;
            }
            else{
                if(first){
                    h = h2;
                    it = h;
                    first = false;
                }
                else{
                    it.next = h2;
                    it = h2;
                }
                h2 = h2.next;
            }
        }
        if(h1 != null){
            it.next = h1;
        }
        if(h2 != null){
            it.next = h2;
        }
        return h;
    }
    
    public static void main(String[] args) {
        //Prepare List [1,2,3,4,5,3]
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        
        //Prepare List [1,2,3,4,5,3]
        ListNode m1 = new ListNode(1);
        ListNode m2 = new ListNode(2);
        ListNode m3 = new ListNode(3);
        ListNode m4 = new ListNode(4);
        ListNode m5 = new ListNode(5);
        ListNode m6 = new ListNode(3);
        m1.next = m2;
        m2.next = m3;
        m3.next = m4;
        m4.next = m5;
        m5.next = m6;

        ListUtility.printList(n1);
        n1 = removeDuplicatesFromUnsortedList(n1);
        ListUtility.printList(n1);
        
        ListUtility.printList(m1);
        m1 = removeDuplicates(m1);
        ListUtility.printList(m1);
    }
}
