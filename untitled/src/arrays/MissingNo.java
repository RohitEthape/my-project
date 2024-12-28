package arrays;

public class MissingNo {

    public int findMissingNo(int []arr){
      int flag = 0;

      for(int i = 1;i< arr.length;i++){
          for(int j = 0;j<arr.length-1;j++){
            if(arr[j] == i){
                flag =1;
            }
          }
          if (flag==1){
              return i;
          }
          }
        return -1;
      }

// better approach

        public int findMissingNo1(int[] arr) {   //formula = sum = n * (n+1)/2
            int n = arr.length + 1; // n is the length of the array plus 1, because 1 number is missing

            // Calculate the sum of numbers from 1 to n (inclusive)
            int totalSum = n * (n + 1) / 2;

            // Calculate the sum of elements in the array
            int arraySum = 0;
            for (int i = 0; i < arr.length; i++) {
                arraySum += arr[i];
            }

            // The missing number is the difference between the total sum and the array sum
            return totalSum - arraySum;
        }

    public int findMissingNo2(int[] arr) {    //  optimal solution
        int xor1=0,xor2=0;
        int n = arr.length-1;
        for (int i = 0;i<n;i++){
            xor2=xor2^ arr[i];
            xor1= xor1^ arr[i+1];
        }
        xor1 = xor2^arr.length;
        return xor1^xor2;
    }

       /* public static void main(String[] args) {
            MissingNumber obj = new MissingNumber();

            int[] arr = {1, 2, 4, 5}; // Example array where 3 is missing

            // Find the missing number
            int missing = obj.findMissingNo(arr);

            // Print the result
            System.out.println("The missing number is: " + missing);  // Output: 3
        }*/
    }





