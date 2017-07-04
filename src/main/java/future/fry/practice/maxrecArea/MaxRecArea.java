package future.fry.practice.maxrecArea;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Maximum rectangular area in Histogram.
 *
 * @author ranjeet
 */
public class MaxRecArea {

    /*
    * Given an array representing bar graph, find maximum histogram area or rectangle with maximum area.
     */
    public static void main(String[] args) {

        int[] arr = new int[]{2, 1, 2};
        System.out.println(maxArea(arr));
    }

    private static int maxArea(int[] arr) {

        Deque<Integer> stack = new LinkedList<>();
        int maxArea = -1;
        int i = 0;
        int area = -1;
        for (i = 0; i < arr.length;) {

            if (stack.isEmpty() || arr[stack.peekFirst()] <= arr[i]) {
                stack.offerFirst(i++);
            } else {
                int top = stack.pollFirst();
                if (stack.isEmpty()) {
                    area = arr[top] * i;
                } else {
                    area = arr[top] * (i - stack.peekFirst() - 1);
                }
                //update max area
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }

        while (!stack.isEmpty()) {
            int top = stack.pollFirst();
            if (stack.isEmpty()) {
                area = arr[top] * i;
            } else {
                area = arr[top] * (i - stack.peekFirst() - 1);
            }
            //update max area
            if (area > maxArea) {
                maxArea = area;
            }

        }

        return maxArea;

    }

}
