package matrix.workingPeoplesImitation.task_17_Letter_Combinations_of_a_Phone_Number;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    // my solution (beats 100%)
    public List<String> letterCombinations(String digits) {
        String[] buttons = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        if (digits != null && digits.length() > 0)
            makeCombinations(digits, new StringBuilder(), result, buttons, 0);
        return result;
    }

    private void makeCombinations(String digits, StringBuilder stringBuilder, List<String> result, String[] buttons, int start) {
        if (stringBuilder.length() == digits.length()) {
            result.add(stringBuilder.toString());
            return;
        }
        for (int i = start; i < digits.length(); i++) {
            int key = digits.charAt(i) - '0';
            for (char ch : buttons[key].toCharArray()) {
                stringBuilder.append(ch);
                makeCombinations(digits, stringBuilder, result, buttons, i + 1);
                stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
            }
        }
    }

    // my solution
    public List<String> letterCombinations0(String digits) {
        Map<Integer, char[]> buttons = Map.of(
                2, new char[]{'a', 'b', 'c'},
                3, new char[]{'d', 'e', 'f'},
                4, new char[]{'g', 'h', 'i'},
                5, new char[]{'j', 'k', 'l'},
                6, new char[]{'m', 'n', 'o'},
                7, new char[]{'p', 'q', 'r', 's'},
                8, new char[]{'t', 'u', 'v'},
                9, new char[]{'w', 'x', 'y', 'z'}
        );
        List<String> result = new ArrayList<>();
        if (digits != null && digits.length() > 0)
            makeCombinations0(digits, new ArrayList<>(), result, buttons, 0);
        return result;
    }

    private void makeCombinations0(String digits, List<Character> currentList, List<String> result, Map<Integer, char[]> buttons, int start) {
        if (currentList.size() == digits.length()) {
            result.add(currentList.stream().map(String::valueOf).collect(Collectors.joining()));
            return;
        }
        for (int i = start; i < digits.length(); i++) {
            int key = Integer.parseInt(String.valueOf(digits.charAt(i)));
            for (char ch : buttons.get(key)) {
                currentList.add(ch);
                makeCombinations0(digits, currentList, result, buttons, i + 1);
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    // from walkccc.me (Approach 1: DFS)
    public List<String> letterCombinations1(String digits) {
        if (digits.isEmpty())
            return new ArrayList<>();

        List<String> ans = new ArrayList<>();

        dfs(digits, 0, new StringBuilder(), ans);
        return ans;
    }

    private static final String[] digitToLetters = {"",    "",    "abc",  "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private void dfs(String digits, int i, StringBuilder sb, List<String> ans) {
        if (i == digits.length()) {
            ans.add(sb.toString());
            return;
        }

        for (final char c : digitToLetters[digits.charAt(i) - '0'].toCharArray()) {
            sb.append(c);
            dfs(digits, i + 1, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    // from walkccc.me (Approach 2: Iterative)
    public List<String> letterCombinations2(String digits) {
        if (digits.isEmpty())
            return new ArrayList<>();

        List<String> ans = new ArrayList<>();
        ans.add("");
        final String[] digitToLetters = {"",    "",    "abc",  "def", "ghi",
                "jkl", "mno", "pqrs", "tuv", "wxyz"};

        for (final char d : digits.toCharArray()) {
            List<String> temp = new ArrayList<>();
            for (final String s : ans)
                for (final char c : digitToLetters[d - '0'].toCharArray())
                    temp.add(s + c);
            ans = temp;
        }

        return ans;
    }

    // from leetcode solutions
    // My java solution with FIFO queue
    public List<String> letterCombinations3(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if(digits.isEmpty()) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){
                String t = ans.remove();
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;
    }
    //
    // from leetcode solutions
    // A version without first loop, but same time complexity. Both are single queue BFS solutions.:
    public List<String> letterCombinations4(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if(digits.isEmpty()) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        while(ans.peek().length()!=digits.length()){
            String remove = ans.remove();
            String map = mapping[digits.charAt(remove.length())-'0'];
            for(char c: map.toCharArray()){
                ans.addLast(remove+c);
            }
        }
        return ans;
    }
    // from comments
    //
    // This is a iterative solution. For each digit added, remove and copy every element in the queue and add the possible letter to each element, then add the updated elements back into queue again. Repeat this procedure until all the digits are iterated.
    // I did a experiment to compare backtracking(DFS) method and this iterative method. It turns out iterative one is 4 times faster.
    //
    // One minor bug here.
    // We need to add some code to test whether the input is empty or not.
    // Above ans.add("");
    // add
    //
    // if (digits.length()==0){
    //	 return ans;
    // }

}
