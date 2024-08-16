package matrix.workingPeoplesImitation.task_1329_Sort_the_Matrix_Diagonally;

import java.util.*;

public class Solution {

    // my solution
    public int[][] diagonalSort(int[][] mat) {
        int i = mat.length - 1;
        int j = 0;
        while (i > 0) {
            int a = 0;
            List<Integer> list = new ArrayList<>();
            while (i + a < mat.length && j + a < mat[0].length) {
                list.add(mat[i + a][j + a]);
                a++;
            }
            list.sort(Comparator.naturalOrder());
            a = 0;
            while (i + a < mat.length && j + a < mat[0].length) {
                mat[i + a][j + a] = list.remove(0);
                a++;
            }
            i--;
        }
        i = 0;
        j = 0;
        while (j < mat[0].length) {
            int a = 0;
            List<Integer> list = new ArrayList<>();
            while (i + a < mat.length && j + a < mat[0].length) {
                list.add(mat[i + a][j + a]);
                a++;
            }
            list.sort(Comparator.naturalOrder());
            a = 0;
            while (i + a < mat.length && j + a < mat[0].length) {
                mat[i + a][j + a] = list.remove(0);
                a++;
            }
            j++;
        }
        return mat;
    }

    // from walkccc.me
    public int[][] diagonalSort2(int[][] mat) {
        final int m = mat.length;
        final int n = mat[0].length;

        Map<Integer, Queue<Integer>> count = new HashMap<>();

        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                count.computeIfAbsent(i - j, k -> new PriorityQueue<>()).add(mat[i][j]);

        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                mat[i][j] = count.get(i - j).poll();

        return mat;
    }

    // from leetcode code sample (1)
    int[] count = new int[101];
    int m;
    int n;

    public int[][] diagonalSort3(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        for (int i = 0; i < m; i++) {
            search(mat, i, 0);
        }
        for (int i = 1; i < n; i++) {
            search(mat, 0, i);
        }
        return mat;
    }

    public void search(int[][] mat, int i, int j) {
        for (int ti = i, tj = j; ti < m && tj < n; ti++, tj++) {
            count[mat[ti][tj]]++;
        }
        int c = 0;
        for (int ti = i, tj = j; ti < m && tj < n; ti++, tj++) {
            while (count[c] == 0) {
                c++;
            }
            mat[ti][tj] = c;
            count[c]--;
        }
    }

    // from leetcode code sample (2)
    int m2, n2;
    int ptr1, ptr2, ptr;
    int[] count2;

    /*
        Attempt 2 -> using problem constrainsts (1 <= mat[i][j] <= 100) to improve the Time Complexity by avoiding sorting..
    */
    public int[][] diagonalSort4(int[][] mat) {
        m2 = mat.length;
        n2 = mat[0].length;
        count2 = new int[101];

        for (int i = 0; i < m2; i++) {
            sortTheDiagonal(mat, i, 0);
        }

        for (int i = 1; i < n2; i++) {
            sortTheDiagonal(mat, 0, i);
        }

        return mat;
    }


    void sortTheDiagonal(int[][] mat, int i, int j) {
        ptr1 = i;
        ptr2 = j;
        while (ptr1 < m2 && ptr2 < n2) {
            int index = mat[ptr1++][ptr2++];
            count2[index]++;
        }
        ptr1 = i;
        ptr2 = j;
        for (int k = 1; k <= 100; k++) {
            while (count2[k] > 0) {
                mat[ptr1++][ptr2++] = k;
                count2[k]--;
            }
        }
    }

    // from leetcode code sample (2)
    public int[][] diagonalSort5(int[][] mat) {
        int n = mat.length;
        int count = 0;//this keeps the count of elements in frst row & 1st col
        int m = mat[0].length;
        int i = 0, k = 0;
//this while loop will be sending all the starting element-index of the diagonal
        while (count < m + n) {
            if (i == n - 1 && k < m) {
                ++k;
            }
            if (i != n - 1) {
                i++;
            }

            pass(mat, n - 1 - i, k, n, m);
            count++;
        }
        return mat;
    }

    public void pass(int[][] a, int row, int col, int n, int m) {

        //here we perform COUNT SORT IN EVERY DIAGONAL

        int[] arr = new int[101]; //Frequency Array
        int i = row, j = col;
        while (row < n && col < m) {
            arr[a[row++][col++]]++;
        }
//SORTING ELEMENTS IN ORIGINAL ARAY DIAGONAL
        for (int k = 0; k < 101; k++) {
            if (arr[k] > 0) {
                while (arr[k] != 0) {
                    a[i++][j++] = k;
                    --arr[k];
                }
            }
        }
    }

}

/*

Hint 1
Use a data structure to store all values of each diagonal.
Hint 2
How to index the data structure with the id of the diagonal?
Hint 3
All cells in the same diagonal (i,j) have the same difference so we can get the diagonal of a cell using the difference i-j.

 */