package matrix.workingPeoplesImitation.task_2982_Find_Longest_Special_Substring_That_Occurs_Thrice_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// my solution
public class Solution {
    public int maximumLength(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();
        char prev = s.charAt(0);
        for (int left = 0, right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (ch != prev) {
                map.computeIfAbsent(prev, list -> new ArrayList<>()).add(right - left);
                left = right;
            }
            if (right == s.length() - 1) {
                map.computeIfAbsent(ch, list -> new ArrayList<>()).add(right - left + 1);
            }
            prev = ch;
        }
        int maxLength = -1;
        for (char key : map.keySet()) {
            List<Integer> list = map.get(key);
            if (list.size() == 1) {
                int length = list.get(0);
                if (length < 3) {
                    continue;
                }
                maxLength = Math.max(maxLength, length - 2);
            } else {
                int max = 0;
                int secondMax = 0;
                int thirdMax = 0;
                for (int l : list) {
                    if (l > max) {
                        thirdMax = secondMax;
                        secondMax = max;
                        max = l;
                    } else if (l > secondMax) {
                        thirdMax = secondMax;
                        secondMax = l;
                    } else if (l > thirdMax) {
                        thirdMax = l;
                    }
                }
                if (max > 2) {
                    if (list.size() > 2) {
                        int current;
                        if (max == thirdMax) {
                            current = max;
                        } else if (max == secondMax) {
                            current = Math.max(thirdMax, max - 1);
                        } else {
                            current = Math.max(max - 2, secondMax);
                        }
                        maxLength = Math.max(maxLength, current);
                    } else {
                        if (max == secondMax) {
                            maxLength = Math.max(maxLength, max - 1);
                        } else {
                            maxLength = Math.max(maxLength, Math.max(max - 2, Math.min(max - 1, secondMax)));
                        }
                    }
                } else if (max == 1) {
                    if (list.size() < 3) {
                        continue;
                    }
                    maxLength = Math.max(maxLength, max);
                } else {
                    if (list.size() > 2) {
                        maxLength = Math.max(maxLength, thirdMax);
                    } else {
                        maxLength = Math.max(maxLength, secondMax);
                    }
                }
            }
        }
        return maxLength;
    }
}
