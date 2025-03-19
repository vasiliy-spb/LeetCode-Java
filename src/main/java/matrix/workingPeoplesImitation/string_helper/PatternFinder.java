package matrix.workingPeoplesImitation.string_helper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PatternFinder {
    // from Microsoft Copilot
    public static void showPattern(String input) {
        int length = input.length();
        for (int i = 1; i <= length / 2; i++) {
            String pattern = input.substring(0, i);
            int count = length / i;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < count; j++) {
                sb.append(pattern);
            }
            if (sb.toString().equals(input)) {
                System.out.print("pattern: " + pattern);
                System.out.println(";\tcount: " + count);
                return;
            }
        }
        System.out.println("Строка не состоит из повторяющегося паттерна");
    }

    private static String representElementAsCode(String pattern, int count) {
        return String.format("\"%s\".repeat(%d)", pattern, count);
    }

    public static String getCodeRepresentsForString(String input) {
        return findPatternAndRepresentElementAsCode(input);
    }

    private static String findPatternAndRepresentElementAsCode(String input) {
        return getElementsForListAsCode(List.of(input));
    }

    public String getElementsForListAsCode(List<String> patterns, List<Integer> counts) {
        StringBuilder elementsAsCode = new StringBuilder();
        for (int i = 0; i < patterns.size(); i++) {
            String currentElement = representElementAsCode(patterns.get(i), counts.get(i));
            elementsAsCode.append(currentElement);
            if (i < patterns.size() - 1) {
                elementsAsCode.append(", ");
            }
        }
        return elementsAsCode.toString();
    }

    public static String getElementsForListAsCodeFromFile(String fileName) {
        return getElementsForListAsCode(getStringListFromFile(fileName));
    }
    public static String getElementsForListAsCode(List<String> stringList) {
        List<String> patterns = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();
        for (String s : stringList) {
            findPattern(s, patterns, counts);
        }
        StringBuilder elementsAsCode = new StringBuilder();
        for (int i = 0; i < stringList.size(); i++) {
            String currentElement = representElementAsCode(patterns.get(i), counts.get(i));
            elementsAsCode.append(currentElement);
            if (i < patterns.size() - 1) {
                elementsAsCode.append(", ");
            }
        }
        return elementsAsCode.toString();
    }

    private static void findPattern(String input, List<String> patterns, List<Integer> counts) {
        int length = input.length();
        for (int i = 1; i <= length / 2; i++) {
            String pattern = input.substring(0, i);
            int count = length / i;
            StringBuilder sb = new StringBuilder();
            sb.append(pattern.repeat(count));
            if (sb.toString().equals(input)) {
                patterns.add(pattern);
                counts.add(count);
                return;
            }
        }
        patterns.add(input);
        counts.add(1);
    }

    public static List<String> getStringListFromFile(String fileName) {
        try {
            String s = new BufferedReader(new FileReader(fileName)).readLine();
            s = s.replace("\"", "");
            s = s.replace("[", "");
            s = s.replace("]", "");
            String[] arr = s.split(",");
            return Arrays.stream(arr).toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
