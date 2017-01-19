/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codechallenge.day7;

import java.util.Arrays;

/**
 * Prob:
 * A left rotation operation on an array of size shifts each of the array's
 * elements unit to the left.
 * For example, if left rotations are performed on array [1,
 * 2,3,4,5], then the array would become .[3,4,5,1,2].
 * Given an array of integers n and a number,d , perform d left rotations on the
 * array
 * <p>
 * @author ranjeet
 */
public class C7 {

    public static void main(String[] args) {
        int[] inputInts = {1, 2, 3, 4, 5};
        int[] rotatedInts = rotateToLeft(inputInts, 2);
        System.out.println(Arrays.toString(rotatedInts));
    }

    private static int[] rotateToLeft(int[] ints, int d) {
        int len = ints.length;
        //create new  int array to hold rotated array
        int[] rootatedArray = new int[len];
        //copy element from old array to new array
        //right from d
        for (int i = d; i < len; i++) {
            rootatedArray[i - d] = ints[i];
        }

        //left from d
        for (int i = 0; i < d; i++) {
            rootatedArray[len - d + i] = ints[i];
        }
        return rootatedArray;
    }

}
