package future.fry.practice.linkedList;

/**
 *
 * @author ranjeet
 */
public class LinkedListSum {

    /*
    In a given linked list which contains zero values in some nodes calculate sum of 
    values between two zeros and replace the zero value in the linked list by that sum.
     */

    public static void main(String[] args) {
        //Eg: 7 0 4 5 6 0 1 1 will become 7 15 1 1.
        LinkedListNode node1 = new LinkedListNode(7);
        node1.next = new LinkedListNode(0);
        node1.next.next = new LinkedListNode(4);
        node1.next.next.next = new LinkedListNode(5);
        node1.next.next.next.next = new LinkedListNode(6);
        node1.next.next.next.next.next = new LinkedListNode(0);
        node1.next.next.next.next.next.next = new LinkedListNode(1);
        node1.next.next.next.next.next.next.next = new LinkedListNode(0);
        node1.next.next.next.next.next.next.next.next = new LinkedListNode(1);
        node1.next.next.next.next.next.next.next.next.next = new LinkedListNode(0);
        LinkedListSum listSum = new LinkedListSum();
        listSum.modify(node1);
        while (node1 != null) {

            System.out.println(node1.data);
            node1 = node1.next;
        }

    }

    private void modify(LinkedListNode head) {
        LinkedListNode firstZeroNode = null;
        LinkedListNode lastNonZeroNodeAfterZero = null;
        int sumBtwZero = 0;
        LinkedListNode tmp = head;
        while (tmp != null) {

            if (tmp.data == 0) {
                if (firstZeroNode == null) {
                    firstZeroNode = tmp;
                }


            } else {
                if (firstZeroNode != null && lastNonZeroNodeAfterZero == null) {
                sumBtwZero += tmp.data;
                if (tmp.next != null && tmp.next.data == 0) {
                    lastNonZeroNodeAfterZero = tmp;

                }
                }
                if (firstZeroNode != null && lastNonZeroNodeAfterZero != null) {
                    //replace  first zero node with sum
                    firstZeroNode.data = sumBtwZero;

                    LinkedListNode lastZeroNodee = tmp.next;
                    tmp.next = tmp.next.next;
                    lastZeroNodee.next = null;
                    firstZeroNode = null;
                    lastNonZeroNodeAfterZero = null;
                    sumBtwZero = 0;



                }
            }

            tmp = tmp.next;



        }

    }

}
