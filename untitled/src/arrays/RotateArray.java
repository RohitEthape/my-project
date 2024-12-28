package arrays;

import static java.util.Collections.reverse;

public class RotateArray {
    public int[] rotateArray(int[] arr, int n, int d) {    // brute approach
        // If d is greater than or equal to n, reduce d to a smaller equivalent value
        d = d % n;  // To handle cases where d is larger than n

        // Temporary array to store the first d elements
        int[] temp = new int[d];

        // Step 1: Store the first d elements in the temp array
        for (int i = 0; i < d; i++) {
            temp[i] = arr[i];
        }

        // Step 2: Shift the remaining elements to the left
        for (int i = d; i < n; i++) {
            arr[i - d] = arr[i];
        }

        // Step 3: Copy the elements from the temp array to the end of the original array
        for (int i = 0; i < d; i++) {
            arr[n - d + i] = temp[i];
        }

        return arr; // Return the rotated array
    }

    public int[] rotateArray1(int[] arr, int n, int d) {
        d = d % n;
       // reverse(arr,arr+d);
      //  reverse(arr+d,arr+n);
     //   reverse(arr,arr+n);

        reverse(arr, 0, d - 1);

        // Step 2: Reverse the remaining elements (from d to n-1)
        reverse(arr, d, n - 1);

        // Step 3: Reverse the entire array (from 0 to n-1)
        reverse(arr, 0, n - 1);
        return arr;
    }

    public void reverse(int[] arr, int start, int end) {
        while (start < end) {
            // Swap elements at start and end
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    }
