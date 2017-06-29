package future.fry.practice.dynamic;

/**
 * Subset Sum Problem Dynamic Programming
 *
 * @author ranjeet
 */
public class SubsetSumProblem {

    /*
     * Given a set of non negative numbers and a total, find if there exists a
     * subset in this set whose sum is same as total.
     *
     * Total : 11 | 2, 3, 7, 8, 10
     *
     */
    public static void main(String[] args) {

        int sum = 14;
        int[] arr = {2, 3, 7, 8, 10};

        boolean[][] subSetSum = subSetSum(arr, sum);
        for (boolean[] bs : subSetSum) {
            for (boolean b : bs) {
                System.out.print(b + "|");
            }

            System.err.println("");
        }

        System.out.println(" \n ** Is Subset Possible : " + subSetSum[arr.length - 1][sum - 1]);

    }

    public static boolean[][] subSetSum(int[] arr, int sum) {
        boolean[][] sumArr = new boolean[arr.length][sum];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < sum; j++) {
                if (j == 0) {
                    sumArr[i][j] = true;
                } else {
                    /*
                    Check
                    1. Can i go up
                    2. Can i go back
                    
                     */

                    if (i - 1 >= 0 && j - arr[i] >= 0) {
                        sumArr[i][j] = sumArr[i - 1][j - arr[i]];

                    } else {
                        /*
                        Can i go back
                         */
                        if (j - arr[i] >= 0) {
                            sumArr[i][j] = sumArr[i][j - arr[i]];
                        } else {
                            sumArr[i][j] = false;
                        }
                    }

                }
            }
        }
        return sumArr; //return last element..that is result

    }

}
