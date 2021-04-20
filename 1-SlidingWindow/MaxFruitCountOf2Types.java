import java.util.*;

class MaxFruitCountOf2Types{
    public static int findLength(char[] arr) {
        int windowStart = 0;
        int maxLength = 0;

        Map<Character, Integer> freqMap = new HashMap<>();
        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
            freqMap.put(arr[windowEnd], freqMap.getOrDefault(arr[windowEnd], 0) + 1);

            while(freqMap.size < 2){
                freqMap.put(arr[windowStart], freqMap.get(arr[windowStart]) - 1);
                if(freqMap.get(arr[windowStart]) == 0){
                    freqMap.remove(arr[windowStart]);
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Maximum number of fruits: " + 
                              MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
        System.out.println("Maximum number of fruits: " + 
                              MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
    }
}