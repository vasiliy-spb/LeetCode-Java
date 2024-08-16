package matrix.workingPeoplesImitation.task_2678_Number_of_Senior_Citizens;

import java.util.Arrays;

public class Solution {
    public int countSeniors(String[] details) {
        return (int) Arrays.stream(details).filter(s -> Integer.parseInt(s.substring(11, 13)) > 60).count();
    }
}
