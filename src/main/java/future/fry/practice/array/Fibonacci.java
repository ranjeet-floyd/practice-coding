package future.fry.practice.array;

/**
 *
 * @author ranjeet
 */
public class Fibonacci {

    public static void main(String[] args) {
        
        System.out.println(fib(9));
        System.out.println(fibRec(9));

    }

    private static int fib(int n) {

        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];

    }

    private static int fibRec(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibRec(n - 1) + fibRec(n - 2);

    }

}
