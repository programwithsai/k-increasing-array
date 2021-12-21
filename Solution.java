import java.util.*;

public class Solution {
    public int kIncreasing(int[] arr, int k) {
    	// Store the sums of lenghts of all non descending sub arrays formed out of arr
        int total = 0;
        
        for (int i = 0; i < k; i++) {
        	// non descending sub array
            List<Integer> ndsa = new ArrayList<>();
            for (int j = i; j < arr.length; j += k) {
                if (ndsa.isEmpty() || ndsa.get(ndsa.size() - 1) <= arr[j]) {
                    ndsa.add(arr[j]);
                } else {
                    int index = findIndexForValue(ndsa, arr[j]);
                    ndsa.set(index, arr[j]);
                }
            }
            total += ndsa.size();
        }
        return arr.length - total;   
    }
    
    // Use customised binary search to find the index to store value in the list
    private int findIndexForValue(List<Integer> list, int value) {
        int low = 0, high = list.size() - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (value >= list.get(mid)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}









