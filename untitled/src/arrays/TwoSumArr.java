package arrays;

import java.util.ArrayList;
import java.util.HashMap;

public class TwoSumArr {

    public ArrayList<Integer> SumOfTwoNum(Integer arr[] , Integer k){   // TC  O(N*N)

        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0;i < arr.length;i++){

            for(int j=i+1;j<arr.length;j++){
                if (arr[i]+arr[j] == k){
                  result.add(i);
                  result.add(j);
                }

            }
        }
        return result;
    }

    public ArrayList<Integer> SumOfTwoNum1(Integer arr[] , Integer k){      // O(N*N)    Its differ as ordered or unordered map
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0;i< arr.length;i++){
            int a = arr[i];
            int sum = a - k;
           if(map.containsValue(sum)){
                result.add(map.get(sum));
                result.add(arr[i]);
           }
           else {
               map.put(a,i);
           }
        }
        return result;
    }

    public Boolean SumOfTwoNum2(Integer arr[] , Integer k){    // TC O(N) + O log N       SC O(1)
        int left = 0 ;
        int right = arr.length - 1;
        while (left < right){
            int sum = arr[left] + arr[right];
            if(sum == k){
                return true;
            } else if (sum < k) {
                left++;
            }
            else {
                right--;
            }
        }
       return false;
    }




    public static void sortArray(ArrayList<Integer> arr, int n) {

            /*
            Algorithm / Intuition
This problem is a variation of the popular Dutch National flag algorithm.

This algorithm contains 3 pointers i.e. low, mid, and high, and 3 main rules.
  The rules are the following:

arr[0….low-1] contains 0. [Extreme left part]
arr[low….mid-1] contains 1.
arr[high+1….n-1] contains 2. [Extreme right part], n = size of the array
The middle part i.e. arr[mid….high] is the unsorted segment. So,
hypothetically the array with different markers will look like the following:


In our case, we can assume that the entire given array is unsorted and so we will place the
 pointers accordingly. For example, if the given array is: [2,0,2,1,1,0], the array with the
  3 pointers will look like the following:


Here, as the entire array is unsorted, we have placed the mid pointer in the first index and
the high pointer in the last index. The low is also pointing to the first index as we have no other
index before 0. Here, we are mostly interested in placing the ‘mid’ pointer and the ‘high’ pointer
as they represent the unsorted part in the hypothetical array.

Now, let’s understand how the pointers will work to make the array sorted.

Approach:

Note: Here in this tutorial we will work based on the value of the mid pointer.

The steps will be the following:

First, we will run a loop that will continue until mid <= high.
There can be three different values of mid pointer i.e. arr[mid]
If arr[mid] == 0, we will swap arr[low] and arr[mid] and will increment both low and mid. Now the subarray from index 0 to (low-1) only contains 0.
If arr[mid] == 1, we will just increment the mid pointer and then the index (mid-1) will point to 1 as it should according to the rules.
If arr[mid] == 2, we will swap arr[mid] and arr[high] and will decrement high. Now the subarray from index high+1 to (n-1) only contains 2.
In this step, we will do nothing to the mid-pointer as even after swapping, the subarray from mid to high(after decrementing high) might be unsorted. So, we will check the value of mid again in the next iteration.
Finally, our array should be sorted.
Dry Run:

Assume the given array is [2,0,2,1,1,0]. The algorithm will be the following:




In each iteration, if we check, the rules are always valid. This is how the algorithm works.
             */


        int low = 0, mid = 0, high = n - 1; // 3 pointers
        while (mid <= high) {
            if (arr.get(mid) == 0) {
                // swapping arr[low] and arr[mid]
                int temp = arr.get(low);      // temp = low
                arr.set(low, arr.get(mid));   // low = mid
                arr.set(mid, temp);            //  mid = temp
                low++;
                mid++;
            } else if (arr.get(mid) == 1) {
                mid++;
            } else {
                // swapping arr[mid] and arr[high]
                int temp = arr.get(mid);        // temp = mid
                arr.set(mid, arr.get(high));    // mid = high
                arr.set(high, temp);            //  high = temp
                high--;
            }
        }
    }
/*
        public static void main(String args[]) {
            int n = 6;
            ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(new Integer[] {0, 2, 1, 2, 0, 1}));
            sortArray(arr, n);
            System.out.println("After sorting:");
            for (int i = 0; i < n; i++) {
                System.out.print(arr.get(i) + " ");
            }
            System.out.println();

        }
*/

}
