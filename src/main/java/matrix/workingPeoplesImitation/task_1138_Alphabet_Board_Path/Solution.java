package matrix.workingPeoplesImitation.task_1138_Alphabet_Board_Path;

import java.util.Map;
import java.util.Set;

// my solution
public class Solution {
    public String alphabetBoardPath(String target) {
        StringBuilder ans = new StringBuilder();
        int y = 0;
        int x = 0;
        for (int i = 0; i < target.length(); i++) {
            char ch = target.charAt(i);
            int row = (ch - 'a') / 5;
            int col = (ch - 'a') % 5;
            if (y == 5 && x == 0 && (y != row || x != col)) {
                ans.append('U');
                y--;
            }
            while (col > x) {
                ans.append('R');
                x++;
            }
            while (col < x) {
                ans.append('L');
                x--;
            }
            while (row > y) {
                ans.append('D');
                y++;
            }
            while (row < y) {
                ans.append('U');
                y--;
            }
            ans.append('!');
        }
        return ans.toString();
    }
    private final static Map<Integer, Set<Character>> rows = Map.of(
            0, Set.of('a', 'b', 'c', 'd', 'e'),
            1, Set.of('f', 'g', 'h', 'i', 'j'),
            2, Set.of('k', 'l', 'm', 'n', 'o'),
            3, Set.of('p', 'q', 'r', 's', 't'),
            4, Set.of('u', 'v', 'w', 'x', 'y'),
            5, Set.of('z')
    );
    private final static Map<Integer, Set<Character>> cols = Map.of(
            0, Set.of('a', 'f', 'k', 'p', 'u', 'z'),
            1, Set.of('b', 'g', 'l', 'q', 'v'),
            2, Set.of('c', 'h', 'm', 'r', 'w'),
            3, Set.of('d', 'i', 'n', 's', 'x'),
            4, Set.of('e', 'j', 'o', 't', 'y')
    );

    public String alphabetBoardPath0(String target) {
        StringBuilder ans = new StringBuilder();
        int y = 0;
        int x = 0;
        for (int i = 0; i < target.length(); i++) {
            int row = findLetter(rows, target.charAt(i));
            int col = findLetter(cols, target.charAt(i));
            if (y == 5 && x == 0 && (y != row || x != col)) {
                ans.append('U');
                y--;
            }
            while (col > x) {
                ans.append('R');
                x++;
            }
            while (col < x) {
                ans.append('L');
                x--;
            }
            while (row > y) {
                ans.append('D');
                y++;
            }
            while (row < y) {
                ans.append('U');
                y--;
            }
            ans.append('!');
        }
        return ans.toString();
    }

    private int findLetter(Map<Integer, Set<Character>> map, char letter) {
        for (int key : map.keySet()) {
            if (map.get(key).contains(letter)) {
                return key;
            }
        }
        return -1;
    }
}
