package com.nana.trees;

import java.util.Stack;

public class Trees {
    public static void main(String[] args) {

        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");

        a.setLeft(b); 
        a.setRight(c);
        c.setLeft(d);  
        
    }

    static void DFS (Node root) {
        Stack<Node> s = new Stack<Node>();
        s.push(root);

        while(!s.isEmpty()) {
         Node current = s.pop();
         System.out.println(current.getValue());

         if(current.getLeft() != null) {
            s.push(current.getLeft());
         }

         if(current.getRight() != null)
         s.push(current.getRight());
         
        }
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