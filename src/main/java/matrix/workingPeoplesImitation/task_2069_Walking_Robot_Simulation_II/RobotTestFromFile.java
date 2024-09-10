package matrix.workingPeoplesImitation.task_2069_Walking_Robot_Simulation_II;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RobotTestFromFile {

    @Test
    public void checkTestcaseFromFile() throws IOException {
        // Чтение данных из файла
        BufferedReader reader = new BufferedReader(new FileReader("src/main/java/matrix/workingPeoplesImitation/task_2069_Walking_Robot_Simulation_II/testcase8.txt"));
        String methodsLine = reader.readLine();
        String argsLine = reader.readLine();
        String expectedLine = reader.readLine();
        reader.close();

        // Парсинг данных
        List<String> methods = parseMethods(methodsLine);
        List<List<Integer>> arguments = parseArguments(argsLine);
        List<Object> expectedResults = parseExpectedResults(expectedLine);

        // Выполнение тестов
        Robot robot = new Robot(arguments.get(0).get(0), arguments.get(0).get(1));
        for (int i = 0; i < methods.size(); i++) {
            String method = methods.get(i);
            Object expected = expectedResults.get(i);

            if (method.equals("Robot")) {
//                List<Integer> arg = arguments.get(i);
//                robot = new Robot(arg.get(0), arg.get(1));
            } else if (method.equals("step")) {
                int arg = arguments.get(i).get(0);
                robot.step(arg);
            } else if (method.equals("getPos")) {
                int[] pos = robot.getPos();
                assertArrayEquals((int[])expected, pos);
            } else if (method.equals("getDir")) {
                String dir = robot.getDir();
                assertEquals(expected, dir);
            }
        }
    }

    // Вспомогательные методы для парсинга данных

    private List<String> parseMethods(String line) {
        line = line.replace("[", "").replace("]", "").replace("\"", "");
        return Arrays.asList(line.split(","));
    }

    private List<List<Integer>> parseArguments(String line) {
        line = line.replace("],[", "]|[");
        String[] parts = line.split("\\|");
        List<List<Integer>> args = new ArrayList<>();
        for (String part : parts) {
            if (part.equals("")) {
                args.add(new ArrayList<>());
            } else {
                String[] nums = part.replace("[", "").replace("]", "").split(",");
                List<Integer> argList = new ArrayList<>();
                for (String num : nums) {
                    if (num.equals("")) {
                        argList.add(Integer.MAX_VALUE);
                    } else {
                        argList.add(Integer.parseInt(num));
                    }
                }
                args.add(argList);
            }
        }
        return args;
    }

    private List<Object> parseExpectedResults(String line) {

        // из строки типа:
        // null,[0,0],"East",null,"South",[73,-1754],null
        // делаем
        // null,[0_0],"East",null,"South",[73_-1754],null
        // (то есть заменяем ',' меджу цифрами в квадратных скобках на '_')
        line = line.replaceAll("(?<=\\[-?\\d{1,10}),(?=-?\\d{1,10}\\])", "_"); // с положительным взглядом назад и вперёд
//        line = line.replaceAll("(?<=\\[-?\\d{1,10}),", "_"); // только с положительным взглядом назад
//        line = line.replaceAll(",(?=-?\\d{1,10}\\])", "_"); // только с положительным взглядом вперёд

        line = line.replace("[", "").replace("]", "").replace("\"", "");
        String[] parts = line.split(",");
        List<Object> results = new ArrayList<>();
        for (String part : parts) {
            if (part.equals("null")) {
                results.add(null);
            } else if (part.equals("East") || part.equals("West") || part.equals("North") || part.equals("South")) {
                results.add(part);
            } else {
                String[] nums = part.split("_");
                if (nums.length > 1) {
                    int[] pos = new int[2];
                    pos[0] = Integer.parseInt(nums[0]);
                    pos[1] = Integer.parseInt(nums[1]);
                    results.add(pos);
                } else {
                    results.add(null);
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        String s = "null,[0,0],\"East\",null,\"South\",[73,-1754],null";
        String s1 = s.replaceAll("(?<=\\[-?\\d{1,10}),(?=-?\\d{1,10}\\])", "_"); // с положительным взглядом назад и вперёд
        String s2  = s.replaceAll("(?<=\\[-?\\d{1,10}),", "_"); // только с положительным взглядом назад
        String s3  = s.replaceAll(",(?=-?\\d{1,10}\\])", "_"); // только с положительным взглядом вперёд
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
        System.out.println("s3 = " + s3);
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s2.equals(s3));
    }

}

