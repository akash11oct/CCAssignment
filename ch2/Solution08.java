package practice.CCAssignment.ch2;

/**
 *
 * @author Akash Gandotra
 */
public class Solution08 {

    public static ListNode detectLoop(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        
        //Get two pointers - slow pointer moves 1 step, fast pointer moves two
        ListNode slow = head;
        ListNode fast = head;
        boolean loopDetected = false;
        
        //Loop is detected if slow and fast pointers meet.
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                loopDetected = true;
                break;
            }
        }

        //If loop not detected, return null
        if (!loopDetected) 
            return null;

        //To find beginning of loop, move slow pointer to head of list.
        //Now move both slow and fast pointers one step at a time.
        //Where they meet, is the beginning of loop.
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
    
    public static void main(String[] args) {
        //Prepare List [1,2,3,4,5,2,3,4,5,2,3,4,5,2....]
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n2;
                
        ListNode loopStart = detectLoop(n1);
        if(loopStart == null){
            System.out.println("No loop detected : "); 
        }
        else{
            System.out.println("Loop detected that starts at: " + loopStart.val); 
        }
    }

}
