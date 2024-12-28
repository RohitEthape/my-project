package arrays;

public class KadanesAlgo {
// maximum subarray
   // Problem Statement: Given an integer array arr, find the contiguous subarray (containing at least one number) which
  //  has the largest sum and returns its sum and prints the subarray.
    public int maximumSum(int [] arr){
        // -2,1,-3,4,-1,2,1,-5,4
        int n = arr.length;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){

             sum += arr[i];
            if(sum > max)  max = sum;
            if(sum < 0) sum = 0;


        }
        return  max;
    }

    /*
    same solution
    class Solution {
    public int maxSubArray(int[] arr) {
        int n = arr.length;
        int maxi = Integer.MIN_VALUE; // maximum sum
        int sum = 0;

        for (int i = 0; i < n; i++) {

            sum += arr[i];

            if (sum > maxi) {
                maxi = sum;
            }

            // If sum < 0: discard the sum calculated
            if (sum < 0) {
                sum = 0;
            }
        }

        // To consider the sum of the empty subarray
        // uncomment the following check:

        //if (maxi < 0) maxi = 0;

        return maxi;
    }
}

     */

    public int[] maxSubSumArray1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[] {}; // Return an empty array if the input is empty
        }

        int max = Integer.MIN_VALUE; // To track the maximum sum found
        int sum = 0;
        int start = 0, end = 0; // Indices for the subarray

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i]; // Add current element to sum

            if (sum > max) {
                max = sum; // Update max if the current sum is greater
                end = i; // Update the end index of the subarray
            }

            if (sum < 0) {
                sum = 0; // If sum becomes negative, reset it and start new subarray
                start = i + 1; // New potential start of the subarray
            }
        }

        // Now extract the subarray from arr
        int[] result = new int[end - start + 1];
        System.arraycopy(arr, start, result, 0, result.length); // Copy the subarray into result

        return result; // Return the subarray with maximum sum
    }


}
