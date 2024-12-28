package arrays;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class RemoveDuplicates {

  /*  public int[]  removeDuplicate(int [] n){    // brute sulution
                Set<Integer> set = new HashSet<>();
                for (int num : n) {
                    set.add(num);
                }

        int[] resultArray = new int[set.size()];

        for (int num : set) {
            resultArray[i++] = num;
        }

        return resultArray;

            }
*/
    public int[] removeDuplicate1(int[] n) {
        if (n == null || n.length == 0) {
            return new int[0];
        }

        int i = 0;
        for (int j = 1; j < n.length; j++) {   //

            if (n[i] != n[j]) {
                i++;
                n[i] = n[j];
            }
        }


        int[] resultArray = new int[i + 1];
        System.arraycopy(n, 0, resultArray, 0, i + 1);

        return resultArray;
    }
        }



