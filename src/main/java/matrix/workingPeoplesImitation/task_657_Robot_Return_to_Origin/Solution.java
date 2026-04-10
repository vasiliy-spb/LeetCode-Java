package matrix.workingPeoplesImitation.task_657_Robot_Return_to_Origin;

// my solution
class Solution {
    public boolean judgeCircle(String moves) {
        int row = 0;
        int column = 0;
        for (char ch : moves.toCharArray()) {
            switch (ch) {
                case 'U' -> row++;
                case 'D' -> row--;
                case 'R' -> column++;
                case 'L' -> column--;
            }
        }
        return row == 0 && column == 0;
    }
}
