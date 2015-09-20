package practice.CCAssignment.ch2;

/**
 *
 * @author Akash Gandotra
 */
public class Intersection {

    public static ListNode findIntersection(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode l1 = headA;
        ListNode l2 = headB;
        
        //Find length of lists
        int len1 = 1;
        for (; l1.next != null; len1++, l1 = l1.next);

        int len2 = 1;
        for (; l2.next != null; len2++, l2 = l2.next);
        
        if(l1 != l2)
            return null;

        //Find difference in length of lists
        int dif = (len1 > len2) ? (len1 - len2) : (len2 - len1);
        //Move the head of long list ahead by this number so that the lists
        // are equal in length from this point onwards.
        ListNode shortList = (len1 > len2) ? (headB) : (headA);
        ListNode longList = (len1 > len2) ? headA : headB;
        for (int i = 1; i <= dif; longList = longList.next, i++);
        
        //Travserse on both lists until they meet at an intersecting node.
        while (shortList != null && longList != null) {
            if (shortList == longList) {
                return shortList;
            }
            shortList = shortList.next;
            longList = longList.next;

        }
        return null;
    }

    public static void main(String[] args) {
        //Prepare List [1,2,3,4,8,9]
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(8);
        ListNode n6 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        //Prepare Intersecting List [6,5,4,8,9]
        ListNode m1 = new ListNode(6);
        ListNode m2 = new ListNode(5);
        m1.next = m2;
        m2.next = n4;

        ListUtility.printList(n1);
        ListUtility.printList(m1);

        ListNode res = findIntersection(n1, m1);
        if(res == null)
            System.out.println("No Intersection");
        else
            System.out.println("Intersection at : " + res.val);
    }

}
