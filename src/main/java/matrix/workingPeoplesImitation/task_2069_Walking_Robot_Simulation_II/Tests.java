package matrix.workingPeoplesImitation.task_2069_Walking_Robot_Simulation_II;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Tests {

    @Test
    public void checkTestcase01() {
        Robot robot = new Robot(3, 3);
        System.out.println(Arrays.toString(robot.getPos()));
        System.out.println(robot.getDir());
        robot.step(8);
        String direction = robot.getDir();
        String expected = "South";
        assertEquals(expected, direction);
    }

    @Test
    public void checkTestcase02() {
        Robot robot = new Robot(3, 3);
        System.out.println(Arrays.toString(robot.getPos()));
        System.out.println(robot.getDir());
        robot.step(3);
        robot.step(5);
        String direction = robot.getDir();
        String expected = "South";
        assertEquals(expected, direction);
    }

    @Test
    public void checkTestcase03() {
        Robot robot = new Robot(3, 3);
        System.out.println(Arrays.toString(robot.getPos()));
        System.out.println(robot.getDir());
        robot.step(2);
        robot.step(2);
        robot.step(2);
        robot.step(2);
        String direction = robot.getDir();
        String expected = "South";
        assertEquals(expected, direction);
    }

    @Test
    public void checkTestcase04() {
        Robot robot = new Robot(3, 3);
        System.out.println(Arrays.toString(robot.getPos()));
        System.out.println(robot.getDir());
        robot.step(4);
        robot.step(4);
        robot.step(4);
        robot.step(4);
        String direction = robot.getDir();
        String expected = "South";
        assertEquals(expected, direction);
    }

    @Test
    public void checkTestcase06() {
        Robot robot = new Robot(3, 3);
        System.out.println(Arrays.toString(robot.getPos()));
        System.out.println(robot.getDir());
        robot.step(16);
        String direction = robot.getDir();
        String expected = "South";
        assertEquals(expected, direction);
    }

    @Test
    public void checkTestcase07() {
        // Создаем робота с начальной позицией (3, 2)
        Robot robot = new Robot(3, 2);

        // Выполняем шаги робота
        robot.step(39);
        robot.step(66740);
        robot.step(29630);
        robot.step(61644);

        // Проверяем текущую позицию и направление
        assertArrayEquals(new int[]{1, 0}, robot.getPos());
        assertEquals("East", robot.getDir());

        robot.step(41034);
        robot.step(49464);
        robot.step(29161);
        robot.step(7314);

        assertArrayEquals(new int[]{2, 0}, robot.getPos());
        assertEquals("East", robot.getDir());

        robot.step(72825);
        robot.step(63926);
        robot.step(46285);
        robot.step(29935);
        robot.step(74340);

        assertArrayEquals(new int[]{2, 1}, robot.getPos());
        assertEquals("North", robot.getDir());

        robot.step(64091);
        robot.step(95787);

        assertArrayEquals(new int[]{0, 1}, robot.getPos());
        assertEquals("West", robot.getDir());

        robot.step(66681);

        assertArrayEquals(new int[]{2, 0}, robot.getPos());
        assertEquals("East", robot.getDir());

        robot.step(25364);
        robot.step(24292);
        robot.step(24195);

        assertArrayEquals(new int[]{0, 1}, robot.getPos());
        assertEquals("West", robot.getDir());

        robot.step(67802);

        assertArrayEquals(new int[]{1, 0}, robot.getPos());
        assertEquals("East", robot.getDir());

        robot.step(94868);
        robot.step(44077);
        robot.step(80481);

        assertArrayEquals(new int[]{1, 0}, robot.getPos());
        assertEquals("East", robot.getDir());
    }
}
