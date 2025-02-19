package matrix.workingPeoplesImitation.task_2375_Construct_Smallest_Number_From_DI_String;

// from leetcode editorial (Approach 5: Greedy Approach with Sliding Window Reversal)
public class Solution6 {

    public String smallestNumber(String pattern) {
        StringBuilder result = new StringBuilder();

        // Iterate through the pattern and build the result
        for (
                int currentIndex = 0, previousIndex = 0;
                currentIndex <= pattern.length();
                ++currentIndex
        ) {
            result.append(1 + currentIndex);

            // Reverse the substring starting from previousIndex when necessary
            if (
                    currentIndex == pattern.length() ||
                            pattern.charAt(currentIndex) == 'I'
            ) {
                StringBuilder temp = new StringBuilder();
                temp
                        .append(result.substring(0, previousIndex))
                        .append(
                                new StringBuilder(
                                        result.substring(previousIndex)
                                ).reverse()
                        );
                result = temp;
                previousIndex = currentIndex + 1;
            }
        }

        // Return the final result as a string
        return result.toString();
    }
}
