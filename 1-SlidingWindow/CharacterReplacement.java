import java.util.*;

class CharacterReplacement{
    public static int findLength(String str, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();

        int windowStart = 0;
        int maxLength = 0;
        int maxRepeatLetterCount = 0;

        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char rightChar = str.charAt(windowEnd);
            freqMap.put(rightChar, freqMap.getOrDefault(rightChar, 0) + 1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, freqMap.get(rightChar));
            
            if(windowEnd - windowStart + 1 - maxRepeatLetterCount > k){
                char leftChar = str.charAt(windowStart);
                freqMap.put(leftChar, freqMap.getOrDefault(leftChar, 0) - 1);
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(CharacterReplacement.findLength("aabccbb", 2));
        System.out.println(CharacterReplacement.findLength("abbcb", 1));
        System.out.println(CharacterReplacement.findLength("abccde", 1));
    }
}