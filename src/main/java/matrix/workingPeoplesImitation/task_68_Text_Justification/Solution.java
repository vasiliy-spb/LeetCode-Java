package matrix.workingPeoplesImitation.task_68_Text_Justification;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<List<String>> lines = new ArrayList<>();
        List<String> currentList = new ArrayList<>();
        int currentWidth = 0;
        for (String word : words) {
            if (currentList.isEmpty()) {
                currentList.add(word);
                currentWidth += word.length() + 1;
            } else {
                if (currentWidth + word.length() > maxWidth) {
                    lines.add(currentList);
                    currentList = new ArrayList<>();
                    currentWidth = 0;
                }
                currentList.add(word);
                currentWidth += word.length() + 1;
            }
        }
        lines.add(currentList);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            StringBuilder formattedString = new StringBuilder();
            int countWord = line.size();
            if (i < lines.size() - 1) {
                int length = line.stream().mapToInt(String::length).sum();
                int spaceCount = countWord == 1 ? maxWidth - length : (maxWidth - length) / (countWord - 1);
                if (countWord == 1) {
                    int spaces = spaceCount;
                    String word = line.get(0);
                    formattedString.append(word);
                    while (spaces > 0) {
                        formattedString.append(" ");
                        spaces--;
                    }
                } else {
                    int countWordWithAdditionalSpace = (maxWidth - length) % (countWord - 1);
                    for (int j = 0; j < countWord; j++) {
                        String word = line.get(j);
                        formattedString.append(word);
                        if (j < countWord - 1) {
                            int spaces = spaceCount;
                            if (countWordWithAdditionalSpace > 0) {
                                spaces++;
                                countWordWithAdditionalSpace--;
                            }
                            while (spaces > 0) {
                                formattedString.append(" ");
                                spaces--;
                            }
                        }
                    }
                }
            } else {
                for (int j = 0; j < countWord; j++) {
                    String word = line.get(j);
                    formattedString.append(word);
                    if (j < countWord - 1) {
                        formattedString.append(" ");
                    } else {
                        while (formattedString.length() < maxWidth)
                            formattedString.append(" ");
                    }
                }
            }
            result.add(formattedString.toString());
        }
        return result;
    }
}
