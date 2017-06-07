package future.fry.practice.dynamic;

import static java.lang.Integer.max;

/**
 * Given two strings, find longest common subsequence between them.
 *
 * @author ranjeet
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String str1 = "abcdaf";
        String str2 = "acbcf";
        System.out.println(lcsDynamic(str1, str2));
        System.out.println(lcsRecursive(str1.toCharArray(), str2.toCharArray(), str1.toCharArray().length,
                str2.toCharArray().length));
    }

    private static int lcsDynamic(String str1, String str2) {
        char[] str1Arr = str1.toCharArray();
        char[] str2Arr = str2.toCharArray();
        int[][] T = new int[str1Arr.length + 1][str2Arr.length + 1];
        for (int i = 1; i <= str1Arr.length; i++) {
            for (int j = 1; j <= str2Arr.length; j++) {
                if (str1Arr[i - 1] == str2Arr[j - 1]) {
                    T[i][j] = T[i - 1][j - 1] + 1;
//                    System.out.println(str1Arr[i - 1]);
                } else {
                    T[i][j] = max(T[i - 1][j], T[i][j - 1]);
                }

            }

        }
        return T[str1Arr.length][str2Arr.length];

    }

    private static int lcsRecursive(char[] str1Arr, char[] str2Arr, int len1, int len2) {
        if (len1 == 0 || len2 == 0) {
            return 0;
        }
        if (str1Arr[len1 - 1] == str2Arr[len2 - 1]) {
            return 1 + lcsRecursive(str1Arr, str2Arr, len1 - 1, len2 - 1);
        }
        return max(lcsRecursive(str1Arr, str2Arr, len1 - 1, len2),
                lcsRecursive(str1Arr, str2Arr, len1, len2 - 1));

    }
}
