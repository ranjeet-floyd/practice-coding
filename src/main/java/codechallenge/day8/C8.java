/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codechallenge.day8;

/**
 *
 * For the purposes of this challenge, we define a binary search tree to be a
 * binary tree with the following ordering properties:
 * <p>
 * .. The data value of every node in a node's left subtree is less than the
 * data value of that node.
 * <p>
 * .. The data value of every node in a node's right subtree is greater than the
 * data value of that node.
 * <p>
 * Given the root node of a binary tree, can you determine if it's also a binary
 * search tree?
 * <p>
 * Complete the function in your editor below, which has parameter: a pointer to
 * the root of a binary tree. It must return a boolean denoting whether or not
 * the binary tree is a binary search tree. You may have to write one or more
 * helper functions to complete this challenge.
 * <p>
 * Note: A binary tree is not a binary search if there are duplicate values.
 * <p>
 * @author ranjeet
 * @see
 * https://www.hackerrank.com/challenges/ctci-is-binary-search-tree?h_r=next-challenge&h_v=zen
 */
public class C8 {

    public static void main(String[] args) {

    }
    /*
     * Hidden stub code will pass a root argument to the function below.
     * Complete the function to solve the challenge. Hint: you may want to write
     * one or more helper functions. *
     * The Node class is defined as follows:
     */

    /*
     * Hidden stub code will pass a root argument to the function below.
     * Complete the function to solve the challenge. Hint: you may want to write
     * one or more helper functions. *
     * The Node class is defined as follows:
     */
    class Node {

        int data;
        Node left;
        Node right;
    }

    boolean checkBST(Node root) {
        return vailidateRoot(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    /*
     * Node -> check node left data < root data < right data
     */
    private static boolean vailidateRoot(Node root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (min >= root.data || root.data >= max) {
            return false;
        }

        return vailidateRoot(root.left, min, root.data) && vailidateRoot(root.right, root.data, max);

    }
}
