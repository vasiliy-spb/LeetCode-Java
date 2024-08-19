package matrix.workingPeoplesImitation.task_2326_Spiral_Matrix_IV;

import java.util.Arrays;

public class Solution {

    // my solution
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        int top = 0;
        int right = n - 1;
        int bottom = m - 1;
        int left = 0;
        while (top <= bottom || left <= right) {
            if (top <= bottom) {
                for (int i = left; i <= right; i++) {
                    if (head == null) {
                        matrix[top][i] = -1;
                    } else {
                        matrix[top][i] = head.val;
                        head = head.next;
                    }
                }
                top++;
            }
            if (top > bottom && left > right) {
                break;
            }
            if (left <= right) {
                for (int i = top; i <= bottom; i++) {
                    if (head == null) {
                        matrix[i][right] = -1;
                    } else {
                        matrix[i][right] = head.val;
                        head = head.next;
                    }
                }
                right--;
            }
            if (top > bottom && left > right) {
                break;
            }
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    if (head == null) {
                        matrix[bottom][i] = -1;
                    } else {
                        matrix[bottom][i] = head.val;
                        head = head.next;
                    }
                }
                bottom--;
            }
            if (top > bottom && left > right) {
                break;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    if (head == null) {
                        matrix[i][left] = -1;
                    } else {
                        matrix[i][left] = head.val;
                        head = head.next;
                    }
                }
                left++;
            }
        }
        return matrix;
    }

    private int getVal(ListNode node) {
        int ans = -1;
        if (node != null) {
            ans = node.val;
            node = node.next;
        }
        return ans;
    }

    // from walkccc.me
//    public int[][] spiralMatrix2(int m, int n, ListNode head) {
//        final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
//        int[][] ans = new int[m][n];
//        Arrays.stream(ans).forEach(A -> Arrays.fill(A, -1));
//        int x = 0; // the current x position
//        int y = 0; // the current y position
//        int d = 0;
//
//        for (ListNode curr = head; curr != null; curr = curr.next) {
//            ans[x][y] = curr.val;
//            if (x + dirs[d] < 0 || x + dirs[d] == m || y + dirs[d + 1] < 0 || y + dirs[d + 1] == n ||
//                    ans[x + dirs[d]][y + dirs[d + 1]] != -1)
//                d = (d + 1) % 4;
//            x += dirs[d];
//            y += dirs[d + 1];
//        }
//
//        return ans;
//    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
