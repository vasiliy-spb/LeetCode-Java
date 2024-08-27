package matrix.workingPeoplesImitation.task_1901_Find_a_Peak_Element_II;

// from leetcode code sample (3)
public class Solution6 {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat[0].length;
        int n = mat.length;
        int low = 0;
        int high =m-1;


        while (low<=high){
            int mid = (low+high)/2;
            int findIndex = findMaxIndex(mat,mid,n,m);
            int left, right;

            if (mid - 1 >= 0) {
                left = mat[findIndex][mid - 1];
            } else {
                left = -1;
            }

            if (mid + 1 < m) {
                right = mat[findIndex][mid + 1];
            } else {
                right = -1;
            }
            if (mat[findIndex][mid] > left && mat[findIndex][mid] > right) {

                return new int[] {findIndex, mid};
            } else if (mat[findIndex][mid] < left) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return new int[] { -1, -1};
    }



    private int findMaxIndex(int[][] mat, int mid, int n, int m) {
        int maxElement = -1;
        int maxIndex = -1;

        for(int i = 0;i<n;i++){
            if(mat[i][mid]>maxElement){
                maxElement = mat[i][mid];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}

