/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codechallenge.day3;

import codechallenge.LinkedList;
import java.util.Objects;

/**
 * 2.6 | Given a circular linked list, implement an algorithm which returns the
 * node
 * at the beginning of the loop.
 * <p>
 * @author ranjeet
 */
public class C3 {
    /*
     * An easy way to detect if a linked list has a loop is through the
     * FastRunner / SlowRunner approach. FastRunner moves two steps at a time,
     * while SlowRunner moves one step. Much like two cars racing around a track
     * at diiferent steps,
     * they must eventually meet.
     */

    public static void main(String[] args) {
        LinkedList head = new LinkedList(1);
        LinkedList n2 = new LinkedList(2);
        head.setNext(n2);
        LinkedList n3 = new LinkedList(3);
        n2.setNext(n3);
        LinkedList n4 = new LinkedList(4);
        n3.setNext(n4);
        n4.setNext(n2);

        LinkedList beginngHead = findBeginning(head);
        System.out.println(beginngHead.data());

    }

    private static LinkedList findBeginning(LinkedList head) {

        LinkedList slow = head;
        LinkedList fast = head;
        /*
         * find meeting point. This will be LOOP_SIZE -k steps into the
         * linked list
         */

        while (Objects.nonNull(fast) && Objects.nonNull(fast.next())) {
            slow = slow.next();
            fast = fast.next().next();

            //collision
            if (slow == fast) {
                break;
            }
        }
        //Error check - no meeting point and therefore no loop
        if (fast == null || fast.next() == null) {
            return null;
        }

        /*
         * Move slow to head. Keep fast at meeting point. Each are k steps
         * from the loop start. If they move at the same pace, they must meet at
         * Loop start.
         */
        slow = head;

        while (slow != fast) {
            slow = slow.next();
            fast = fast.next();
        }
        return fast;
    }

}
