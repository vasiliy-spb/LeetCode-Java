package matrix.workingPeoplesImitation.task_120_Triangle;

import java.util.List;

public class Solution {

    // my solution
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) return triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> prevLine = triangle.get(i - 1);
            List<Integer> line = triangle.get(i);
            for (int j = 0; j < line.size(); j++) {
                if (j == 0) line.set(j, line.get(j) + prevLine.get(j));
                else if (j == line.size() - 1) line.set(j, line.get(j) + prevLine.get(prevLine.size() - 1));
                else line.set(j, line.get(j) + Math.min(prevLine.get(j - 1), prevLine.get(j)));
            }
        }
        return triangle.get(triangle.size() - 1).stream().min(Integer::compareTo).get();
    }

    // from walkccc.me
    public int minimumTotal2(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; --i)
            for (int j = 0; j <= i; ++j)
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j),
                        triangle.get(i + 1).get(j + 1)));
        return triangle.get(0).get(0);
    }
}

/*

   2
  3 4
 6 5 7
4 1 8 3

 */