/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codechallenge.day2;

import codechallenge.LinkedList;
import java.util.Objects;

/**
 * 2.5 | You have two number represented by a linked list, where each node
 * contains a
 * single digit. The digits are stored in reverse order, such that the 1's digit
 * is at the head
 * of the list. Write a function that adds the two numbers and returns the sum
 * as a linked list.
 * ** FOLLOW UP | suppose the digits are stored in forward order. Repeat the
 * above problem.
 * <p>
 * @author ranjeet
 */
public class C2 {

    /*
     * linked list 1 => 6 1 7
     * +
     * linked list 2 => 2 9 5
     * --------------------------
     * ---------------------12
     * ---------------------Put 2 in node
     * ------------------10 + 1 = 11
     * ---------------put 1 in node
     * ---------- 6 + 2 +1 = 9
     * Final result should be 912
     */
    public static void main(String[] args) {
        //first
        LinkedList firstHead = new LinkedList(7);
        firstHead.setNext(new LinkedList(1));
        firstHead.next().setNext(new LinkedList(6));

        //second
        LinkedList secondHead = new LinkedList(5);
        secondHead.setNext(new LinkedList(9));
        secondHead.next().setNext(new LinkedList(2));

        LinkedList sumNodes = addList(firstHead, secondHead, 0);
        printNode(sumNodes);

    }

    private static LinkedList addList(LinkedList l1, LinkedList l2, int carry) {
        //if both node are null and carry is 0
        if (Objects.isNull(l1) && Objects.isNull(l2) && carry == 0) {
            return null;
        }
        //add value and data from l1 and l2
        int value = carry;
        if (Objects.nonNull(l1)) {
            value += l1.data();
        }
        if (Objects.nonNull(l2)) {
            value += l2.data();
        }
        LinkedList result = new LinkedList(value % 10);
        //recursive
        if (Objects.nonNull(l1) || Objects.nonNull(l2)) {
            LinkedList more = addList(l1 == null ? null : l1.next(), l2 == null ? null : l2.next(), value >= 10 ? 1 : 0);
            result.setNext(more);
        }
        return result;
    }

    private static void printNode(LinkedList head) {

        while (Objects.nonNull(head)) {
            System.out.println(head.data());
            head = head.next();
        }
    }

}
