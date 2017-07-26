package future.fry.practice.random;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ranjeet
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(10);
        lRUCache.access(1);
//        lRUCache.printCache();

        lRUCache.access(2);
//        lRUCache.printCache();

        lRUCache.access(3);
//        lRUCache.printCache();

        lRUCache.access(4);
        lRUCache.printCache();

        lRUCache.access(1);
        lRUCache.printCache();
    }

    /*
    Implement LRU using doubly linked list and hashmap 
    
     */
    private DoublyLinkedList doublyLinkedList;
    private Map<Integer, Node> nodeMap;

    private final int cacheSize;

    public LRUCache(int cacheSize) {
        this.cacheSize = cacheSize;
        doublyLinkedList = new DoublyLinkedList(cacheSize);
        nodeMap = new HashMap<>();
    }

    public void access(int key) {
        if (nodeMap.containsKey(key)) {
            Node cacheNode = nodeMap.get(key);
            //update cache
            doublyLinkedList.update(cacheNode);
        } else {
            Node newNode = doublyLinkedList.add(key);
            nodeMap.put(key, newNode);
        }
    }

    public void printCache() {
        doublyLinkedList.printList();
    }

    private static class DoublyLinkedList {

        private final int size;
        private int currSize;

        Node head;
        Node tail;

        public DoublyLinkedList(int size) {
            this.size = size;
            currSize = 0;
        }

        //add n to list
        public Node add(int n) {

            Node node = new Node(n);
            if (head == null) {
                head = node;
                tail = node;
                currSize = 1;

            } else {

                if (currSize < size) {
                    //cache is not full.
                    currSize++;

                } else {
                    //remove last | head
                    tail = tail.prev;
                    tail.next = null;

                }
                node.next = head;
                head.prev = node;
                head = node;

            }

            return node;

        }

        public void update(Node node) {

            //already head
            if (node == null || node == head) {

                return;
            }

            if (node == tail) {
                tail = tail.prev;
                tail.next = null;
            }

            //move to head
            node.next = head;
            node.prev = null;

            head = node; //update head

        }

        public void printList() {
            if (head == null) {
                return;
            }

            Node tmp = head;

            while (tmp != null) {
                System.out.println(tmp.data);
                tmp = tmp.next;
            }
        }

        public int getCurrSize() {
            return currSize;
        }

        public void setCurrSize(int currSize) {
            this.currSize = currSize;
        }

        public Node getHead() {
            return head;
        }

        public void setHead(Node head) {
            this.head = head;
        }

        public Node getTail() {
            return tail;
        }

        public void setTail(Node tail) {
            this.tail = tail;
        }

    }

    private static class Node {

        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 29 * hash + this.data;
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Node other = (Node) obj;
            if (this.data != other.data) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return "Node{" + "data=" + data + '}';
        }

    }
}
