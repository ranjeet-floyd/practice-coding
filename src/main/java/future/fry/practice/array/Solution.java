package future.fry.practice.array;

/**
 *
 * @author ranjeet
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = {1, 2};
        int[] nums2 = {3};

        System.out.println(s.findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1_len = nums1.length;
        int nums2_len = nums2.length;
        int i = 0; //nums1 index
        int j = 0; //nums2 index
        boolean total_len_even = (nums1_len + nums2_len) % 2 == 0;
        int midPoint = (nums1_len + nums2_len + 1) / 2;
        int k = 0; //combine index
        int[] lastTwoNums = new int[2];
        while (i < nums1_len && j < nums2_len) {

            if (i == midPoint || j == midPoint) {

                if (total_len_even) {

                    return (lastTwoNums[0] + lastTwoNums[1]) / 2;
                } else {

                    return lastTwoNums[1];
                }
            }

            lastTwoNums[0] = lastTwoNums[1];

            if (nums1[i] <= nums2[j]) {
                lastTwoNums[1] = nums1[i];
                i++;
                k++;

            } else {
                lastTwoNums[1] = nums2[j];
                j++;
                k++;
            }

        }
        if (i < nums1_len) {
            for (int m = i; m < nums1_len; m++) {
                if (i == midPoint) {
                    if (total_len_even) {

                        return (lastTwoNums[0] + lastTwoNums[1]) / 2;
                    } else {
                        return lastTwoNums[1];
                    }
                }
                lastTwoNums[0] = lastTwoNums[1];
                lastTwoNums[1] = nums1[m];

            }
        }

        if (i < nums2_len) {
            for (int n = j; n < nums1_len; n++) {
                if (j == midPoint) {
                    if (total_len_even) {

                        return (lastTwoNums[0] + lastTwoNums[1]) / 2;
                    } else {
                        return lastTwoNums[1];
                    }
                }
                lastTwoNums[0] = lastTwoNums[1];
                lastTwoNums[1] = nums1[n];

            }
        }
        return -1;

    }

}
