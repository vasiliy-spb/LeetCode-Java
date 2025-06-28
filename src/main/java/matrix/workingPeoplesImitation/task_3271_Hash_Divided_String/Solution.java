package matrix.workingPeoplesImitation.task_3271_Hash_Divided_String;

// my solution
public class Solution {
    public String stringHash(String s, int k) {
        StringBuilder result = new StringBuilder();
        int length = 0;
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            hash += ch - 'a';
            length++;
            if (length == k) {
                hash %= 26;
                result.append((char) ('a' + hash));
                length = 0;
                hash = 0;
            }
        }
        return result.toString();
    }
    public String stringHash0(String s, int k) {
        String[] parts = new String[s.length() / k];
        StringBuilder part = new StringBuilder();
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            part.append(ch);
            if (part.length() == k) {
                parts[index++] = part.toString();
                part = new StringBuilder();
            }
        }
        StringBuilder result = new StringBuilder();
        for (String p : parts) {
            int hash = 0;
            for (char ch : p.toCharArray()) {
                hash += ch - 'a';
            }
            hash %= 26;
            result.append((char) ('a' + hash));
        }
        return result.toString();
    }
}
