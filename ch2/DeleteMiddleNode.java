package practice.CCAssignment.ch2;

/**
 *
 * @author Akash Gandotra
 */
public class DeleteMiddleNode {
    
    /**
     * Delete middle node in singly linked list, given access to that node.
     * Copy the value in the next node into this node and delete the next node.
     * @param node the node in list to be deleted
     */
    public static void deleteMiddleNodeInList(ListNode node) {
        if(node == null)
            return;
        node.val = node.next.val;
        ListNode tmp = node.next;
        node.next = node.next.next;
        tmp.next = null;
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
        deleteMiddleNodeInList(n3);
        ListUtility.printList(n1);      
    }
    
}
