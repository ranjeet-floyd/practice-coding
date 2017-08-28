package future.fry.practice.dp;

/**
 *
 * @author ranjeet
 */
public class MinimumCoinChanging {

    /*
    Find minimum number of coins that make a given value
     */
    public static void main(String[] args) {
        /*
        Given set of coins of unlimited quantity and a total. 
        How many minimum coins would it take to form this total.
         */
        int total = 13;
        int[] coins = {7, 2, 3, 6};
        MinimumCoinChanging mcc = new MinimumCoinChanging();
        System.out.println("Minimum coin required :" + mcc.minCoinChange(coins, total));
        System.out.println("Minimum coin required (bottom Up) :" + mcc.minCoinBottomUp(coins, total));
    }

    private int minCoinChange(int[] coins, int totalVal) {
        if (totalVal == 0) {
            return 0;
        }
        int minCoin = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= totalVal) {
                int sum_minCoin = minCoinChange(coins, totalVal - coins[i]);
                if (sum_minCoin != Integer.MAX_VALUE && sum_minCoin + 1 < minCoin) {
                    minCoin = sum_minCoin + 1;
                }

            }
        }

        return minCoin;

    }

    private int minCoinBottomUp(int[] coins, int total) {
        int[] T = new int[total + 1];
        int[] R = new int[total + 1];

        T[0] = 0;
        //fill T with max Int and R with -1 (means not included)
        for (int i = 1; i < total + 1; i++) {
            T[i] = Integer.MAX_VALUE;
            R[i] = -1;
        }
        
        for (int i = 1; i < total + 1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i && T[i - coins[j]] != Integer.MAX_VALUE) {
                    if (T[i] > 1 + T[i - coins[j]]) {
                        R[i] = j;
                        T[i] = 1 + T[i - coins[j]];
                    }

                }
                
            }
            
        }
        printCoins(R, total, coins);
        System.out.println("");
        return T[total];

    }

    private void printCoins(int[] R, int total, int[] coins) {
        if (total <= 0) {
            return;
        }

        if (R[total] != -1) {
            System.out.print("Picked Coin: " + coins[R[total]] + "  ");
        }
        printCoins(R, total - coins[R[total]], coins);
    }
}
