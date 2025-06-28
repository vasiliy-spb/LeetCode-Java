package matrix.workingPeoplesImitation.task_1222_Queens_That_Can_Attack_the_King;

import java.util.*;

public class Solution {

    // my solution
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> ans = new ArrayList<>();
        int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};
        int[][] board = new int[8][8];
        board[king[0]][king[1]] = 2;
        for (int[] queen : queens) {
            board[queen[0]][queen[1]] = 1;
        }
        for (int[] dir : dirs) {
            int a = king[0];
            int b = king[1];
            while (a >= 0 && b >= 0 && a < 8 && b < 8) {
                if (board[a][b] == 1) {
                    ans.add(List.of(a, b));
                    break;
                }
                a += dir[0];
                b += dir[1];
            }
        }
        return ans;
    }

    // from walkccc.me
    public List<List<Integer>> queensAttacktheKing2(int[][] queens, int[] king) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<Integer> queensSet = new HashSet<>();

        for (int[] queen : queens)
            queensSet.add(hash(queen[0], queen[1]));

        int[][] directions =
                new int[][] {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for (int[] d : directions)
            for (int i = king[0] + d[0], j = king[1] + d[1]; 0 <= i && i < 8 && 0 <= j && j < 8;
                 i += d[0], j += d[1])
                if (queensSet.contains(hash(i, j))) {
                    ans.add(Arrays.asList(i, j));
                    break;
                }

        return ans;
    }

    private int hash(int i, int j) {
        return i * 8 + j;
    }

}
