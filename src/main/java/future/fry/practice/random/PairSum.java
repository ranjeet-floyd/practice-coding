package future.fry.practice.random;

/**
 * Given an array A[] and a number x, check for pair in A[] with sum as x
 *
 * @author ranjeet
 */
public class PairSum {

    /*
    Write a Java program that, given an array A[] of n numbers and 
    another number x, determines whether or not there exist two elements 
    in S whose sum is exactly x.
     */
    public static void main(String[] args) {
        //Let Array be {1, 4, 45, 6, 10, -8} 
        //and sum to find be 16
        int[] arr = {1, 4, 45, 6, 10, -8};
        int x = 16;
        
        PairSum pairSum = new PairSum();
        System.out.println(pairSum.isPairSumExist(arr, x));

    }

    private boolean isPairSumExist(int[] arr, int sum) {

        boolean[] binMap = new boolean[10000]; //put some large number
        
        for (int i = 0; i < arr.length; i++) {
            int temp = sum - arr[i];
            if (temp >= 0 && binMap[temp]) {
                return true;

            }
            binMap[arr[i]] = true;

        }
        
        return false;

    }

}
