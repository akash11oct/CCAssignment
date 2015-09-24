package practice.CCAssignment.ch4;

/**
 * This class represents a Tree Node without parent links.
 * @author Akash Gandotra
 */
public class TreeNode {

    private TreeNode left;
    private TreeNode right;
    private int data;

    public TreeNode(int data) {
        this.data = data;
    }

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public TreeNode getLeft() {
        return this.left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return this.right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "" + data;
    }
}
