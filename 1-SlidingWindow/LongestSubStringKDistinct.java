import java.util.*;

class LongestSubStringKDistinct{
    public static int findLength(String str, int k) {
        if(str.length() == 0 || str == null) {
            return -1;
        }

        int left = 0;
        int maxLen = 0;

        Map<Character, Integer> freqMap = new HashMap<>();

        for(int right = 0; right < str.length(); right++) {
            char rightChar = str.charAt(right);
            freqMap.put(rightChar, freqMap.getOrDefault(rightChar, 0) + 1);

            while(freqMap.size() > k) {
                char leftChar = str.charAt(left);
                freqMap.put(leftChar, freqMap.getOrDefault(leftChar, 0) - 1);
                if(freqMap.get(leftChar) == 0) {
                    freqMap.remove(leftChar);
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubStringKDistinct.findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + LongestSubStringKDistinct.findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + LongestSubStringKDistinct.findLength("cbbebi", 3));
    }
}