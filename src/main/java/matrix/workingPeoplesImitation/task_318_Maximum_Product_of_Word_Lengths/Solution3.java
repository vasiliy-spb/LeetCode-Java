package matrix.workingPeoplesImitation.task_318_Maximum_Product_of_Word_Lengths;

// from leetcode code sample (1)
public class Solution3 {
    public int maxProduct(String[] words) {
        int[] arr = new int[words.length];
        int k = 0;
        for (String s : words) {
            int x = 0;
            for (int i = 0; i < s.length(); i++) {
                x |= (1 << (s.charAt(i) - 'a'));
            }
            arr[k++] = x;
        }
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((arr[i] & arr[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}
