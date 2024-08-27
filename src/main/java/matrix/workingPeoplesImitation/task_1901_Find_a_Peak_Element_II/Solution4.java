package matrix.workingPeoplesImitation.task_1901_Find_a_Peak_Element_II;

// from leetcode code sample (1)
public class Solution4 {
    public int maxincol(int arr[]) {
        int ans = 0; // Initialize with the first index
        for (int i = 1; i < arr.length; i++) { // Start from the second element
            if (arr[i] > arr[ans]) {
                ans = i;
            }
        }
        return ans;
    }

    public int[] findPeakGrid(int[][] mat) {
        int start = 0;
        int end = mat.length - 1;
        int ans[] = new int[2];

        while (start <= end) {
            int mid = (start + end) / 2;
            int maxi = maxincol(mat[mid]);

            int up = (mid > 0) ? mat[mid - 1][maxi] : Integer.MIN_VALUE;
            int down = (mid < mat.length - 1) ? mat[mid + 1][maxi] : Integer.MIN_VALUE;

            if (mat[mid][maxi] > up && mat[mid][maxi] > down) {
                ans[0] = mid;
                ans[1] = maxi;
                return ans;
            } else if (mat[mid][maxi] < up) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}

