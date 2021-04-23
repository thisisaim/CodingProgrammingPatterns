class LongestSubStringKDistinct{
    public static int findLength(String str, int k) {
        if(str.length() == 0 || str == null || str.length() < k){
            return -1;
        }
        int windowStart = 0;
        int maxLength = 0;

        Map<Integer, Integer> freqMap = new HashMap<>();

        for(windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char rightChar = str.charAt(windowEnd);
            freqMap.put(rightChar, freq.getOrDefault(rightChar, 0) + 1);

            while(freqMap.size() > k){
                char leftChar = str.charAt(windowStart);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);
                if(freqMap.get(leftChar) == 0){
                    freqMap.remove(leftChar);
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        // return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
    }
}