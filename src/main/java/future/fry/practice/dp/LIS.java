package future.fry.practice.dp;

/**
 *
 * @author ranjeet
 */
public class LIS {

    /*
    The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of 
    a given sequence such that all elements of the subsequence are sorted in increasing order. For example, 
    the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
     */
    public static void main(String[] args) {
//        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 18};
        int[] arr = {10, 22, 33, 50, 60, 80};
        LIS lis = new LIS();
        System.out.println(lis.LISUsingBruteForce(arr) + 1);
        System.out.println(lis.LISUsingRecursion(arr, 0, arr.length - 1) + 1);
        System.out.println(lis.LISUsingDP(arr));
    }

    private int LISUsingBruteForce(int[] arr) {

        int lis;
        int currLis = 0;
        for (int i = 0; i < arr.length; i++) {
            lis = 0;
            int max = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (max < arr[j]) {
                    lis = lis + 1;
                    max = arr[j];
                }

            }
            if (lis > currLis) {
                currLis = lis;
            }
        }
        return currLis;
    }

    private int LISUsingRecursion(int[] arr, int low, int high) {

        if (low >= high) {
            return 0;
        }

        if (arr[high] > arr[high - 1]) {
            return 1 + LISUsingRecursion(arr, low, high - 1);
        }

        return Math.max(LISUsingRecursion(arr, low, high - 1), LISUsingRecursion(arr, low, high - 2));

    }

    private int LISUsingDP(int[] arr) {

        int[] L = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            L[i] = 1;
        }

        //
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                //update if greater and length will be less 
                if (arr[j] < arr[i] && L[i] < L[j] + 1) {
                    L[i] = L[j] + 1;
                }
            }
        }

        return L[arr.length - 1];
    }

}
