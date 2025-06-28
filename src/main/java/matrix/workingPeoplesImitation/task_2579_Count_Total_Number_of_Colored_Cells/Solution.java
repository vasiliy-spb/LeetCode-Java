package matrix.workingPeoplesImitation.task_2579_Count_Total_Number_of_Colored_Cells;

// my solution
public class Solution {
    public long coloredCells(int n) {
        long ans = 1;
        int minute = 0;
        while (++minute <= n) {
            ans += (minute - 1) * 4;
        }
        return ans;
    }
}

/*
. . . . . . . . . . . . . . . . . . . . . . . . . . . .
. . . . . . . . . . . . . 5 . . . . . . . . . . . . . .
. . . . . . . . . . . . 5 4 5 . . . . . . . . . . . . .
. . . . . . . . . . . 5 4 3 4 5 . . . . . . . . . . . .
. . . . . . . . . . 5 4 3 2 3 4 5 . . . . . . . . . . .
. . . . . . . . . 5 4 3 2 1 2 3 4 5 . . . . . . . . . .
. . . . . . . . . . 5 4 3 2 3 4 5 . . . . . . . . . . .
. . . . . . . . . . . 5 4 3 4 5 . . . . . . . . . . . .
. . . . . . . . . . . . 5 4 5 . . . . . . . . . . . . .
. . . . . . . . . . . . . 5 . . . . . . . . . . . . . .
. . . . . . . . . . . . . . . . . . . . . . . . . . . . 

m1 = 1
m2 = m1 + 4
m3 = m2 + 8
m4 = m3 + 12
m5 = m4 + 16
 */