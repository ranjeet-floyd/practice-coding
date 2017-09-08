package future.fry.practice.amazon;

/**
 *
 * @author ranjeet
 */
public class AddTwoNumbers {

    /*
    Given two non-empty linked lists representing two non-negative intergers.
    The digits are stored inreverse order and each of their nodes  contain a single digit.
    Add two number and return as linked list.
     */
    public static void main(String[] args) {
        /*
        Input: (2 -> 4 -> 3 ) + (5 -> 6 -> 4)
        Output : 7 -> 0 -> 8
         */

        Node l1 = new Node(2);
        l1.next = new Node(4);
        l1.next.next = new Node(3);
        //
        Node l2 = new Node(5);
        l2.next = new Node(6);
        l2.next.next = new Node(4);
        Node resultNode = new AddTwoNumbers().addTwoNumber(l1, l2);
        while (resultNode != null) {
            System.out.println(resultNode.val);
            resultNode = resultNode.next;
        }
    }

    private Node addTwoNumber(Node l1, Node l2) {

        Node currNode1 = l1;
        Node currNode2 = l2;
        int sum = 0;
        Node head = new Node(0);
        Node currHead = head;

        while (currNode1 != null || currNode2 != null) {

            sum /= 10;

            if (currNode1 != null) {
                sum += currNode1.val;
                currNode1 = currNode1.next;
            }
            if (currNode2 != null) {
                sum += currNode2.val;
                currNode2 = currNode2.next;
            }

            currHead.next = new Node(sum % 10);
            currHead = currHead.next;
        }

        if (sum / 10 == 1) {

            currHead.next = new Node(1);
        }
        return head.next;
    }

    private static class Node {

        int val;
        Node next;

        Node(int x) {
            val = x;
        }
    }
}
