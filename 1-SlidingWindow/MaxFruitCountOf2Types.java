import java.util.*;

class MaxFruitCountOf2Types{
    public static int findLength(char[] arr) {
        int left = 0;
        int maxLen = 0;

        Map<Character, Integer> freqMap = new HashMap<>();

        for(int right = 0; right < arr.length; right++) {
            freqMap.put(arr[right], freqMap.getOrDefault(arr[right], 0) + 1);
            
            while(freqMap.size() > 2) {
                freqMap.put(arr[left], freqMap.getOrDefault(arr[left], 0) - 1);
                if(freqMap.get(arr[left]) == 0) {
                    freqMap.remove(arr[left]);
                }
                left++;
            }
        maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println("Maximum number of fruits: " + 
        MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
        System.out.println("Maximum number of fruits: " + 
        MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
    }
}