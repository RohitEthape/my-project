package arrays;

public class PlaceZero {

    public int[] placeZerosAtLast(int []arr){  // brute approach

        int[] temp = new int[arr.length];

    for(int i = 0; i< arr.length;i++){
        if(arr[i]!=0){
            temp[i] = arr[i];
        }
    }

    for(int i = 0; i< temp.length;i++){
        arr[i] = temp[i];
    }

    for(int i = temp.length;i< arr.length; i++){
        arr[i] = 0;
    }
        return arr;
    }

    public int[] moveZerosToEnd(int[] arr) { // final approach
        int j = -1;  // Pointer to track the position of the last non-zero element

        for(int i = 0 ; i< arr.length;i++){
            if(arr[i] ==0){
                j=0;
                break;
            }
        }
        // Step 1: Move all non-zero elements to the front [ 1,1,0,0,0,6,7,0,9]
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                // Swap arr[i] with arr[lastNonZeroIndex]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                // Increment the lastNonZeroIndex
                j++;
            }
        }

        return arr;  // Return the modified array
    }

    }
