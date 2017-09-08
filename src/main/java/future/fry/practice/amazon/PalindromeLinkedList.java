package future.fry.practice.amazon;

import java.util.Stack;

/**
 *
 * @author ranjeet
 */
public class PalindromeLinkedList {

    public static void main(String[] args) {
        
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        
        System.out.println(new PalindromeLinkedList().isPalindrom(head));

    }

    private boolean isPalindrom(Node head) {

        // empty or single linked list in palindrom
        if (head == null || head.next == null) {
            return true;
        }

        Stack<Integer> stack = new Stack<>();

        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            fast = fast.next.next;
            slow = slow.next;
        }

        //odd
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {

            if (stack.pop() != slow.val) {
                return false;
            }
            slow = slow.next;

        }
        return true;
    }

    private static class Node {

        int val;
        Node next;

        public Node(int x) {
            val = x;
        }

    }
}
