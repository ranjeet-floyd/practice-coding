package future.fry.practice.random;

import java.util.Arrays;

/**
 *
 * @author ranjeet
 */
public class MedianOfMatrix {

    /*
    Find median in row wise sorted matrix
     */

 /*
    We are given a row wise sorted matrix of size r*c, 
    we need to find the median of the matrix given.
    It is assumed that r*c is always odd.
     */
    public static void main(String[] args) {
        int m[][] = {{1, 3, 5}, {2, 6, 9}, {3, 6, 9}};

        System.out.println("Median is : " + new MedianOfMatrix().medianOfMatrix(m, 3, 3));
        
    }

    //first get the max and min element in sorted row
    private int medianOfMatrix(int[][] m, int r, int c) {

        int min = getMin(m, c);
        int max = getMax(m, c, r);

        int desiredMid = (r * c - 1) / 2;

        while (min < max) {
            int mid = min + (max - min) / 2;
            int place = 0;
            int get = 0;
            for (int i = 0; i < r; i++) {

                get = Arrays.binarySearch(m[i], mid);

                if (get < 0) {
                    get = Math.abs(get) - 1;
                } else {
                    get = get + 1;
                }

                place = place + get;
            }
                if (place < desiredMid) {
                    min = mid + 1;
                } else {
                    //update upper bound.
                    max = mid;
                }


        }

        return min;



    }

    //min must be present in first column 
    private int getMin(int[][] m, int c) {
        int min = m[0][0];

        for (int i = 1; i < c; i++) {

            if (min > m[0][i]) {
                min = m[0][i];
            }

        }
        return min;
    }

    //max must be present in last column
    private int getMax(int[][] m, int c, int r) {
        int max = m[r - 1][0];
        for (int i = 1; i < c; i++) {
            if (max < m[r - 1][i]) {
                max = m[r - 1][i];
            }
        }
        return max;
    }

}
