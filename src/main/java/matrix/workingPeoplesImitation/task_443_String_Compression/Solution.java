package matrix.workingPeoplesImitation.task_443_String_Compression;

public class Solution {

    public int compress(char[] chars) {
        int count = 1;
        int index = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] == chars[i]) {
                count++;
                if (i == chars.length - 1 && count > 1) {
                    char[] numbers = Integer.toString(count).toCharArray();
                    for (char number : numbers) {
                        chars[index++] = number;
                    }
                }
            } else {
                if (count > 1) {
                    char[] numbers = Integer.toString(count).toCharArray();
                    for (char number : numbers) {
                        chars[index++] = number;
                    }
                    chars[index++] = chars[i];
                } else {
                    chars[index++] = chars[i];
                }
                count = 1;
            }
        }
        return index;
    }

    // это решение не проходило потому что использовало дополнительное пространство (что противоречит условию)
    public int compress2(char[] chars) {
        int count = 1;
        int index = 1;
        StringBuilder compressedChars = new StringBuilder();
        compressedChars.append(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] == chars[i]) {
                count++;
                if (i == chars.length - 1 && count > 1) {
                    compressedChars.append(count);
                }
            } else {
                if (count > 1) {
                    compressedChars.append(count);
                } else {
                    index++;
                }
                compressedChars.append(chars[i]);
                count = 1;
            }
        }
        chars = compressedChars.toString().toCharArray();
        return chars.length;
    }

    // from editorial
    public int compress3(char[] chars) {
        int i = 0, res = 0;
        while (i < chars.length) {
            int groupLength = 1;
            while (i + groupLength < chars.length && chars[i + groupLength] == chars[i]) {
                groupLength++;
            }
            chars[res++] = chars[i];
            if (groupLength > 1) {
                for (char c : Integer.toString(groupLength).toCharArray()) {
                    chars[res++] = c;
                }
            }
            i += groupLength;
        }
        return res;
    }
}