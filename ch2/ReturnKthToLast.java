package practice.CCAssignment.ch2;

/**
 *
 * @author Akash Gandotra
 */
public class ReturnKthToLast {
    
    /**
     * Return kth to last element in list. 
     * Assuming k is always valid.
     * O(n) Time Complexity and O(1) Space Complexity
     * 
     * Use two pointers, one of which we put k nodes ahead of head.
     * Then we move both pointers simultaneously, so when the pointer k nodes 
     * ahead reached the end of list, the other pointer reached kth to last 
     * element in the list.
     * 
     * @param head head of list
     * @param k 
     * @return kth to last element
     */
    public static ListNode returnKthToLastElementInList(ListNode head, int k) {
        if(head == null || k<1)
            return null;
            
        ListNode it1 = head;
        ListNode it2 = head;
        for(int i=1;i<k;i++){
            it2 = it2.next;
        }
            
        while(it2.next!=null){
            it1 = it1.next;
            it2 = it2.next;
        }
        return it1;
    }
    
    public static void main(String[] args) {
        //Prepare List [1,2,3,4,5,6]
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        ListUtility.printList(n1);
        ListNode kthToLast = returnKthToLastElementInList(n1,2);
        System.out.println(kthToLast.val);        
    }
}
