import java.util.HashMap;

public class LongSubstring {
// s = 'absansabbbas';
    public Integer longestSubstring(String value){

        HashMap<Character,Integer> charIndex = new HashMap<>();

        Integer maxString = 0;
        Integer left = 0;

        for(int right = 0; right < value.length(); right++){
        char currentChar = value.charAt(right);
            if(charIndex.containsKey(currentChar)){
                left = Math.max(left, charIndex.get(currentChar)+1);

            }
            charIndex.put(currentChar,right);
            maxString = Math.max(maxString, right - left +1);

        }

return maxString;
    }

}
