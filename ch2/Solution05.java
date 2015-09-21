package practice.CCAssignment.ch2;

/**
 *
 * @author Akash Gandotra
 */
public class Solution05 {
    
    /**
     * Calculate sum of two numbers stored in reverse in two lists.
     * Return a list that stores the sum in reverse.
     * 
     * We traverse the lists forward adding the values in nodes and tracking the
     * value of carryovers from before, which are added to the next sum.
     * @param l1 list1
     * @param l2 list2
     * @return sum of numbers in reverse
     */
    public static ListNode sumListsReverse(ListNode l1, ListNode l2) {
        ListNode head = null, it = null;
        //Return null of both lists are null
        if (l1 == null && l2 == null) {
            return null;
        }
        //Return other list if one list is null.
        if (l1 == null || l2 == null) {
            return (l1 == null)? l2:l1;
        }

        int carry = 0, tot = 0;
        while (l1 != null || l2 != null) {
            tot = ((l1!=null)?l1.val:0) + ((l2!=null)?l2.val:0) + carry;
            if (tot > 9) {
                carry = 1;
                tot = tot % 10;
            }
            else
                carry = 0;
            if (head == null) {
                head = new ListNode(tot);
                it = head;
            } else {
                it.next = new ListNode(tot);
                it = it.next;
            }
            l1 = (l1!=null)?l1.next:l1;
            l2 = (l2!=null)?l2.next:l2;
        }
        if (carry > 0) {
            it.next = new ListNode(carry);
            it = it.next;
        }
        return head;
    }
    
    /**
     * Calculate sum of two numbers stored in forward order in two lists.
     * Return a list that stores the sum in forward order.
     * 
     * Pad the shorter list with zeroes to make both lists equal in length 
     * and perform addition on the lists in recursive manner.
     * @param l1 list1
     * @param l2 list2
     * @return sum of numbers in reverse
     */
    public static ListNode sumListsForward(ListNode l1, ListNode l2) {
        return sumListsForward(l1, l2, true);
    }
    
    public static ListNode sumListsForward(ListNode l1, ListNode l2, boolean firstCall) {
        ListNode head = null;
        if (l1 == null && l2 == null) {
            return ((firstCall)?null:new ListNode(0));
        }
        if (l1 == null || l2 == null) {
            return (l1 == null)? l2:l1;
        }
              
        //Find lengths of lists
        int len1 = ListUtility.length(l1);
        int len2 = ListUtility.length(l2);
        
        if(len1!=len2)
        {
            //Pad the shorter list with zeros to make lists equal in length
            ListNode shorter = (len1<len2)?l1:l2;
            ListNode tmp = null;
            int numNodesToBeAdded = (len1<len2)?(len2-len1):(len1-len2);
            for(int i=1; i<=numNodesToBeAdded; i++){
                tmp = new ListNode(0);
                tmp.next = shorter;
                shorter = tmp;
            }
            if(len1<len2)
                l1 = shorter;
            else
                l2 = shorter;
        }
        
        int carry = 0, tot = 0;
        ListNode res = sumListsForward(l1.next,l2.next,false);
        tot = l1.val + l2.val + ((res!=null)?res.val:0);
        if (tot > 9) {
            carry = 1;
            tot = tot % 10;
        }
        res.val = tot;
        head = new ListNode(carry);
        head.next = res;
        
        //Remove a zero from head of list if returning the final list.
        if(firstCall && head.val == 0){
            head = head.next;
        }
        
        return head;
    }
    
    public static void main(String[] args) {
        //Prepare List [7,1,6]
        ListNode n1 = new ListNode(7);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        
        //Prepare List [5,9,2,1]
        ListNode m1 = new ListNode(5);
        ListNode m2 = new ListNode(9);
        ListNode m3 = new ListNode(2);
        ListNode m4 = new ListNode(1);
        m1.next = m2;
        m2.next = m3;
        m3.next = m4;

        ListUtility.printList(n1);
        ListUtility.printList(m1);
        
        ListNode res = sumListsReverse(n1,m1); //617+1295=1912
        ListUtility.printList(res);      
        
        res = sumListsForward(n1,m1); //716+5921=6637
        ListUtility.printList(res);      
    }
}
