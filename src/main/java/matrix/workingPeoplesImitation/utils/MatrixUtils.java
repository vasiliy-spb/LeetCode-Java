package matrix.workingPeoplesImitation.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MatrixUtils {

    // сравнивает две двумерных матрицы между собой (ожидает матрицы одинакового размера)
    public static boolean areMatrixEquals(int[][] matrix1, int[][] matrix2) {
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                if (matrix1[i][j] != matrix2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // печатает двумерную матрицу в консоль
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // печатает двумерную матрицу в консоль
    public static void printMatrix(int[][] matrix, String delimiter) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + delimiter);
            }
            System.out.println();
        }
    }

    // читает двумерную матрицу из файла и возвращает её в виде массива int[][]
    public static int[][] readMatrixFromFile(String fileName) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            // Чтение всего содержимого файла
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Удаляем квадратные скобки с начала и конца
        String matrixString = content.toString().replaceAll("\\[\\[", "").replaceAll("\\]\\]", "");

        // Разделяем строки матрицы
        String[] rows = matrixString.split("\\],\\[");

        List<int[]> matrixList = new ArrayList<>();

        for (String row : rows) {
            // Разделяем элементы строки по запятой
            String[] elements = row.split(",");
            int[] intRow = new int[elements.length];
            for (int i = 0; i < elements.length; i++) {
                intRow[i] = Integer.parseInt(elements[i].trim());
            }
            matrixList.add(intRow);
        }

        // Преобразуем List<int[]> в int[][]
        int[][] matrix = new int[matrixList.size()][];
        for (int i = 0; i < matrixList.size(); i++) {
            matrix[i] = matrixList.get(i);
        }

        return matrix;
    }
}
