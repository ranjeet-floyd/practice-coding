package future.fry.practice.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author ranjeet
 */
public class ZeroSumTriplet {

    /*
    Find all  unique triplets in array which gives the sum of zero.
    The solution set must not contain duplicate triplets.
     */
    public static void main(String[] args) {
        /*
        For example : arr = [-1,0,1,2,-1,-4]
        zero sum triplets : [-1,0,1], [-1,-1,2]
         */
        int[] arr = {-1, 0, 1, 2, -1, -4};
        ZeroSumTriplet zeroSumTriplet = new ZeroSumTriplet();
        List<List<Integer>> zeroSumTriples = zeroSumTriplet.zeroSumTriplet(arr);
        zeroSumTriples.forEach(triple -> {
            String tripleStr = triple.stream().map(i -> Integer.toString(i))
                    .collect(Collectors.joining(" "));
            System.out.println(tripleStr);
        });
        
    }
    
    private List<List<Integer>> zeroSumTriplet(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        
        for (int i = 0; i < arr.length - 2; i++) {

            //avoid duplicates
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            int target = -arr[i];
            int k = arr.length - 1;
            int j = i + 1;
            
            while (j < k) {
                
                if (arr[j] + arr[k] == target) {
                    
                    List<Integer> temp = new ArrayList<>();
                    temp.add(arr[i]);
                    temp.add(arr[j]);
                    temp.add(arr[k]);
                    result.add(temp);
                    j++;
                    k--;
                    //avoid duplicates
                    while (j < k && arr[j] == arr[j - 1]) {
                        j++;
                    }
                    //avoid duplicates
                    while (j < k && arr[k] == arr[k + 1]) {
                        k--;
                    }
                    //sum is larger than target 
                } else if (arr[j] + arr[k] > target) {
                    k--;
                } else {
                    //sum is smaller than target
                    j++;
                }
                
            }
        }
        
        return result;
        
    }
    
}
