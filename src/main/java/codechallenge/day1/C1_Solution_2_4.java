/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codechallenge.day1;

import codechallenge.LinkedList;
import java.util.Objects;

/**
 * Problem-2.4 | Write code to partition a linked list around a value x,
 * such that all nodes less than x come before all nodes greater than or equal
 * to x.
 * <p>
 * @author ranjeet
 */
public class C1_Solution_2_4 {

    public static void main(String[] args) {
        LinkedList head = createLinkedList();
        LinkedList linkedList = partitionLinkedList(head, 5);
        print(linkedList);

    }

    private static LinkedList createLinkedList() {
        LinkedList head = new LinkedList(1);
        LinkedList secondNode = new LinkedList(22);
        head.setNext(secondNode);
        LinkedList thirdNode = new LinkedList(3);
        secondNode.setNext(thirdNode);
        LinkedList fourthNode = new LinkedList(14);
        thirdNode.setNext(fourthNode);
        LinkedList fifthNode = new LinkedList(4);
        fourthNode.setNext(fifthNode);
        LinkedList sixthNode = new LinkedList(12);
        fifthNode.setNext(sixthNode);

        return head;

    }

    /*
     * Create two linked list | one for less than x and other equal to or
     * greater than x.
     * Put less than x node left.
     */
    private static LinkedList partitionLinkedList(LinkedList head, int x) {
        //base condition
        if (Objects.isNull(head)) {
            return head;
        }
        LinkedList leftNode = null, leftNodeEnd = null, leftNodeHead = null;
        LinkedList rightNode = null, rightNodeEnd = null, rightNodeHead = null;

        while (Objects.nonNull(head)) {
            if (head.data() >= x) {
                rightNode = new LinkedList(head.data());
                //set rightNode head
                if (Objects.isNull(rightNodeHead)) {
                    rightNodeHead = rightNode;
                }
                //keep track last  node
                if (Objects.nonNull(rightNodeEnd)) {
                    rightNodeEnd.setNext(rightNode);
                }
                rightNodeEnd = rightNode;
                rightNode = rightNode.next();
            } else {

                leftNode = new LinkedList(head.data());

                //set leftNode head
                if (Objects.isNull(leftNodeHead)) {
                    leftNodeHead = leftNode;
                }
                //keep track last  node
                if (Objects.nonNull(leftNodeEnd)) {
                    leftNodeEnd.setNext(leftNode);
                }
                leftNodeEnd = leftNode;
                leftNode = leftNode.next();
            }

            head = head.next();
        }
        //merge it
        if (!Objects.isNull(leftNodeHead)) {
            leftNodeEnd.setNext(rightNodeHead);
            return leftNodeHead;
        } else {
            return rightNodeHead;
        }
    }

    private static void print(LinkedList head) {
        while (Objects.nonNull(head)) {
            System.out.println(head.data());
            head = head.next();
        }
    }
}
