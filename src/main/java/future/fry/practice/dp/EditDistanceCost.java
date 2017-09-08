package future.fry.practice.dp;

/**
 *
 * @author ranjeet
 */
public class EditDistanceCost {

    /**
     * Given two strings str1 and str2 and below operations that can performed
     * on str1. Find minimum number of edits (operations) required to convert
     * ‘str1’ into ‘str2’. a.Insert b.Remove c.Replace All of the above
     * operations are of equal cost.
     */
    public static void main(String[] args) {
        /*
        Input:   str1 = "geek", str2 = "gesek"
        Output:  1
        We can convert str1 into str2 by inserting a 's'.

         */

        EditDistanceCost editDistanceCost = new EditDistanceCost();
        String str1 = "geek";
        String str2 = "gesek";
//        String str1 = "sunday";
//        String str2 = "saturday";
        System.out.println("Min Cost from [" + str1 + "] to [" + str2 + "] is : " + editDistanceCost.minEditDistanceRecurrsion(str1.toCharArray(), str2.toCharArray(), str1.length() - 1, str2.length() - 1));
        System.out.println("Min Cost from [" + str1 + "] to [" + str2 + "] is : " + editDistanceCost.minEditDistanceDP(str1.toCharArray(), str2.toCharArray(), str1.length(), str2.length()));

    }

    /*
    min cost to convert str1 to str2
    m = length of str1
    n = length of str2
    T : O(3 power m)
     */
    private int minEditDistanceRecurrsion(char[] strChar1, char[] strChar2, int m, int n) {
        //base condition
        if (m == 0) {
            //need to insert all remaining character
            return n;
        }
        if (n == 0) {
            //need to delete all remaining character
            return m;
        }

        if (strChar1[m] == strChar2[n]) {
            return minEditDistanceRecurrsion(strChar1, strChar2, m - 1, n - 1);
        }

        int insertCost = minEditDistanceRecurrsion(strChar1, strChar2, m, n - 1);
        int removeCost = minEditDistanceRecurrsion(strChar1, strChar2, m - 1, n);
        int replaceCost = minEditDistanceRecurrsion(strChar1, strChar2, m - 1, n - 1);

        return 1 + min(insertCost, removeCost, replaceCost);

    }

    private int minEditDistanceDP(char[] strChar1, char[] strChar2, int m, int n) {

        //keep cost ..reuse
        int[][] C = new int[m + 1][n + 1];

        //put in starting max cost for each
        for (int i = 0; i < m + 1; i++) {
            C[i][0] = i;
        }

        //put in starting  cost = 0 first row
        for (int j = 0; j < n + 1; j++) {
            C[0][j] = j;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (strChar1[i - 1] == strChar2[j - 1]) {
                    C[i][j] = C[i - 1][j - 1];

                } else {
                    C[i][j] = 1 + this.min(C[i - 1][j], C[i][j - 1], C[i - 1][j - 1]);
                }
            }
        }

        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                System.out.print(C[i][j] + "\t\t ");
            }
            System.out.println("");
        }

        return C[m][n];

    }

    private int min(int x, int y, int z) {
        if (x < y && x < y) {
            return x;
        }

        if (y < x && y < z) {
            return y;
        }
        return z;

    }
}
