import java.util.*;

class WordConcatenation {
    public static List<Integer> findWordConcatenation(String str, String[] words) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int wordsCount = words.length;
        int wordLength = words[0].length();

        for(int i = 0; i < str.length() - wordsCount * wordLength; i++) {
            Map<String, Integer> seenMap = new HashMap<>();
            for(int j = 0; j < wordsCount; j++) {
                int nextWordIndex = i + j * wordLength;
                String word = str.substring(nextWordIndex, nextWordIndex + wordLength);
                if(!map.containsKey(word)) {
                    break;
                }
                seenMap.put(word, seenMap.getOrDefault(word, 0) + 1);

                if(seenMap.get(word) > seenMap.getOrDefault(word, 0)) {
                    break;
                }
                if(j + 1 == wordsCount)
                result.add(i);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        List<Integer> result = WordConcatenation.findWordConcatenation("catfoxcat", new String[] { "cat", "fox" });
        System.out.println(result);
        result = WordConcatenation.findWordConcatenation("catcatfoxfox", new String[] { "cat", "fox" });
        System.out.println(result);
    }
}