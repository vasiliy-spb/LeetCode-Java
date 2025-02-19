package matrix.workingPeoplesImitation.task_2375_Construct_Smallest_Number_From_DI_String;

import java.util.Arrays;

// my solution
public class Solution {
    public String smallestNumber(String pattern) {
        int[] num = new int[pattern.length() + 1];
        num[0] = 1;
        boolean[] visited = new boolean[10];
        visited[0] = true;
        visited[1] = true;
        for (int i = 1; i < num.length; i++) {
            if (pattern.charAt(i - 1) == 'I') {
                num[i] = num[i - 1] + 1;
                while (visited[num[i]]) {
                    num[i]++;
                }
                visited[num[i]] = true;
            } else {
                num[i] = num[i - 1] - 1;
                while (visited[num[i]]) {
                    for (int j = i - 1; j >= 0 && pattern.charAt(j) == 'D'; j--) {
                        num[j]++;
                    }
                    updateVisited(visited, num);
                    num[i] = num[i - 1] - 1;
                }
            }
        }
        return numToString(num);
    }

    private void updateVisited(boolean[] visited, int[] num) {
        Arrays.fill(visited, false);
        for (int i : num) {
            visited[i] = true;
        }
        visited[0] = true;
    }

    private String numToString(int[] num) {
        StringBuilder ans = new StringBuilder();
        for (int n : num) {
            ans.append(n);
        }
        return ans.toString();
    }
}
