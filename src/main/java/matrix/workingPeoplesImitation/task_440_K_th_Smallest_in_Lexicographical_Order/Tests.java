package matrix.workingPeoplesImitation.task_440_K_th_Smallest_in_Lexicographical_Order;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Tests {
//    private final Solution testingClass = new Solution();
//    private final Solution2 testingClass = new Solution2();
//    private final Solution3 testingClass = new Solution3();
//    private final Solution4 testingClass = new Solution4();
//    private final Solution5 testingClass = new Solution5();
    private final Solution6 testingClass = new Solution6();

    @Test
    public void checkTestcase01() {
        int n = 13;
        int k = 2;
        int expected = 10;
        assertEquals(expected, testingClass.findKthNumber(n, k));
    }

    @Test
    public void checkTestcase02() {
        int n = 1;
        int k = 1;
        int expected = 1;
        assertEquals(expected, testingClass.findKthNumber(n, k));
    }

    @Test
    public void checkTestcase03() {
        int n = 10000;
        int k = 9000;
        int expected = 9098;
        assertEquals(expected, testingClass.findKthNumber(n, k));
    }

    @Test
    public void checkTestcase04() {
        int n = 100;
        int k = 90;
        int expected = 9;
        assertEquals(expected, testingClass.findKthNumber(n, k));
    }

    @Test
    public void checkTestcase05() {
        int n = 100000000;
        int k = 98000000;
        int expected = 98199998;
        assertEquals(expected, testingClass.findKthNumber(n, k));
    }

    @Test
    public void checkTestcase06() {
        int n = 100000000;
        int k = 98000000;
        int expected = 98199998;
        assertEquals(expected, testingClass.findKthNumber(n, k));
    }

    @Test
    public void checkTestcase07() {
        int n = 100000000;
        int k = 100000000;
        int expected = 99999999;
        assertEquals(expected, testingClass.findKthNumber(n, k));
    }

    @Test
    public void checkTestcase08() {
        int n = 100000000;
        int k = 99999999;
        int expected = 99999998;
        assertEquals(expected, testingClass.findKthNumber(n, k));
    }

    @Test
    public void checkTestcase09() {
        int n = 1_000_000_000;
        int k = 999_999_990;
        int expected = 99999999;
        assertEquals(expected, testingClass.findKthNumber(n, k));
    }

    @Test
    public void checkTestcase10() {
        int n = 681692778;
        int k = 351251360;
        int expected = 416126219;
        assertEquals(expected, testingClass.findKthNumber(n, k));
    }

    @Test
    public void checkTestcase11() {
        int n = 719885387;
        int k = 209989719;
        int expected = 288990744;
        assertEquals(expected, testingClass.findKthNumber(n, k));
    }

    @Test
    public void checkTestcase12() {
        int n = 1_000_000_000;
        int k = 999_999_000;
        int expected = 999999098;
        assertEquals(expected, testingClass.findKthNumber(n, k));
    }

    @Test
    public void checkTestcase13() {
        int n = 10_000;
        int k = 9_035;
        int expected = 9129;
        assertEquals(expected, testingClass.findKthNumber(n, k));
    }

    @Test
    public void checkTestcase14() {
        int n = 33334;
        int k = 22223;
        int expected = 3;
        assertEquals(expected, testingClass.findKthNumber(n, k));
    }

    @Test
    public void checkTestcase15() {
        int n = 33334;
        int k = 22221;
        int expected = 29998;
        assertEquals(expected, testingClass.findKthNumber(n, k));
    }

    @Test
    public void checkTestcase16() {
        int n = 33334;
        int k = 22231;
        int expected = 30004;
        assertEquals(expected, testingClass.findKthNumber(n, k));
    }

    @Test
    public void checkTestcase17() {
        int n = 33334;
        int k = 19373;
        int expected = 27433;
        assertEquals(expected, testingClass.findKthNumber(n, k));
    }

    @Test
    public void checkTestcase18() {
        int n = 333334;
        int k = 222223;
        int expected = 3;
        assertEquals(expected, testingClass.findKthNumber(n, k));
    }

    @Test
    public void checkTestcase19() {
        int n = 1333334;
        int k = 1222223;
        int expected = 899999;
        assertEquals(expected, testingClass.findKthNumber(n, k));
    }

    @Test
    public void checkTestcase20() {
        int n = 1333334;
        int k = 1222224;
        int expected = 9;
        assertEquals(expected, testingClass.findKthNumber(n, k));
    }

    @Test
    public void checkTestcase21() {
        int n = 13000;
        int k = 12990;
        int expected = 999;
        assertEquals(expected, testingClass.findKthNumber(n, k));
    }

    @Test
    public void checkTestcase22() {
        int n = 681692778;
        int k = 351251360;
        int expected = 416126219;
        assertEquals(expected, testingClass.findKthNumber(n, k));
    }

    @Test
    public void checkTestcase23() {
        int n = 957747794;
        int k = 424238336;
        int expected = 481814499;
        assertEquals(expected, testingClass.findKthNumber(n, k));
    }

    @Test
    public void checkTestcase24() {
        int n = 596516650;
        int k = 593124772;
        int expected = 96947306;
        assertEquals(expected, testingClass.findKthNumber(n, k));
    }
    /*

    011112 == 109999
    022223 == 119999
    033334 == 129999
    044445 == 139999
    055556 == 149999
    066667 == 159999
    077778 == 169999
    088889 == 179999
    100000 == 189999
    111111 == 199999
    122223 == 209999

     */

//    public static void main(String[] args) throws FileNotFoundException {
//        int n = 1333334;
//        List<Integer> ans = matrix.workingPeoplesImitation.task_386_Lexicographical_Numbers.Solution2.lexicalOrder(n);
//        PrintWriter writer = new PrintWriter("src/main/java/matrix/workingPeoplesImitation/task_440_K_th_Smallest_in_Lexicographical_Order/list_" + n + ".txt");
//        for (int num : ans) {
//            writer.println(num);
//            writer.flush();
//        }
//    }
}


/*
n == 10_000
1112 - последняя на 1***
2223 - последняя на 2***
3334 - последняя на 3***
4445 - последняя на 4***
5556 - последняя на 5***
6667 - последняя на 6***


2223 - 1112 + 1 = 1112
3334 - 2223 + 1 = 1112
...
 */

/*
n == 20_000
1112 - последняя на 10***
2223 - последняя на 11***
3334 - последняя на 12***
4445 - последняя на 13***
5556 - последняя на 14***
6667 - последняя на 15***
...

11111 - последняя на 1****
 */

/*
n == 30_000

11111 - последняя на 1****
22222 - последняя на 2****
 */

/*
n == 30_234

11111 - последняя на 1****
22222 - последняя на 2****
 */