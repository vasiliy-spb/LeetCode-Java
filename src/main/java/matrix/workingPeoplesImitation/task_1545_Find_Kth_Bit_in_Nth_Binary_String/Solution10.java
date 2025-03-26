package matrix.workingPeoplesImitation.task_1545_Find_Kth_Bit_in_Nth_Binary_String;

// from leetcode code sample (4)
public class Solution10 {
    public char findKthBit(int n, int k) {
        int size = (int) Math.pow(2, (double) n) - 1;
        int[] arr = new int[size];
        arr[0] = 0;
        int i = 1;
        int index = 1;
        int mid = 0;
        while (i < n) {

            i += 1;
            int endIndex = (1 << i) - 1;
            index = endIndex / 2;
            //copy all the element from 0 to index-1 in index+1 to end
            int t = index + 1;
            for (int j = 0; j <= index - 1; j++) {
                arr[t + j] = arr[j];
            }
            arr[index] = 1;
            //invert the  values of index+1 to end
            for (int j = index + 1; j < endIndex; j++) {
                arr[j] = arr[j] == 0 ? 1 : 0;
            }
            //reverse the value index+1 to end
            int st = index + 1;
            int end = endIndex - 1;
            while (st < end) {
                int temp = arr[st];
                arr[st] = arr[end];
                arr[end] = temp;
                st++;
                end--;
            }
        }
        return arr[k - 1] == 0 ? '0' : '1';
    }
}
