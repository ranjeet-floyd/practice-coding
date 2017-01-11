/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codechallenge.day5;

/**
 * Problem: Describe how you could use a single array to implement three stacks.
 * <p>
 * @author ranjeet
 */
public class C5 {
    /*
     * Fixed Division apporach : Divide array in three equal parts.
     * For Stack 1, [0,n/3),
     * For Stack 2, [n/3, 2n/3),
     * For Stack 3, [2n/3, n)
     *
     */

    public static void main(String[] args) throws Exception {

        Stack stack = new Stack(100);

        stack.push(0, 1);
        stack.push(0, 2);
        stack.push(0, 3);
        while (!stack.isEmpty(0)) {
            System.out.println(stack.pop(0));
        }

    }

    private static class Stack {

        private int stackSize;
        int[] buffer = null;
        int[] stackPointer = {-1, -1, -1};//pointer to track top element

        public Stack(int _stackSize) {
            this.stackSize = _stackSize;
            buffer = new int[stackSize * 3];
        }

        public int absTopOfStack(int stackNum) {
            return stackNum * stackSize + stackPointer[stackNum];
        }

        //push
        public void push(int stackNum, int data) throws Exception {
            //check if we have space or not
            if (stackPointer[stackNum] + 1 >= stackSize) {
                throw new Exception("Out of space");
            }
            stackPointer[stackNum]++;
            buffer[absTopOfStack(stackNum)] = data;

        }

        public int pop(int stackNum) throws Exception {
            if (stackPointer[stackNum] == -1) {
                throw new Exception("trying to pop empty stack");
            }
            int data = buffer[absTopOfStack(stackNum)];//get top
            buffer[absTopOfStack(stackNum)] = 0; //clear index
            stackPointer[stackNum]--; //decrement pointer

            return data;
        }

        public int peek(int stackNum) {
            return buffer[absTopOfStack(stackNum)];
        }

        public boolean isEmpty(int stackNum) {
            return stackPointer[stackNum] == -1;
        }

        /*
         * Return found index else -1
         */
        public synchronized int search(int stackNum, int searchData) {
            int initialIndex = stackNum * stackSize;
            int lastIndex = (stackNum + 1) * stackSize - 1;
            for (int i = initialIndex; i <= lastIndex; i++) {
                if (buffer[i] == searchData) {
                    return i;
                }
            }
            return -1;
        }

    }

}
