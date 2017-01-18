/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codechallenge.day6;

/**
 * Prob : Data Structures: Solve 'Contacts' Using Tries
 * <p>
 * @author ranjeet
 */
public class C6 {

    public static class Node {

        private static int NUMBER_OF_CHARACTERS = 26;
        Node[] childeren = new Node[NUMBER_OF_CHARACTERS];
        int size = 0;

        private static int getCharIndex(char c) {
            return c - 'a';
        }

        private Node getNode(char c) {
            return childeren[getCharIndex(c)];
        }

        private void setNode(char c, Node node) {
            childeren[getCharIndex(c)] = node;
        }

        private void add(String s) {
            add(s.toLowerCase(), 0);
        }

        private void add(String s, int index) {
            size++;
            if (s.length() == index) {
                return;
            }
            char currentChar = s.charAt(index);
            Node child = getNode(currentChar);
            if (child == null) {
                child = new Node();
                setNode(currentChar, child);
            }
            child.add(s, index + 1);
        }

        public int findCount(String s, int index) {
            if (index == s.length()) {
                return size;
            }
            Node child = getNode(s.charAt(index));
            if (child == null) {
                return 0;
            }
            return child.findCount(s, index + 1);
        }

    }

    public static void main(String[] args) {
        Node node = new Node();
        node.add("hack");
        node.add("hackerrank");
//        node.add("Geera");
//        node.add("Alex");
//        node.add("Andy");
        System.out.println(node.findCount("hac", 0)); //2
        System.out.println(node.findCount("hak", 0)); //0
    }
}
