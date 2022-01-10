package com.nana.linkedlists;

import java.util.HashMap;

import com.nana.linkedlists.Linkedlist.Node;

class Dups {
    // This is an input class. Do not edit.
    public static class LinkedList {
      public int value;
      public LinkedList next;
  
      public LinkedList(int value) {
        this.value = value;
        this.next = null;
      }
    }
  
    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
      // Write your code here.
          
          HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
          LinkedList curr = linkedList;
          LinkedList prev = null;
          
          if (linkedList == null)
              return null; 
          
          while (curr != null) {
              int value = curr.value;
              if (map.containsKey(value)) {
                      prev.next = curr.next;
              } else {
                  map.put(value,value);
                  prev = curr;
              }
                  curr = curr.next;
          }		
      return linkedList;
    }

/**
 * Sorted Linked list
 * @param head
 * @return
 */
    LinkedList removeDuplicates (LinkedList head) {
        /*Another reference to head*/
        LinkedList curr = head;
 
        /* Traverse list till the last node */
        while (curr != null) {
            LinkedList temp = curr;
            /*Compare current node with the next node and
            keep on deleting them until it matches the current
            node data */
            while(temp != null && temp.value == curr.value) {
                temp = temp.next;
            }
            /*Set current node next to the next different
            element denoted by temp*/
            curr.next = temp;
            curr = curr.next;
        }
        return head;
    }


    
  }