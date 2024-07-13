package matrix.workingPeoplesImitation.task_1717_Maximum_Score_From_Removing_Substrings;

import java.util.Stack;

public class Solution {

    // my solution
    public int maximumGain(String s, int x, int y) {
        StringBuilder str = new StringBuilder(s);
        int score = 0;
        if (x > y) {
            int i = str.indexOf("ab");
            while (i >= 0) {
                str.deleteCharAt(i);
                str.deleteCharAt(i);
                score += x;
                i = str.indexOf("ab", i - 1);
            }
            i = str.indexOf("ba");
            while (i >= 0) {
                str.deleteCharAt(i);
                str.deleteCharAt(i);
                score += y;
                i = str.indexOf("ba", i - 1);
            }
        } else {
            int i = str.indexOf("ba");
            while (i >= 0) {
                str.deleteCharAt(i);
                str.deleteCharAt(i);
                score += y;
                i = str.indexOf("ba", i - 1);
            }
            i = str.indexOf("ab");
            while (i >= 0) {
                str.deleteCharAt(i);
                str.deleteCharAt(i);
                score += x;
                i = str.indexOf("ab", i - 1);
            }
        }
        return score;
    }

    // from leetcode editorial (Approach 1: Greedy Way (Stack))
    public int maximumGain2(String s, int x, int y) {
        int totalScore = 0;
        String highPriorityPair = x > y ? "ab" : "ba";
        String lowPriorityPair = highPriorityPair.equals("ab") ? "ba" : "ab";

        // First pass: remove high priority pair
        String stringAfterFirstPass = removeSubstring(s, highPriorityPair);
        int removedPairsCount =
                (s.length() - stringAfterFirstPass.length()) / 2;

        // Calculate score from first pass
        totalScore += removedPairsCount * Math.max(x, y);

        // Second pass: remove low priority pair
        String stringAfterSecondPass = removeSubstring(
                stringAfterFirstPass,
                lowPriorityPair
        );
        removedPairsCount = (stringAfterFirstPass.length() -
                stringAfterSecondPass.length()) /
                2;

        // Calculate score from second pass
        totalScore += removedPairsCount * Math.min(x, y);

        return totalScore;
    }

    private String removeSubstring(String input, String targetPair) {
        Stack<Character> charStack = new Stack<>();

        // Iterate through each character in the input string
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            // Check if current character forms the target pair with the top of the stack
            if (
                    currentChar == targetPair.charAt(1) &&
                            !charStack.isEmpty() &&
                            charStack.peek() == targetPair.charAt(0)
            ) {
                charStack.pop(); // Remove the matching character from the stack
            } else {
                charStack.push(currentChar);
            }
        }

        // Reconstruct the remaining string after removing target pairs
        StringBuilder remainingChars = new StringBuilder();
        while (!charStack.isEmpty()) {
            remainingChars.append(charStack.pop());
        }
        return remainingChars.reverse().toString();
    }

    // from leetcode editorial (Approach 2: Greedy Way (Without Stack))
    public int maximumGain3(String s, int x, int y) {
        StringBuilder text = new StringBuilder(s);
        int totalPoints = 0;

        if (x > y) {
            // Remove "ab" first (higher points), then "ba"
            totalPoints += removeSubstring(text, "ab", x);
            totalPoints += removeSubstring(text, "ba", y);
        } else {
            // Remove "ba" first (higher or equal points), then "ab"
            totalPoints += removeSubstring(text, "ba", y);
            totalPoints += removeSubstring(text, "ab", x);
        }

        return totalPoints;
    }

    private int removeSubstring(
            StringBuilder inputString,
            String targetSubstring,
            int pointsPerRemoval
    ) {
        int totalPoints = 0;
        int writeIndex = 0;

        // Iterate through the string
        for (int readIndex = 0; readIndex < inputString.length(); readIndex++) {
            // Add the current character
            inputString.setCharAt(writeIndex++, inputString.charAt(readIndex));

            // Check if we've written at least two characters and
            // they match the target substring
            if (
                    writeIndex > 1 &&
                            inputString.charAt(writeIndex - 2) ==
                                    targetSubstring.charAt(0) &&
                            inputString.charAt(writeIndex - 1) == targetSubstring.charAt(1)
            ) {
                writeIndex -= 2; // Move write index back to remove the match
                totalPoints += pointsPerRemoval;
            }
        }

        // Trim the StringBuilder to remove any leftover characters
        inputString.setLength(writeIndex);

        return totalPoints;
    }

    // from leetcode editorial (Approach 3: Greedy Way (Counting))
    public int maximumGain4(String s, int x, int y) {
        // Ensure "ab" always has higher points than "ba"
        if (x < y) {
            // Swap points
            int temp = x;
            x = y;
            y = temp;
            // Reverse the string to maintain logic
            s = new StringBuilder(s).reverse().toString();
        }

        int aCount = 0, bCount = 0, totalPoints = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (currentChar == 'a') {
                aCount++;
            } else if (currentChar == 'b') {
                if (aCount > 0) {
                    // Can form "ab", remove it and add points
                    aCount--;
                    totalPoints += x;
                } else {
                    // Can't form "ab", keep 'b' for potential future "ba"
                    bCount++;
                }
            } else {
                // Non 'a' or 'b' character encountered
                // Calculate points for any remaining "ba" pairs
                totalPoints += Math.min(bCount, aCount) * y;
                // Reset counters for next segment
                aCount = bCount = 0;
            }
        }

        // Calculate points for any remaining "ba" pairs at the end
        totalPoints += Math.min(bCount, aCount) * y;

        return totalPoints;
    }

    // from walkccc.me
    public int maximumGain5(String s, int x, int y) {
        // The assumption that gain("ab") > gain("ba") while removing "ba" first is
        // optimal is contradicted. Only "b(ab)a" satisfies the condition of
        // preventing two "ba" removals, but after removing "ab", we can still
        // remove one "ba", resulting in a higher gain. Thus, removing "ba" first is
        // not optimal.
        return x > y ? gain(s, "ab", x, "ba", y) : gain(s, "ba", y, "ab", x);
    }

    // Returns the points gained by first removing sub1 ("ab" | "ba") from s with
    // point1, then removing sub2 ("ab" | "ba") from s with point2.
    private int gain(final String s, final String sub1, int point1, final String sub2, int point2) {
        int points = 0;
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        // Remove "sub1" from s with point1 gain.
        for (final char c : s.toCharArray())
            if (!stack1.isEmpty() && stack1.peek() == sub1.charAt(0) && c == sub1.charAt(1)) {
                stack1.pop();
                points += point1;
            } else {
                stack1.push(c);
            }

        // Remove "sub2" from s with point2 gain.
        for (final char c : stack1)
            if (!stack2.isEmpty() && stack2.peek() == sub2.charAt(0) && c == sub2.charAt(1)) {
                stack2.pop();
                points += point2;
            } else {
                stack2.push(c);
            }

        return points;
    }

}
