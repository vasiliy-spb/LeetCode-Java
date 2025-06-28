package matrix.workingPeoplesImitation.task_2982_Find_Longest_Special_Substring_That_Occurs_Thrice_II;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// from leetcode code sample (4)
public class Solution6 {
    public int maximumLength(String s) {
        int result = -1;
        int length = s.length();
        Map<Character, int[]> resultMap = new HashMap<>();
        char currentLetter = s.charAt(0);
        int countCurrentLetter = 1;
        for (int i = 1; i < length; i++) {
            if (currentLetter == s.charAt(i)) {
                countCurrentLetter += 1;
            } else {
                extracted(currentLetter, countCurrentLetter, resultMap);
                currentLetter = s.charAt(i);
                countCurrentLetter = 1;
            }
        }
        extracted(currentLetter, countCurrentLetter, resultMap);
        for (Map.Entry<Character, int[]> entry : resultMap.entrySet()) {
            int[] letterArray = entry.getValue();
            int startIndex = letterArray.length - 1;
            while (letterArray[startIndex] == 0) startIndex -= 1;
            for (int i = startIndex - 1; i > 0; i--) {
                letterArray[i] += letterArray[i + 1] + 1;
                if (letterArray[i] > 2) {
                    result = Math.max(result, i + 1);
                }
            }
            if (letterArray[startIndex] > 2) {
                result = Math.max(result, startIndex + 1);
            }
            if (letterArray[0] > 2) {
                result = Math.max(result, 1);
            }
        }
        return result;
    }

    private static void extracted(char currentLetter, int currentLetterCount, Map<Character, int[]> resultMap) {
        int[] letterArray;
        if (resultMap.containsKey(currentLetter)) {
            letterArray = resultMap.get(currentLetter);
        } else {
            letterArray = new int[8];
            resultMap.put(currentLetter, letterArray);
        }
        if (letterArray.length < currentLetterCount) {
            letterArray = Arrays.copyOf(letterArray, currentLetterCount);
            resultMap.put(currentLetter, letterArray);
        }
        letterArray[currentLetterCount - 1] += 1;
        if (currentLetterCount != 1) letterArray[0] += currentLetterCount;
    }
}
