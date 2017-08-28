package future.fry.practice.dp;

/**
 *
 * @author ranjeet
 */
public class StrictlyIncreasingArray {

    /*
    Given an array of n integers. Write a program to find minimum number of 
    changes in array so that array is strictly increasing. 
    In strictly increasing array A[i] < A[i+1] for 0 <= i < n
     */
    public static void main(String[] args) {

        StrictlyIncreasingArray sia = new StrictlyIncreasingArray();
        int[] arr = {1, 2, 6, 5, 4};
        System.out.println("Min changes required : " + sia.minRemove(arr, arr.length));

    }

    private int minRemove(int[] arr, int n) {

        int[] lcs = new int[n];
        int len = 0;

        //update all LCS values as 1.
        for (int i = 0; i < n; i++) {
            lcs[i] = 1;
        }

        //Find lcs of array.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                //take max of lcs
                if (arr[i] > arr[j]) {
                    lcs[i] = Math.max(lcs[i], lcs[j] + 1);
                }
            }
            len = Math.max(len, lcs[i]);
        }

        //min element to remove is total element - lcs
        return n - len;

    }

}
