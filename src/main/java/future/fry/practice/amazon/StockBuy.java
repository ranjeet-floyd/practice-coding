package future.fry.practice.amazon;

/**
 *
 * @author ranjeet
 */
public class StockBuy {

    /*
     Stock buy and sell with max k transactions | do max  profit.
     */
    public static void main(String[] args) {
        StockBuy stockBuy = new StockBuy();
        //stock price any given day.
        int[] stockPrices = {2, 5, 7, 1, 4, 3, 1, 3};
        int maxTransactions = 3;
        int maxProfit = stockBuy.getMaxProfit(stockPrices, maxTransactions);
        System.out.println("Max Profit :" + maxProfit);

    }

    private int getMaxProfit(int[] stockPrices, int maxTrans) {
        int[][] T = new int[maxTrans + 1][stockPrices.length];
//        for (int i = 0; i < maxTrans + 1; i++) {
//            T[i][0] = 0; // single stock ... buy sell makes no profit
//        }
//
//        for (int i = 0; i < stockPrices.length; i++) {
//            T[0][i] = 0; // no transaction ..no profit.
//        }

        for (int i = 1; i < maxTrans + 1; i++) {
            for (int j = 1; j < stockPrices.length; j++) {
                int maxProfit = T[i][j - 1]; // with no transaction ..privous profit
                //with transaction ... sold on jth and buy on kth days
                for (int k = 0; k <= j - 1; k++) {
                    int total = (stockPrices[j] - stockPrices[k]) // did transaction
                            + T[i - 1][k]; //before transaction
                    if (maxProfit < total) {
                        maxProfit = total;
                    }
                }

                T[i][j] = maxProfit;

            }
        }

        return T[maxTrans][stockPrices.length - 1];
    }

}
