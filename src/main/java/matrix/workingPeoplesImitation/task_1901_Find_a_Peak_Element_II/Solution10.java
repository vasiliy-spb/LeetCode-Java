package matrix.workingPeoplesImitation.task_1901_Find_a_Peak_Element_II;

// from leetcode code sample (7)
public class Solution10 {
    // function to return the index of thr row having mximum element
    public int findMax(int[][]mat,int m,int mid){
        int max=-1;
        int index=0;
        for(int i=0;i<m;i++){
            if(mat[i][mid]>max){
                max=mat[i][mid];
                index=i;
            }
        }return index;
    }

    public int[] findPeakGrid(int[][] mat) {
        // here first we will find the mid of the low and high of teh first row
        // then we will find the maximum element of the mid element column
        // then we will return the index of the row of the maximu element of the column
        // then we will find the left and right element of the maximum element
        // using int[maxIndex][mid-1]; left element
        // using int[maxIndex][mid+1]; right element
        // if the maximum element is greater than the bot the element then we will return the maximum element else
        // if the left element is greater than the right -> we are in decreasing linear so we will eleminate the right part of the matrix and  we will make high=mid-1;
        // else we will search in the right part of the matrox as we wil be in increasing linear of the matrix and our peak will lie on the right side of the mid element

        int low=0;
        int m= mat.length;
        int n=mat[0].length;

        int high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            int RowMaxElement=findMax(mat,m,mid);// row index of the max element
            int left=mid-1>=0? left=mat[RowMaxElement][mid-1] : -1;
            int right=mid+1<n? right=mat[RowMaxElement][mid+1] : -1;
            if(mat[RowMaxElement][mid]>left&&mat[RowMaxElement][mid]>right){
                int arr[]={RowMaxElement,mid};
                return arr;
            }if(mat[RowMaxElement][mid]<left){
                high=mid-1;
            }else{
                low=mid+1;
            }


        }int noPeak[]={-1,-1};
        return noPeak;

    }
}
