/*
Given a string and a pattern, find all anagrams of the pattern in the given string.

Anagram is actually a Permutation of a string. For example, “abc” has the following six anagrams:

abc
acb
bac
bca
cab
cba
Write a function to return a list of starting indices of the anagrams of the pattern in the given string.

Input: String="ppqp", Pattern="pq"
Output: [1, 2]
Explanation: The two anagrams of the pattern in the given string are "pq" and "qp".


Input: String="abbcabc", Pattern="abc"
Output: [2, 3, 4]
Explanation: The three anagrams of the pattern in the given string are "bca", "cab", and "abc".

*/


import java.util.*;

class StringAnagrams{
    public static List<Integer> findStringAnagrams(String str, String pattern) {
        int left = 0;
        int matched = 0;
        
        Map<Character, Integer> freqMap = new HashMap<>();

        for(char c : pattern.toCharArray()){
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        for(int right = 0; right < str.length(); right++){
            char rightChar = str.charAt(right);

            if(freqMap.containsKey(rightChar)){
                freqMap.put(rightChar, freqMap.get(rightChar) - 1);
                if(freqMap.get(rightChar) == 0){
                    matched++;
                }
            }
            if(matched == freqMap.size()){
                result.add(left);
            }
            
            if (right >= pattern.length() - 1) { // shrink the window
            char leftChar = str.charAt(left);
            if (freqMap.containsKey(leftChar)) {
                if (freqMap.get(leftChar) == 0)
                    matched--; // before putting the character back, decrement the matched count
                    // put the character back
                    freqMap.put(leftChar, freqMap.get(leftChar) + 1);
                }
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(StringAnagrams.findStringAnagrams("ppqp", "pq"));
        System.out.println(StringAnagrams.findStringAnagrams("abbcabc", "abc"));
    }
}