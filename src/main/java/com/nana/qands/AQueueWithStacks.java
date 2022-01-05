package com.nana.qands;

import java.util.Stack;

/**
 * A queue is an abstract data type. ADT is a type of policy,
 *  that defines the behavior and functionality of a type
 */
public class AQueueWithStacks {

    private Stack<String> enqueue = new Stack<>();
    private Stack<String> dequeue = new Stack<>();

    public static void main(String[] args) {

        AQueueWithStacks s = new AQueueWithStacks();
        s.enqueue("A");
        s.enqueue("B");
        s.enqueue("C");
        s.enqueue("D");

   

        System.out.println(s.dequeue());
        System.out.println(s.dequeue());
        System.out.println(s.dequeue());
        System.out.println(s.dequeue());
        System.out.println(s.dequeue());

        
    }


    public void enqueue(String item) {
        this.enqueue.push(item);
    }

    public String dequeue() {
        if(this.dequeue.empty()) {
           while(!this.enqueue.empty()) {
               this.dequeue.push(this.enqueue.pop());
           }
        } 

        if (enqueue.isEmpty() && dequeue.isEmpty())
        return "Queue is empty";

        return this.dequeue.pop();
    }

    public String peek () {
        return this.dequeue.peek();
    }
}
