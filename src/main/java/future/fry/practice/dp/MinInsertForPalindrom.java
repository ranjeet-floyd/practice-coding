package future.fry.practice.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ranjeet
 */
public class MinInsertForPalindrom {

    /*
    Min Insert require to convert string to palindrom
     */
    public static void main(String[] args) throws IllegalAccessException {

        //ab - 1
        //aa - 0 
        //abc - 2
        // abcd - 3
        char[] chars = {'a', 'b', 'c'};
        List<Character> insertedChars = new ArrayList<>();

        MinInsertForPalindrom palindrom = new MinInsertForPalindrom();
        palindrom.minCharForPalindrom(chars, 0, chars.length - 1, insertedChars);

        insertedChars.forEach(System.out::print);
        System.out.println("String :" + Arrays.toString(chars) + " : "
                + +palindrom.findMinInsertion(chars, 0, chars.length - 1));
    }

    private int minCharForPalindrom(char[] chars, int from, int to, List<Character> insertedChars) {

        if (from >= to) {
            return 0;
        }

        if (to - from == 1) {
            if (chars[from] != chars[to]) {
                insertedChars.add(chars[to]);
                return 1;
            }
        }

        //same character
        if (chars[from] == chars[to]) {
            return minCharForPalindrom(chars, from + 1, to - 1, insertedChars);
        } else {

            int left = minCharForPalindrom(chars, from, to - 1, insertedChars);
            int right = minCharForPalindrom(chars, from + 1, to, insertedChars);
            return Math.max(left, right) + 1;
        }

    }

    private int findMinInsertion(char[] chars, int i, int t) throws IllegalAccessException {

        if (i > t) {
            throw new IllegalAccessException("from index  is greater than to index");
        }

        if (i == t) {
            return 0;
        }

        if (i == t - 1) {
            return 1;
        }

        if (chars[i] == chars[t]) {
            return findMinInsertion(chars, i + 1, t - 1);
        } else {
            int left = findMinInsertion(chars, i, t - 1);
            int right = findMinInsertion(chars, i + 1, t);

            return Math.min(left, right) + 1;

        }

    }
}
