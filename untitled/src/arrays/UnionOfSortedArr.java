package arrays;
import java.util.*;

public class UnionOfSortedArr {

    public ArrayList<Integer> sortedArray(int [] arr1, int [] arr2){

                int n = arr1.length;
                int m = arr2.length;
                int i = 0, j = 0; // pointers
                ArrayList<Integer > Union=new ArrayList<>(); // Uninon vector
                while (i < n && j < m) {
                    if (arr1[i] <= arr2[j]) // Case 1 and 2
                    {
                        if (Union.size() == 0 || Union.get(Union.size()-1) != arr1[i])
                            Union.add(arr1[i]);
                        i++;
                    } else // case 3
                    {
                        if (Union.size() == 0 || Union.get(Union.size()-1) != arr2[j])
                            Union.add(arr2[j]);
                        j++;
                    }
                }
                while (i < n) // IF any element left in arr1
                {
                    if (Union.get(Union.size()-1) != arr1[i])
                        Union.add(arr1[i]);
                    i++;
                }
                while (j < m) // If any elements left in arr2
                {
                    if (Union.get(Union.size()-1) != arr2[j])
                        Union.add(arr2[j]);
                    j++;
                }
                return Union;
            }
         /*   public static void main(String args[]) {
                int n = 10, m = 7;
                int arr1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
                int arr2[] = {2, 3, 4, 4, 5, 11, 12};
                ArrayList<Integer> Union = FindUnion(arr1, arr2, n, m);
                System.out.println("Union of arr1 and arr2 is ");
                for (int val: Union)
                    System.out.print(val+" ");
            }*/






        public static ArrayList<Integer> intersectionOfArrays(int[] A, int[] B){

            // Declare ans array.
            ArrayList<Integer> ans=new ArrayList<>();

            int i = 0, j = 0;

            // to traverse the arrays
            while (i < A.length && j < B.length) {

                //if current element in i is smaller
                if (A[i] < B[j]) {
                    i++;
                } else if (B[j] < A[i]) {
                    j++;
                } else {

                    //both elements are equal
                    ans.add(A[i]);
                    i++;
                    j++;
                }
            }
            return ans;
        }

      /*  public static void main(String args[])
        {
            // Array Initialisation.
            int A[]= {1,2,3,3,4,5,6,7};
            int B[]= {3,3,4,4,5,8};

            ArrayList<Integer> ans= intersectionOfArrays(A,B);

            for (int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(i)+" ");
            }

        }*/
    }









