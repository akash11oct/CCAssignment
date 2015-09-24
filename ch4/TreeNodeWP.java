package practice.CCAssignment.ch4;

import practice.CCAssignment.ch4.TreesNGraphsUtility.State;

/**
 * This class represents a Tree Node with parent links.
 * @author Akash Gandotra
 */

//private enum State{ Unvisited, Visiting, Visited}
public class TreeNodeWP {

    public TreeNodeWP left;
    public TreeNodeWP right;
    public int data;
    public TreeNodeWP parent;
    State state;

    public TreeNodeWP(int data) {
        this.data = data;
        state = State.Unvisited;
    }

    public TreeNodeWP getLeft() {
        return this.left;
    }

    public void setLeft(TreeNodeWP left) {
        this.left = left;
        left.parent = this;
    }

    public TreeNodeWP getRight() {
        return this.right;
    }

    public void setRight(TreeNodeWP right) {
        this.right = right;
        right.parent = this;
    }

    public TreeNodeWP getParent() {
        return parent;
    }

    public void setParent(TreeNodeWP parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "" + data;
    }
}
