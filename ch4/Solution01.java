package practice.CCAssignment.ch4;

import practice.CCAssignment.ch4.TreesNGraphsUtility.State;

/**
 *
 * @author Akash Gandotra
 */

/**
 * This class represents a Node for a graph.
 * Each node also stores the state of node - Unvisited, Visiting or Visited
 */
class Node{
    int val;
    Node[] children;
    State state;
    Node(int val){
        this.val = val;
        state = State.Unvisited;
    }
    void setChildren(Node[] children){
        this.children = children;
    }
}
/**
 * This class represents a graph.
 * It stores all nodes in the graph.
 */
class Graph{
    Node[] nodes;
    Graph(Node[] nodes){
        this.nodes = nodes; 
    }
}

public class Solution01 {
    
    /**
     * This method runs a depth first search to check whether a route
     * exists between two nodes. We run depth first dearch starting from one 
     * node and once it is run, we conclude that we found a route if both nodes
     * are marked as visited.
     * 
     * @param g Graph containing all nodes
     * @param nodeA first node
     * @param nodeB second node
     * @return true if a route exists between the nodes
     */
    public boolean doesRouteExist(Graph g, Node nodeA, Node nodeB){
        if(nodeA == null || nodeB == null)
            return false;
        
        checkRoute(nodeA, nodeB);
        
        if(nodeA.state == State.Visited &&  nodeB.state == State.Visited)
            return true;
        
        return false;
    }
    
    /**
     * This method implements a depth first search to check whether a route
     * exists between two nodes. We stop the search if we reach the second node
     * starting from the first node.
     * 
     * @param nodeA first node
     * @param nodeB second node
     */
    public void checkRoute(Node nodeA, Node nodeB){        
        nodeA.state = State.Visited;
        if(nodeA == nodeB)
            return;
        
        for(Node n: nodeA.children){
            if(n.state != State.Visited){
                checkRoute(n, nodeB);
            }
        }
    }

    /*
    *   0 -> 1 -> 2 <- 3
    *   ^         |
    *   |_________|
    *
    *
    */
    public static void main(String args[]){
        Solution01 obj = new Solution01();
        Node zero = new Node(0);
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        zero.setChildren(new Node[]{one});
        one.setChildren(new Node[]{two});
        two.setChildren(new Node[]{zero});
        three.setChildren(new Node[]{two});
        Graph g = new Graph(new Node[]{zero, one, two, three});
        System.out.println(obj.doesRouteExist(g, one, zero)); //true
        System.out.println(obj.doesRouteExist(g, one, one)); //true
        System.out.println(obj.doesRouteExist(g, one, two)); //true
        System.out.println(obj.doesRouteExist(g, one, three)); //false
    }    
    
}
