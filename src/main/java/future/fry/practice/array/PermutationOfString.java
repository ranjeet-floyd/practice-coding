package future.fry.practice.array;

/**
 *
 * @author ranjeet
 */
public class PermutationOfString {

    public static void main(String[] args) {
        
        String str = "ABC";
        permute(str, 0, 2);

    }

    private static void permute(String str, int l, int h) {
        if (l == h) {
            System.out.println(str);
        }

        for (int i = l; i <= h; i++) {
            str = swap(str, i, l);
            permute(str, l + 1, h);
            str = swap(str, i, l);
        }

    }

    private static String swap(String str, int i, int j) {
        char[] chars = str.toCharArray();
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
        return String.valueOf(chars);

    }

}
