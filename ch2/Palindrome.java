package practice.CCAssignment.ch2;


/**
 *
 * @author Akash Gandotra
 */
public class Palindrome {

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        //go to the center of the list
        ListNode t1 = head;
        ListNode t2 = head;
        while (t2.next != null && t2.next.next != null) {
            t2 = t2.next.next;
            t1 = t1.next;
        }

        //reverse latter half of the list in place.
        ListNode mid = t1.next;
        ListNode p = reverseList(mid);
        ListNode q = head;
        
        //check to see if first half is same as reversed second half
        while (p != null) {
            if (p.val != q.val) {
                return false;
            }
            p = p.next;
            q = q.next;
        }
        return true;
    }
    
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = head;
        ListNode curr = head.next;
        head.next = null;
        ListNode tmp = null;

        while (curr != null) {
            tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
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
        
        System.out.println("Palindrome : " + isPalindrome(n1)); 
    }
}
