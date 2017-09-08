package future.fry.practice.dp;

import static java.lang.Math.abs;

/**
 *
 * @author ranjeet
 */
public class PartitionSet {

    /*
     * Given a set of integers, the task is to divide it into two sets S1 and S2
     * such that the absolute difference between their sums is minimum.
     *
     * If there is a set S with n elements, then if we assume Subset1 has m
     * elements, Subset2 must have n-m elements and the value of
     * abs(sum(Subset1) – sum(Subset2)) should be minimum.
     */
    public static void main(String[] args) {

        /*
         * Input: arr[] = {1, 6, 11, 5} 
            Output: 1 
          Explanation: 
            Subset1 = {1, 5, 6}, sum of Subset1 = 12 
            Subset2 = {11}, sum of Subset2 = 11
         */
        PartitionSet partitionSet = new PartitionSet();
        int[] arr = {1, 5, 6, 11, 5};

        System.out.println("Min Sum: " + partitionSet.findMinSum(arr, 0, 0, 0));
    }

    public int findMinSum(int[] arr, int i, int sumCalculated, int totalSum) {

        //base condition
        if (i == arr.length) {
            System.out.println(abs(totalSum - sumCalculated));
            return abs(totalSum - sumCalculated);
        }

        return Math.min(findMinSum(arr, i + 1, sumCalculated + arr[i], totalSum),
                findMinSum(arr, i + 1, sumCalculated, totalSum + arr[i]));

    }

}
