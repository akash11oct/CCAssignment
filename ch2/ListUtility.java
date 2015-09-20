package practice.CCAssignment.ch2;

/**
 *
 * @author Akash Gandotra
 */
public class ListUtility {

    public static void printList(ListNode head) {
        if (head != null) {
            System.out.print(head.val + " ");
            while (head.next != null) {
                System.out.print(head.next.val + " ");
                head = head.next;
            }
            System.out.println();
        }
    }
    
    public static int length(ListNode head) {        
        int len = 0;
        for(; head!=null; len++,head = head.next);
        return len;        
    }
    
    
    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(1);
        n1.next = n2;
        
        //Prepare List [5,9,2]
        ListNode m1 = new ListNode(5);
        ListNode m2 = new ListNode(9);
        ListNode m3 = new ListNode(2);
        m1.next = m2;
        m2.next = m3;

        ListUtility.printList(n1);
        ListUtility.printList(m1);
        
    }
}
