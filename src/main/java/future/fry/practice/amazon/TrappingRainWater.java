package future.fry.practice.amazon;

/**
 *
 * @author ranjeet
 */
public class TrappingRainWater {

    /*
    Given n non-negative integers representing an elevation map where the width of each bar is 1, 
    compute how much water it is able to trap after raining.
     */
    public static void main(String[] args) {
        // For example, 
        // Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
    }

    public int trap(int[] heights) {
        int water = 0;
        int leftIndex = 0;
        int rightIndex = heights.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        while (leftIndex <= rightIndex) {
            leftMax = Math.max(leftMax, heights[leftIndex]);
            rightMax = Math.max(rightMax, heights[rightIndex]);
            if (leftMax < rightMax) {
                water += leftMax - heights[leftIndex];
                leftIndex++;
            } else {
                water += rightMax - heights[rightIndex];
                rightIndex--;
            }
        }
        return water;

    }

}
