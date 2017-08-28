package future.fry.practice.random;

/**
 *
 * @author ranjeet
 */
public class MidElementLinkedList {

    /*
    Find the middle of a given linked list 
     */

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        MidElementLinkedList mell = new MidElementLinkedList();
        System.out.println(mell.midElement(head));

    }

    private int midElement(Node head) {

        Node slower = head;
        Node faster = head;

        while (faster != null && faster.next != null) {
            faster = faster.next.next;
            slower = slower.next;
        }

        return slower.data;

    }

    private static class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }
}
