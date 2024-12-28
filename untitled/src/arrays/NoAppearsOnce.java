package arrays;
import java.util.*;
public class NoAppearsOnce {

    public int numberappearsOnce(int []arr){  //brute approach

        for(int i = 0 ; i<arr.length;i++){    // O(n)
            int num = arr[i];
            int count = 0;
            for(int j = 0;j<arr.length;j++){ // O(n)     == O(n^2)
                if(arr[j]== num){
                    count++;                    // space complexity    O(1)
                }
            }
            if(count==1){
                return num;
            }
        }
        return 0;
    }

    public int numberappearsOnce1(int[] arr) {
        // Step 1: Find the maximum value in the array to determine the size of the hash array
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {     //  O(n)  TC
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        // Step 2: Create a hash array (frequency array) to count occurrences
        int[] hasharray = new int[max + 1]; // Hash array size is max+1 because we're considering values from 0 to max
        // Step 3: Count the occurrences of each number in the input array
        for (int i = 0; i < arr.length; i++) {       //  O(n) TC      SC = O(input)
            hasharray[arr[i]]++;
        }
        // Step 4: Find the number that appears only once (has count == 1)
        for (int i = 0; i < hasharray.length; i++) {     //  O(n)  TC
            if (hasharray[i] == 1) {
                return i; // Return the element that appears once
            }
        }
        // If no such element is found, return 0 (optional, depending on the problem context)
        return 0;

        // in this solution if array have bigger data like 10^6 or 10^9  then we cannot hash it .
    }

    public int numberappearsOnce2(int[] arr) {
        // Step 1: Create a map to count occurrences of each element
        Map<Integer, Integer> map = new HashMap<>();

        // Step 2: Count the occurrences of each number in the input array
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1); // TC for ordered map it will be (N Log M) and for unordered O(n)
        }

        // Step 3: Find the number that appears only once (has count == 1)
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey(); // Return the element that appears once
            }
        }

        // If no such element is found, return 0 (optional, depending on the problem context)
        return 0;
    }

    public int numberappearsOnce3(int[] arr) {   // optimal approach

        int xor=0;
        for(int i =0;i<arr.length;i++){
            xor = xor^arr[i];
        }
        return xor;
    }


}
