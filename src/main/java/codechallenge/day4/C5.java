/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codechallenge.day4;

import codechallenge.LinkedList;
import java.util.Objects;
import java.util.Stack;

/**
 * Problem : Implement a function to check if a linked list is palindrome.
 * <p>
 * eg : 0 -> 1 -> 2 -> 1 -> 0
 * <p>
 * @author ranjeet
 */
public class C5 {

    public static void main(String[] args) {
        LinkedList head = new LinkedList(0);
        head.setNext(new LinkedList(1));
        head.next().setNext(new LinkedList(2));
        head.next().next().setNext(new LinkedList(1));
        head.next().next().next().setNext(new LinkedList(0));

        boolean isPalindrome = isPalindrome(head);

        System.out.println("isPalindrome : " + isPalindrome);

        /*
         * Make non palindrome
         */
        head.next().next().next().next().setNext(new LinkedList(0));
        boolean isNowPalindrome = isPalindrome(head);
        System.out.println("isPalindrome : " + isNowPalindrome);
    }

    private static boolean isPalindrome(LinkedList head) {
        //base condition
        if (Objects.isNull(head)) {
            return false;
        }

        LinkedList slow = head;
        LinkedList fast = head;

        Stack<Integer> stack = new Stack<>();
        /*
         * Push element for fist half of linked list into stack. When
         * fast runner (moving @ 2x speed.) reaches the end of the linked list,
         * then we know we are in the middle.
         */
        while (Objects.nonNull(fast) && Objects.nonNull(fast.next())) {
            stack.push(slow.data());
            slow = slow.next();
            fast = fast.next().next();
        }
        /*
         * If odd number of elements, so skip the middle element.
         *
         */
        if (Objects.nonNull(fast)) {
            slow = slow.next();
        }

        //now compare stack with other half of linked list.
        while (Objects.nonNull(slow)) {
            int top = stack.pop();
            /*
             * If value are diffent then it is nor palindrome.
             */
            if (top != slow.data()) {
                return false;
            }

            slow = slow.next();
        }
        return true;
    }
}
