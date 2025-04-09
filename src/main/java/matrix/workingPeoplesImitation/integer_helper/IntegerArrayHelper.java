package matrix.workingPeoplesImitation.integer_helper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public final class IntegerArrayHelper {
    private IntegerArrayHelper() {
    }

    public static int[] readFromFile(String path) {
        return readFromFile(path, "\n");
    }

    public static int[] readFromFile(String path, String delimiter) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            StringBuilder content = new StringBuilder();
            while (reader.ready()) {
                content.append(reader.readLine());
            }
            String[] numberStrings = content.toString().trim().split(delimiter);
            int[] ans = new int[numberStrings.length];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = Integer.parseInt(numberStrings[i].trim());
            }
            return ans;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
