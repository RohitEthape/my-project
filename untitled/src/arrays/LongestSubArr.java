package arrays;

import java.util.*;

public class LongestSubArr {

    public int countOfLongestSubArray(int []arr, int L){     // O(n^2)      O(1)

        int maxLength  = 0;
        for (int i = 0;i<arr.length;i++){
            for (int j = i;j<arr.length;j++){
                int sum = 0;
                for(int k = i;k<j;k++){
                    sum = arr[k];
                    if( sum == L){
                        maxLength = Math.max(maxLength, j - i + 1);
                    }
                }
            }
        }
        return maxLength;
    }

    public int countOfLongestSubArray1(int []arr, int L){  // optimal solution for negative array
        Map<Long, Integer> premap = new HashMap<>();  // Initialize the map
        long sum = 0;
        int maxLength = 0;

        // Initialize the map with the base case (sum 0 at index -1)
        premap.put(0L, -1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // If the sum equals L, update maxLength
            if (sum == L) {
                maxLength = Math.max(maxLength, i + 1);
            }

            long rem = sum - L;

            // Check if the remainder sum has been seen before
            if (premap.containsKey(rem)) {  // Corrected usage of containsKey
                // Calculate the length of the subarray
                int length = i - premap.get(rem);
                maxLength = Math.max(maxLength, length);
            }

            // Store the Prefix Sum if it hasn't been seen before
            if (!premap.containsKey(sum)) {
                premap.put(sum, i);
            }
        }

        return maxLength;
    }

    public static int getLongestSubarray(int []a, long k) { // Optimal approach for positive array    TC - O(2n)   SC - O(1)
        int n = a.length; // size of the array.
        int left = 0, right = 0; // 2 pointers
        long sum = a[0];
        int maxLen = 0;
        while (right < n) {
            // if sum > k, reduce the subarray from left
            // until sum becomes less or equal to k:
            while (left <= right && sum > k) {
                sum -= a[left];
                left++;
            }
            // if sum = k, update the maxLen i.e. answer:
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            // Move forward thw right pointer:
            right++;
            if (right < n) sum += a[right];
        }
        return maxLen;
    }
    }
