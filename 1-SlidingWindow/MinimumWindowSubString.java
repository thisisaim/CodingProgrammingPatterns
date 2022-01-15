import java.util.*;

class MinimumWindowSubString {
    public static String findSubstring(String str, String pattern) {
        int left = 0;
        int matched = 0;
        int minLen = str.length() + 1;
        int subStrStart = 0;

        Map<Character, Integer> map = new HashMap<>();
        for(char c : pattern.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(int right = 0; right < str.length(); right++) {
            char rightChar = str.charAt(right);
            if(map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar) - 1);
                if(map.get(rightChar) >= 0) {
                    matched++;
                }
            }
            while(matched == pattern.length()) {
                if(minLen > right - left + 1) {
                    minLen = right - left + 1;
                    subStrStart = left;
                }
                char leftChar = str.charAt(left);
                if(map.containsKey(leftChar)) {
                    if(map.get(leftChar) == 0) {
                        matched--;
                    }
                    map.put(leftChar, map.get(leftChar) + 1);
                }
                left++;
            }
            char leftChar = str.charAt(left);
            if(map.containsKey(leftChar)) {
                if(map.get(leftChar) == 0) {
                    matched--;
                }
                map.put(leftChar, map.get(leftChar) + 1);
            }
        }
        return minLen > str.length() ? "" : str.substring(subStrStart, subStrStart + minLen);
    }    
    public static void main(String[] args) {
        System.out.println(MinimumWindowSubString.findSubstring("aabdec", "abc"));
        System.out.println(MinimumWindowSubString.findSubstring("abdbca", "abc"));
        System.out.println(MinimumWindowSubString.findSubstring("adcad", "abc"));
    }
}
