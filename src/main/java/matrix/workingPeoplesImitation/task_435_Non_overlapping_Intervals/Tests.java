package matrix.workingPeoplesImitation.task_435_Non_overlapping_Intervals;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        int expected = 1;
        assertEquals(expected, testingClass.eraseOverlapIntervals(intervals));
    }

    //    1   2   3   4
    //    |---|   |---|
    //        |---|
    //    |-------|

    @Test
    public void checkTestcase2() {
        int[][] intervals = {{1, 2}, {1, 2}, {1, 2}};
        int expected = 2;
        assertEquals(expected, testingClass.eraseOverlapIntervals(intervals));
    }

    //  1   2
    //  |---|
    //  |---|
    //  |---|

    @Test
    public void checkTestcase3() {
        int[][] intervals = {{1, 2}, {2, 3}};
        int expected = 0;
        assertEquals(expected, testingClass.eraseOverlapIntervals(intervals));
    }

    //  1   2   3
    //  |---|
    //      |---|

    @Test
    public void checkTestcase4() {
        int[][] intervals = {{1, 100}, {11, 22}, {1, 11}, {2, 12}};
        int expected = 2;
        assertEquals(expected, testingClass.eraseOverlapIntervals(intervals));
    }

    //  1   2   11  12  22  100
    //  |--------------------|
    //           |-------|
    //  |--------|
    //      |--------|

    @Test
    public void checkTestcase5() {
        int[][] intervals = {{0, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 6}};
        int expected = 2;
        assertEquals(expected, testingClass.eraseOverlapIntervals(intervals));
    }

    @Test
    public void checkTestcase6() {
        int[][] intervals = {{-52, 31}, {-73, -26}, {82, 97}, {-65, -11}, {-62, -49}, {95, 99}, {58, 95}, {-31, 49}, {66, 98}, {-63, 2}, {30, 47}, {-40, -26}};
        int expected = 7;
        assertEquals(expected, testingClass.eraseOverlapIntervals(intervals));
    }

    public static void drawInterval(int[][] intervals) {
        Set<Integer> set = new HashSet<>();
        for (int[] interval : intervals) {
            set.add(interval[0]);
            set.add(interval[1]);
        }
        int[] points = new int[set.size()];
        int index = 0;
        for (int i : set)
            points[index++] = i;
        Arrays.sort(points);

        int[] timeline = new int[points.length * 2 - 1];
        for (int i = 0, j = 0; i < points.length; i++) {
            timeline[j++] = points[i];
            if (j < timeline.length) timeline[j++] = Integer.MAX_VALUE;
        }

        List<int[]> matrix = new ArrayList<>();
        int n = timeline.length;

        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int lineIndex = hasPlaceInMatrix(timeline, matrix, interval);
            if (lineIndex < 0) {
                int[] line = new int[n];
                Arrays.fill(line, Integer.MAX_VALUE);
                insertToLine(timeline, line, interval);
                matrix.add(line);
            } else {
                insertToLine(timeline, matrix.get(lineIndex), interval);
            }
        }

        System.out.println("Intervals:");
        printScale(timeline);
        printMatix(timeline, matrix);
        System.out.println();
    }

    private static void printScale(int[] timeline) {
        for (int i = 0; i < timeline.length; i++) {
            if (timeline[i] != Integer.MAX_VALUE) System.out.print(timeline[i]);
            else System.out.print("   ");
        }
        System.out.println();
    }

    private static void printMatix(int[] timeline, List<int[]> matrix) {
        for (int[] line : matrix) {
            for (int i = 0; i < line.length; i++) {
                if (line[i] == Integer.MIN_VALUE) {
                    if (timeline[i] != Integer.MAX_VALUE) {
                        int count = numSize(timeline[i]);
                        while (count-- > 0)
                            System.out.print("-");
                    } else System.out.print("---");
                } else if (line[i] == Integer.MAX_VALUE) {
                    if (timeline[i] != Integer.MAX_VALUE) {
                        int count = numSize(timeline[i]);
                        while (count-- > 0)
                            System.out.print(" ");
                    } else System.out.print("   ");
                } else {
                    int count = numSize(timeline[i]) - 1;
                    while (count-- > 0) {
                        if (i == 0 || line[i - 1] != Integer.MIN_VALUE) System.out.print(" ");
                        else if (line[i - 1] != Integer.MAX_VALUE) System.out.print("-");
                    }
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }

    private static void insertToLine(int[] timeline, int[] line, int[] interval) {
        int start = interval[0];
        int end = interval[1];
        for (int j = 0; j < line.length; j++) {
            if (timeline[j] == start) {
                line[j] = start;
                while (timeline[j] != end) {
                    j++;
                    line[j] = Integer.MIN_VALUE;
                }
                line[j] = end;
                return;
            }
        }
    }

    private static int hasPlaceInMatrix(int[] timeline, List<int[]> matrix, int[] interval) {
        int start = interval[0];
        int end = interval[1];
        for (int i = 0; i < matrix.size(); i++) {
            int[] line = matrix.get(i);
            lineLoop:
            for (int j = 0; j < line.length; j++) {
                if (timeline[j] == start && line[j] == Integer.MAX_VALUE) {
                    while (timeline[j] != end) {
                        j++;
                        if (j < line.length && line[j] != Integer.MAX_VALUE) break lineLoop;
                    }
                    return i;
                }
            }
        }
        return -1;
    }

    public static int numSize(int num) {
        int size = num <= 0 ? 1 : 0;
        num = Math.abs(num);
        while (num > 0) {
            size++;
            num /= 10;
        }
        return size;
    }
}


/*
1. Ты должен строить визуализацию так: в первой строке в возрастающем порядке через символ табуляции идут все числа, обозначающие границы интервалов. Это своеобразная временная шкала интервалов.
2. Вторая и последующие строки заполняются так: берём первый интервал и обозначаем его границы симвоволом '|' под соответствующими числами. Пространство между этими границами заполняем символами '-'.
3. Берём следующий интервал — если в строках отрисованных для предыдущих интервалов есть свободное пространство для границ этого интервала (и заполнения между ними), то размещаем его в самой первой доступной для этого строке. Если места для отрисовки текущего интервала не достаточно в предыдущих строках (например, если хоть одно из нужных полей уже занято), значит создаём ниже новую строку и отрисовываем текущий интервал в ней.

 */


/*

-73   -65   -63   -62   -52   -49   -40   -31   -26   -11   2   30   31   47   49   58   66   82   95   97   98   99
                        |------------------------------------------|                       |--------|
|---------------------------------------------|             |--------|                       |-------------|
      |---------------------------------------------|                           |-------------|
                  |---------|         |----------------------------------|        |------------------|
            |---------------------------------------------|
                                    |---------|

 */