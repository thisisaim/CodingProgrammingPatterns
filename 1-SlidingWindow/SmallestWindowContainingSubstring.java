import java.util.*;

class SmallestWindowContainingSubstring{

    public static String FindSubString(String str, String pattern){
        int windowStart = 0;
        int matched = 0;
        int minLength = str.length() + 1;
        int subStrStart = 0;

        Map<Character, Integer> freqMap = new HashMap<>();

        for(char c : pattern.toCharArray()){
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        
        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char rightChar  = str.charAt(windowEnd);

            if(freqMap.containsKey(rightChar)){
                freqMap.put(rightChar, freqMap.get(rightChar) - 1)
                if(freqMap.get(rightChar) >= 0){
                    matched++;
                }
            }
            while(matched == pattern.length()){
                if(minLength > windowEnd - windowStart + 1){
                    minLength = windowEnd - windowStart + 1;
                    subStrStart = windowStart;
                }
            }

            char charLeft = str.charAt(windowStart++);
            if(freqMap.containsKey(charLeft)){
                if(freqMap.get(leftChar) == 0){
                    matched--;
                }
                freqMap.put(leftChar, freqMap.get(leftChar) + 1);
            }
        }
        return minLength > str.length() ? "" : str.substring(subStrStart, subStrStart + minLength);

    }
    public static void main(String[] args) {
        System.out.println(MinimumWindowSubstring.findSubstring("aabdec", "abc"));
        System.out.println(MinimumWindowSubstring.findSubstring("abdbca", "abc"));
        System.out.println(MinimumWindowSubstring.findSubstring("adcad", "abc"));
    }
}