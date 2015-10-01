package practice.CCAssignment.ch10;

/**
 *
 * @author Akash Gandotra
 */
class RankTree {

    Node root = null;

    void track(int num) {
        if (root == null) {
            root = new Node(num);
        } else {
            root.insertNode(num);
        }
    }

    int getRankOfNumber(int num) {
        return root.getRank(num);
    }
}

class Node {

    int left_size = 0;
    Node left;
    Node right;
    int data = 0;

    Node(int d) {
        data = d;
    }

    void insertNode(int d) {
        if (d <= data) {
            if (left != null) {
                left.insertNode(d);
            } else {
                left = new Node(d);
            }
            left_size++;
        } else {
            if (right != null) {
                right.insertNode(d);
            } else {
                right = new Node(d);
            }
        }
    }

    int getRank(int d) {
        if (d == data) {
            return left_size;
        } else if (d < data) {
            if (left == null) {
                return -1;
            } else {
                return left.getRank(d);
            }
        } else {
            int right_rank = (right == null) ? -1 : right.getRank(d);
            if (right_rank == -1) {
                return -1;
            }
            return left_size + 1 + right_rank;
        }
    }
}

public class Solution10 {

    public static void main(String[] args) {
        RankTree t = new RankTree();
        t.track(20);
        t.track(25);
        t.track(10);
        t.track(13);
        t.track(15);
        t.track(23);
        t.track(5);
        t.track(24);
        
        System.out.println("Rank of 5 = " + t.getRankOfNumber(5));
        System.out.println("Rank of 10 = " + t.getRankOfNumber(10));
        System.out.println("Rank of 13 = " + t.getRankOfNumber(13));
        System.out.println("Rank of 15 = " + t.getRankOfNumber(15));
        System.out.println("Rank of 20 = " + t.getRankOfNumber(20));
        System.out.println("Rank of 23 = " + t.getRankOfNumber(23));
        System.out.println("Rank of 24 = " + t.getRankOfNumber(24));
        System.out.println("Rank of 25 = " + t.getRankOfNumber(25));
    }
}
