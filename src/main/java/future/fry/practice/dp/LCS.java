package future.fry.practice.dp;

/**
 *
 * @author ranjeet
 */
public class LCS {

    /*
    LCS Problem Statement: Given two sequences, find the length of longest subsequence present 
    in both of them. A subsequence is a sequence that appears in the same relative order, 
    but not necessarily contiguous. For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, ..
    etc are subsequences of “abcdefg”. 
    So a string of length n has 2^n different possible subsequences.
     */
    public static void main(String[] args) {

        /*
        Examples:
LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
         */
        LCS lcs = new LCS();
        String str1 = "ABCDGH";
        String str2 = "AEDFHR";
        StringBuilder longestLCS = new StringBuilder();
        System.out.println("LCS of " + str1 + " and " + str2 + " is:" + lcs.getLongestLCSRecursive(str1.toCharArray(), str2.toCharArray(), 0, 0, longestLCS));
        System.out.println("LCS of " + str1 + " and " + str2 + " is:" + lcs.getLongestLCSDP(str1.toCharArray(), str2.toCharArray()));
    }

    private int getLongestLCSRecursive(char[] strChar1, char[] strChar2, int index1, int index2, StringBuilder lcs) {

        //base condition
        if (index1 >= strChar1.length || index2 >= strChar2.length) {
            return 0;
        }

        if (strChar1[index1] == strChar2[index2]) {
            lcs.append(strChar1[index1]);
            return 1 + getLongestLCSRecursive(strChar1, strChar2, index1 + 1, index2 + 1, lcs);
        }

        return Math.max(getLongestLCSRecursive(strChar1, strChar2, index1 + 1, index2, lcs),
                getLongestLCSRecursive(strChar1, strChar2, index1, index2 + 1, lcs));

    }

    /*
    In above method we are calculating same function multiple times... use table memorization.
     */
    private int getLongestLCSDP(char[] strChar1, char[] strChar2) {
        int[][] L = new int[strChar1.length + 1][strChar2.length + 1]; //matrix to rememer calulated func
        for (int i = 1; i <= strChar1.length; i++) {
            for (int j = 1; j <= strChar2.length; j++) {
                if (strChar1[i - 1] == strChar2[j - 1]) {
                    L[i][j] = 1 + L[i - 1][j - 1];
                    System.out.print(strChar1[i - 1]);
                } else {
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
                }

            }
        }
        System.out.println("");
        return L[strChar1.length][strChar2.length];

    }

}
