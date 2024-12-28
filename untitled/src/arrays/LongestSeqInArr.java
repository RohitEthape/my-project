package arrays;
import java.util.HashSet;
public class LongestSeqInArr {
        public int longestConsecutive(int[] nums) {

            if (nums == null || nums.length == 0) return 0;

            HashSet<Integer> set = new HashSet<>();

            // Add all elements to the set
            for (int num : nums) {
                set.add(num);
            }

            int maxLength = 0;

            // Iterate through each number in the array
            for (int num : nums) {
                // Check if it's the start of a sequence
                if (!set.contains(num - 1)) {
                    int currentNum = num;
                    int currentLength = 1;

                    // Count the length of the consecutive sequence
                    while (set.contains(currentNum + 1)) {
                        currentNum++;
                        currentLength++;
                    }

                    // Update the maximum length
                    maxLength = Math.max(maxLength, currentLength);
                }
            }

            return maxLength;
        }


}
