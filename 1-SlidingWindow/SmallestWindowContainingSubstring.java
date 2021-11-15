import java.util.*;

class SmallestWindowContainingSubstring{

    public static String findSubstring(String str, String pattern){
        int left = 0;
        int matched = 0;
        int minLen = str.length() + 1;
        int subStrStart = 0;

        Map<Character, Integer> freqMap = new HashMap<>();

        for(char c : pattern.toCharArray()){
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        
        for(int right = 0; right < str.length(); right++){
            char rightChar  = str.charAt(right);

            if(freqMap.containsKey(rightChar)){
                freqMap.put(rightChar, freqMap.get(rightChar) - 1);
                if(freqMap.get(rightChar) >= 0){
                    matched++;
                }
            }
            while(matched == pattern.length()){
                if(minLen > right - left + 1){
                    minLen = right - left + 1;
                    subStrStart = left;
                }
            }

            char charLeft = str.charAt(left);
            if(freqMap.containsKey(charLeft)){
                if(freqMap.get(charLeft) == 0){
                    matched--;
                }
                freqMap.put(charLeft, freqMap.get(charLeft) + 1);
            }
            left++;

        }
        return minLen > str.length() ? "" : str.substring(subStrStart, subStrStart + minLen);

    }
    public static void main(String[] args) {
        System.out.println(SmallestWindowContainingSubstring.findSubstring("aabdec", "abc"));
        System.out.println(SmallestWindowContainingSubstring.findSubstring("abdbca", "abc"));
        System.out.println(SmallestWindowContainingSubstring.findSubstring("adcad", "abc"));
    }
}