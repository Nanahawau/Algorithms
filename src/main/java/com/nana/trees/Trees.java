package com.nana.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Trees {
    public static void main(String[] args) {

        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");

        a.setLeft(b); 
        a.setRight(c);
        b.setLeft(d);  
        b.setRight(e);
        c.setRight(f);


        NodeInt one = new NodeInt(2);
        NodeInt two = new NodeInt(4);
        NodeInt three = new NodeInt(5);
        NodeInt four = new NodeInt(6);
        NodeInt five = new NodeInt(7);
        NodeInt six = new NodeInt(8);

        one.setLeft(two); 
        one.setRight(three);
        two.setLeft(four);  
        two.setRight(five);
        three.setRight(six);

        // DFS(a);
        // RecursiveDFS(a);
        // BFS(a);
        // treeSum(one);
        // treeSumRecursive(one);
        // treeMinimumValue(one);
        treeMinimumValueR(one);
        
    }

    static void DFS (Node root) {
        Stack<Node> s = new Stack<Node>();
        
        s.push(root);

        while(!s.isEmpty()) {
         Node current = s.pop();
         System.out.println(current.getValue());
    
         if(current.getRight() != null)
         s.push(current.getRight());


         if(current.getLeft() != null) 
           s.push(current.getLeft());
        }
    }


    static void RecursiveDFS (Node root) {
      // Base Case 
      if (root == null)
            return;

     System.out.println(root.getValue());
     RecursiveDFS(root.getLeft());
     RecursiveDFS(root.getRight());
      // Recursive Case
    }


    // Breadth first traversal uses a queue. 
    
    static void BFS (Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            Node current = q.poll();

            System.out.println(current.getValue());

            if (current.getLeft() != null)
            q.offer(current.getLeft());

            if (current.getRight() != null)
            q.offer(current.getRight());
        }

    }

    
    static boolean searchRecursive (Node root, String value) {
        if (root == null)
            return false;

        if (root.getValue() == value)
            return true;

        return searchRecursive(root.getLeft() , value) || searchRecursive(root.getRight(), value);
    }


    static int treeSum (NodeInt root) {
        int sum = 0;

        if (root == null)
        return 0;

        Queue<NodeInt> q = new LinkedList<NodeInt>();
        q.add(root);

        while(!q.isEmpty()) {
            NodeInt current = q.poll();

            sum += current.getValue();

            if(current.getLeft() != null)
                q.offer(current.getLeft());

            if(current.getRight() != null)
                q.offer(current.getLeft());
        }
        System.out.println(sum);
        return sum;
    }


        

    static int treeSumRecursive (NodeInt root) {
        if (root == null)
        return 0;

        return root.getValue() + treeSumRecursive(root.getLeft()) + treeSumRecursive(root.getRight());
    }


    static int treeMinimumValue (NodeInt root) {
        if (root == null) 
            return 0;
            
        Queue<NodeInt> q = new LinkedList<>();
        Integer minimumValue = Integer.MAX_VALUE;
        q.add(root);

        while(!q.isEmpty()) {
            NodeInt current = q.poll();

            if (current.getValue() < minimumValue) {
                minimumValue = current.getValue();
            }
      
            if (current.getLeft() != null)
            q.offer(current.getLeft());

            if (current.getRight() != null)
            q.offer(current.getRight());
        }

        System.out.println(minimumValue);
        return minimumValue;
    }



    static int treeMinimumValueR (NodeInt root) {

        if (root == null) 
            return Integer.MAX_VALUE;
    
        int left = treeMinimumValueR(root.getLeft());
        int right = treeMinimumValueR(root.getRight());

        int smallest =  Math.min(root.getValue(), left);

        System.out.println(Math.min(smallest, right));
        return Math.min(smallest, right);
    }

    /**
     * Maximum path from root to all leaves
     * @param root
     */
    static void maxRootToLeafPathSum (NodeInt root) {
        


    }


    
}

class NodeInt {
    private int value;
    private NodeInt left = null;
    private NodeInt right = null;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public NodeInt getLeft() {
        return left;
    }

    public void setLeft(NodeInt left) {
        this.left = left;
    }

    public NodeInt getRight() {
        return right;
    }

    public void setRight(NodeInt right) {
        this.right = right;
    }


    public NodeInt (int value) {
        this.value = value;
    }
}

class Node {
    private String value;
    private Node left = null;
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    private Node right = null;

    public Node (String value) {
        this.value = value;
    }
}