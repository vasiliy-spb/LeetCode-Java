package matrix.workingPeoplesImitation.task_38_Count_and_Say;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // my solution (fastest of all my solutions)
    public String countAndSay(int n) {
        String result = "1";
        for (int i = 1; i < n; i++) {
            result = makeString(result);
        }
        return result;
    }

    private String makeString(String num) {
        StringBuilder result = new StringBuilder();
        char prev = 'a';
        int count = 0;
        for (char number : num.toCharArray()) {
            if (prev == 'a') prev = number;
            if (prev != 'a' && number != prev) {
                result.append(count).append(prev);
                count = 0;
            }
            count += 1;
            prev = number;
        }
        if (result.length() == 0 || result.charAt(result.length() - 1) != prev) {
            result.append(count).append(num.charAt(num.length() - 1));
        }
        return result.toString();
    }


//    public String countAndSay(int n) {
//        StringBuilder result = new StringBuilder("1");
//        for (int i = 1; i < n; i++) {
//            result = makeString(result);
//        }
//        return result.toString();
//    }
//
//    private StringBuilder makeString(StringBuilder num) {
//        StringBuilder result = new StringBuilder();
//        char prev = num.charAt(0);
//        int count = 1;
//        for (int i = 1; i < num.length(); i++) {
//            char number = num.charAt(i);
//            if (number != prev) {
//                result.append(count).append(prev);
//                count = 0;
//            }
//            count++;
//            prev = number;
//        }
//        if (result.length() == 0 || result.charAt(result.length() - 1) != prev) {
//            result.append(count).append(num.charAt(num.length() - 1));
//        }
//        return result;
//    }

//    public String countAndSay(int n) {
//        int k = n * 149;
//        String result = "1";
//        for (int i = 1; i < n; i++) {
//            char[] chars = new char[k];
//            int[] counts = new int[k];
//            char prev = result.charAt(0);
//            chars[0] = result.charAt(0);
//            counts[0]++;
//            int index = 0;
//            for (int j = 1; j < result.length(); j++) {
//                char number = result.charAt(j);
//                if (number != prev) chars[++index] = number;
//                counts[index]++;
//                prev = number;
//            }
//
//            StringBuilder ans = new StringBuilder();
//            for (int j = 0; j < k; j++) {
//                if (counts[j] == 0) break;
//                ans.append(counts[j]).append(chars[j]);
//            }
//            result = ans.toString();
//        }
//        return result;
//    }


//    public String countAndSay(int n) {
//        StringBuilder result = new StringBuilder("1");
//        int k = n < 21 ? 305 : 4465;
//        for (int i = 1; i < n; i++) {
//            result = makeString(result, k);
//        }
//        return result.toString();
//    }
//
//    private StringBuilder makeString(StringBuilder num, int n) {
//        char[] chars = new char[n];
//        int[] counts = new int[n];
//        char prev = num.charAt(0);
//        chars[0] = num.charAt(0);
//        counts[0]++;
//        int index = 0;
//        for (int i = 1; i < num.length(); i++) {
//            char number = num.charAt(i);
//            if (number != prev) chars[++index] = number;
//            counts[index]++;
//            prev = number;
//        }
//
//        StringBuilder result = new StringBuilder();
//        for (int i = 0; i < n; i++) {
//            if (counts[i] == 0) break;
//            result.append(counts[i]).append(chars[i]);
//        }
//        return result;
//    }


//    public String countAndSay(int n) {
//        String result = "1";
//        for (int i = 1; i < n; i++) {
//            result = makeString(result);
//        }
//        return result;
//    }
//
//    private String makeString(String num) {
//        char[] chars = new char[4465];
//        int[] counts = new int[4465];
//        char prev = num.charAt(0);
//        chars[0] = num.charAt(0);
//        counts[0]++;
//        int index = 0;
//        for (int i = 1; i < num.length(); i++) {
//            char number = num.charAt(i);
//            if (number != prev) chars[++index] = number;
//            counts[index]++;
//            prev = number;
//        }
//
//        StringBuilder result = new StringBuilder();
//        for (int i = 0; i < 4465; i++) {
//            if (counts[i] == 0) break;
//            result.append(counts[i]).append(chars[i]);
//        }
//        return result.toString();
//    }

//    public String countAndSay(int n) {
//        String result = String.valueOf(1);
//        for (int i = 1; i < n; i++) {
//            result = say(count(result));
//        }
//        return result;
//    }
//
//    private List<int[]> count(String num) {
//        List<int[]> list = new ArrayList<>();
//        int prev = Integer.parseInt(String.valueOf(num.charAt(0)));
//        list.add(new int[]{prev, 1});
//        for (int i = 1; i < num.length(); i++) {
//            int number = Integer.parseInt(String.valueOf(num.charAt(i)));
//            if (number == prev) list.get(list.size() - 1)[1]++;
//            else {
//                list.add(new int[]{number, 1});
//            }
//            prev = number;
//        }
//        return list;
//    }
//
//    private String say(List<int[]> list) {
//        StringBuilder num = new StringBuilder();
//        for (int[] arr : list)
//            num.append(arr[1]).append(arr[0]);
//        return num.toString();
//    }

    // from walkccc.me
    public String countAndSay2(int n) {
        StringBuilder sb = new StringBuilder("1");

        while (--n > 0) {
            StringBuilder next = new StringBuilder();
            for (int i = 0; i < sb.length(); ++i) {
                int count = 1;
                while (i + 1 < sb.length() && sb.charAt(i) == sb.charAt(i + 1)) {
                    ++count;
                    ++i;
                }
                next.append(count).append(sb.charAt(i));
            }
            sb = next;
        }

        return sb.toString();
    }

}
