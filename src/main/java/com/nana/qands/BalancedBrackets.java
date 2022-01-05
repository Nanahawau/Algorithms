package com.nana.qands;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Stack;

public class BalancedBrackets {
    
    public static void main(String[] args) {
        System.out.println(balancedBracket("[(])"));
    }

    static boolean balancedBracket (String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> brackets = new HashMap<>();
        brackets.put('{', '}');
        brackets.put('[', ']');
        brackets.put('(', ')');

        // if length is odd, return false; 
        if (s.length() % 2 != 0)
            return false;
        
        for (int i = 0; i < s.length(); i++) {
        // if it's an opening bracket, push unto the stack. 
            if (brackets.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                Character bracket = stack.peek();

                if (brackets.get(bracket) == s.charAt(i))
                stack.pop();
            }
        }
        
        return stack.empty();
    }


    // function to check if brackets are balanced
    static boolean areBracketsBalanced(String expr)
    {
        // Using ArrayDeque is faster than using Stack class
        Deque<Character> stack
            = new ArrayDeque<Character>();
 
        // Traversing the Expression
        for (int i = 0; i < expr.length(); i++)
        {
            char x = expr.charAt(i);
 
            if (x == '(' || x == '[' || x == '{')
            {
                // Push the element in the stack
                stack.push(x);
                continue;
            }
 
            // If current character is not opening
            // bracket, then it must be closing. So stack
            // cannot be empty at this point.
            if (stack.isEmpty())
                return false;
            char check;
            switch (x) {
            case ')':
                check = stack.pop();
                if (check == '{' || check == '[')
                    return false;
                break;
 
            case '}':
                check = stack.pop();
                if (check == '(' || check == '[')
                    return false;
                break;
 
            case ']':
                check = stack.pop();
                if (check == '(' || check == '{')
                    return false;
                break;
            }
        }
 
        // Check Empty Stack
        return (stack.isEmpty());
    }
}
