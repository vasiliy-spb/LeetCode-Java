package matrix.workingPeoplesImitation.task_1371_Find_the_Longest_Substring_Containing_Vowels_in_Even_Counts;

import java.util.HashMap;
import java.util.Map;

// my solution (after hint from GPT)
public class Solution {
    public int findTheLongestSubstring(String s) {
        Map<String, Integer> maskIndexMap = new HashMap<>();
        int length = 0;
        char[] maskArray = {'0', '0', '0', '0', '0'};
        maskIndexMap.putIfAbsent(String.valueOf(maskArray), -1);
        for (int i = 0; i < s.length(); i++) {
            updateMaskArray(s.charAt(i), maskArray);
            String mask = String.valueOf(maskArray);
            length = Math.max(length, i - maskIndexMap.getOrDefault(mask, i));
            maskIndexMap.putIfAbsent(mask, i);
        }
        return length;
    }
    private void updateMaskArray(char c, char[] maskArray) {
        int index = getVowelIndex(c);
        if (index >= 0) {
            maskArray[index] = maskArray[index] == '0' ? '1' : '0';
        }
    }
    private int getVowelIndex(char ch) {
        return "aeiou".indexOf(ch);
    }

//    private String getMaskForChar(char ch) {
//        int index = getVowelIndex(ch);
//        char[] maskArray = {'0', '0', '0', '0', '0'};
//        if (index >= 0) {
//            maskArray[index] = '1';
//        }
//        return String.valueOf(maskArray);
//    }

//    public int findTheLongestSubstring2(String s) {
//        int count = 0;
//        StringBuilder mask = new StringBuilder();
//        for (char letter : s.toCharArray()) {
//            if (isVowel(letter)) {
//                count++;
//            }
//            if (count % 2 == 0) {
//                mask.append('0');
//            } else {
//                mask.append('1');
//            }
//        }
//        System.out.println("mask = " + mask);
//        return mask.lastIndexOf("0") - mask.indexOf("0") + 1;
//    }

//    public int findTheLongestSubstring1(String s) {
//        int[] countVowels = new int[5];
//        StringBuilder mask = new StringBuilder();
//        for (char letter : s.toCharArray()) {
//            if (isVowel(letter)) {
//                countVowels[getVowelIndex(letter)]++;
//            }
//            if (areAllEven(countVowels)) {
//                mask.append('0');
//            } else {
//                mask.append('1');
//            }
//        }
//        System.out.println("mask = " + mask);
//        return Arrays.stream(mask.toString().split("1")).mapToInt(String::length).max().getAsInt();
//    }

//    private boolean areAllEven(int[] countVowels) {
//        return Arrays.stream(countVowels).allMatch(c -> c % 2 == 0);
//    }

//    private boolean isVowel(char ch) {
//        return "aeiou".indexOf(ch) >= 0;
//    }

//    public int findTheLongestSubstring0(String s) {
//        StringBuilder maskA = new StringBuilder("0");
//        StringBuilder maskE = new StringBuilder("0");
//        StringBuilder maskI = new StringBuilder("0");
//        StringBuilder maskO = new StringBuilder("0");
//        StringBuilder maskU = new StringBuilder("0");
//        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            maskA.append(maskA.charAt(maskA.length() - 1));
//            maskE.append(maskE.charAt(maskE.length() - 1));
//            maskI.append(maskI.charAt(maskI.length() - 1));
//            maskO.append(maskO.charAt(maskO.length() - 1));
//            maskU.append(maskU.charAt(maskU.length() - 1));
//            switch (ch) {
//                case 'a' ->
//                        maskA.replace(maskA.length() - 1, maskA.length(), String.valueOf(maskA.charAt(maskA.length() - 1) == '0' ? 1 : 0));
//                case 'e' ->
//                        maskE.replace(maskE.length() - 1, maskE.length(), String.valueOf(maskE.charAt(maskE.length() - 1) == '0' ? 1 : 0));
//                case 'i' ->
//                        maskI.replace(maskI.length() - 1, maskI.length(), String.valueOf(maskI.charAt(maskI.length() - 1) == '0' ? 1 : 0));
//                case 'o' ->
//                        maskO.replace(maskO.length() - 1, maskO.length(), String.valueOf(maskO.charAt(maskO.length() - 1) == '0' ? 1 : 0));
//                case 'u' ->
//                        maskU.replace(maskU.length() - 1, maskU.length(), String.valueOf(maskU.charAt(maskU.length() - 1) == '0' ? 1 : 0));
//            }
//        }
//        maskA.deleteCharAt(0);
//        maskE.deleteCharAt(0);
//        maskI.deleteCharAt(0);
//        maskO.deleteCharAt(0);
//        maskU.deleteCharAt(0);
//        System.out.println("maskA = " + maskA);
//        System.out.println("maskE = " + maskE);
//        System.out.println("maskI = " + maskI);
//        System.out.println("maskO = " + maskO);
//        System.out.println("maskU = " + maskU);
//        StringBuilder resultMask = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            if (maskA.charAt(i) == '1') {
//                resultMask.append('1');
//                continue;
//            }
//            if (maskE.charAt(i) == '1') {
//                resultMask.append('1');
//                continue;
//            }
//            if (maskI.charAt(i) == '1') {
//                resultMask.append('1');
//                continue;
//            }
//            if (maskO.charAt(i) == '1') {
//                resultMask.append('1');
//                continue;
//            }
//            if (maskU.charAt(i) == '1') {
//                resultMask.append('1');
//            }
//            resultMask.append('0');
//        }
//        System.out.println("resultMask = " + resultMask);
//        return Arrays.stream(resultMask.toString().split("1")).mapToInt(String::length).max().getAsInt();
//    }
}
