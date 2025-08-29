package matrix.workingPeoplesImitation.task_3021_Alice_and_Bob_Playing_Flower_Game.task_3021_Alice_and_Bob_Playing_Flower_Game;

// my solution
public class Solution {
    public long flowerGame(int n, int m) {
        return countEven(n) * countOdd(m) + countOdd(n) * countEven(m);
    }

    private long countEven(int num) {
        return num >> 1;
    }

    private long countOdd(int num) {
        if ((num & 1) == 0) {
            return num >> 1;
        }
        return (num >> 1) + 1;
    }
}