package com.nana.linkedlists;

import java.util.Stack;

public class Linkedlist {

    class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private Node head;

    public Linkedlist() {
        this.head = null;
    }

    /**
     * Append iteratively
     * 
     * @param n
     */
    public void append(int n) {

        if (this.head == null) {
            this.head = new Node(n);
            return;
        }

        Node curr = this.head;

        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = new Node(n);
    }

    /**
     * Append recursively
     * 
     * @param n
     */
    public void append_(int n) {

        if (this.head == null) {
            this.head = new Node(n);
            return;
        }

        _append(n, this.head);
    }

    public void _append(int val, Node curr) {
        if (curr.next == null) {
            curr.next = new Node(val);
            return;
        }

        _append(val, curr.next);
    }

    /**
     * Reverse linked list
     * 
     * @param head
     * @return
     */
    public Node reverse(Node head) {
        // head and the next is even, sub part
        // a-> b -> c-> d
        Node curr = head;
        Node prev = null;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }

    /**
     * You are given a singly-linked list that contains N integers. A subpart of the
     * list is a contiguous set of even elements,
     * bordered either by either end of the list or an odd element. For example, if
     * the list is [1, 2, 8, 9, 12, 16], the subparts of the list are [2, 8] and
     * [12, 16].
     * Then, for each subpart, the order of the elements is reversed. In the
     * example, this would result in the new list, [1, 8, 2, 9, 16, 12].
     * The goal of this question is: given a resulting list, determine the original
     * order of the elements.
     * 
     * @param head
     * @return
     */
    // Recursive function to reverse the consecutive
    // even nodes of the linked list

    Node reverseEven(Node head) {
        Node prev = null;
        return _reverseEven(head, prev);
    }

    Node _reverseEven(Node head, Node prev) {

        // Base case
        if (head == null)
            return null;

        Node temp;
        Node curr;
        curr = head;

        // Reversing nodes until curr node's value
        // turn odd or Linked list is fully traversed
        while (curr != null && curr.val % 2 == 0) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        // If elements were reversed then head
        // pointer needs to be changed
        if (curr != head) {
            head.next = curr;

            // Recur for the remaining linked list
            curr = _reverseEven(curr, null);
            return prev;
        }

        // Simply iterate over the odd value nodes
        else {
            head.next = _reverseEven(head.next, head);
            return head;
        }
    }

    public static void main(String[] args) {
        Linkedlist link = new Linkedlist();
        link.append(1);
        link.append(2);
        link.append(8);
        link.append(9);
        link.append(12);
        link.append(16);

        Node curr = link.head;

        while (curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }

        System.out.println(link.head);

    }

    /**
     * Given a resulting list (head),
     * determine the original order of the elements.
     * Will reverse only even segments.
     */
    static Node reverse3(Node head) {

        // **** sanity check(s) ****
        if (head == null || head.next == null)
            return head;

        // **** initialization ****
        Node revHead = null;
        Node revTail = null;
        Stack<Node> stack = new Stack<>();

        // **** traverse the linked list - O(n) ****
        for (Node p = head; p != null; p = p.next) {

            // ???? ????
            // System.out.println("<<< p: " + p.data);

            // **** even node ****
            if (p.val % 2 == 0) {
                stack.push(p);
            }

            // **** odd node ****
            else {

                // **** pop all nodes from the stack ****
                while (!stack.isEmpty()) {

                    // **** pop next node ****
                    Node node = stack.pop();

                    // **** reset next reference ****
                    node.next = null;

                    // **** set new head ****
                    if (revHead == null)
                        revHead = node;
                    else
                        revTail.next = node;

                    // **** update the reversed queue tail ****
                    revTail = node;
                }

                // **** set new head ****
                if (revHead == null)
                    revHead = p;
                else
                    revTail.next = p;

                // **** update the reversed queue tail ****
                revTail = p;
            }
        }

        // **** pop all nodes from the stack ****
        while (!stack.isEmpty()) {

            // **** pop next node ****
            Node node = stack.pop();

            // **** reset next reference ****
            node.next = null;

            // **** set new head ****
            if (revHead == null)
                revHead = node;
            else
                revTail.next = node;

            // **** update the reversed queue tail ****
            revTail = node;
        }

        // **** return head of reversed linked list ****
        return revHead;
    }

}
