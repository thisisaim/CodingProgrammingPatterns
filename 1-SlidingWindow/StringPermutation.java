import java.util.*;
/*
Permutation in a String (hard) #
Given a string and a pattern, find out if the string contains any permutation of the pattern.

Permutation is defined as the re-arranging of the characters of the string. For example, “abc” has the following six permutations:

abc
acb
bac
bca
cab
cba
If a string has ‘n’ distinct characters, it will have n!n! permutations.


Input: String="oidbcaf", Pattern="abc"
Output: true
Explanation: The string contains "bca" which is a permutation of the given pattern.


Input: String="odicf", Pattern="dc"
Output: false
Explanation: No permutation of the pattern is present in the given string as a substring.


Input: String="bcdxabcdy", Pattern="bcdyabcdx"
Output: true
Explanation: Both the string and the pattern are a permutation of each other.


Input: String="aaacb", Pattern="abc"
Output: true
Explanation: The string contains "acb" which is a permutation of the given pattern.
*/



class StringPermutation {
    public static boolean findPermutation(String str, String pattern){
        int left = 0;
        int matched = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(char c : pattern.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(int right = 0; right < str.length(); right++) {
            char rightChar = str.charAt(right);
            if(map.containsKey(rightChar)){
                map.put(rightChar, map.get(rightChar) - 1);
                if(map.get(rightChar) == 0) {
                    matched++;
                }
            }
            if(matched == map.size()) {
                return true;
            }
            if(right >= pattern.length() - 1) {
                char leftChar = str.charAt(left);
                if(map.containsKey(leftChar)) {
                    if(map.get(leftChar) == 0) {
                        matched--;
                    }
                    map.put(leftChar, map.get(leftChar) + 1);
                }
                left++;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("odicf", "dc"));
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("oidbcaf", "abc"));
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("bcdxabcdy", "bcdyabcdx"));
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("aaacb", "abc"));
    }
}