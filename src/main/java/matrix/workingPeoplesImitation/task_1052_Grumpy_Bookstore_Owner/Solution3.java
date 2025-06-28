package matrix.workingPeoplesImitation.task_1052_Grumpy_Bookstore_Owner;

// from Ahlawat Abhishek (https://github.com/AhlawatAbhishek/MayurProgrammingClub/blob/main/LeetCode%20solutions/1052.%20Grumpy%20Bookstore%20Owner)
public class Solution3 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int left = 0, right = 0;
        long disSatSum = 0, maxDisSatSum = 0, totalHappySum = 0;
        int size = customers.length;
        while(left <= size - minutes && right < size){
            int custNum = customers[right];
            boolean isGrumpy = grumpy[right] == 1;
            if(!isGrumpy){
                totalHappySum += custNum;
            }else{
                disSatSum += custNum;
            }
            if(right - left + 1 == minutes){
                maxDisSatSum = Math.max(maxDisSatSum, disSatSum);
                disSatSum += ((grumpy[left] == 1) ? (-1 * customers[left]) : 0);
                left++;
            }
            right++;
        }
        return (int)(totalHappySum + maxDisSatSum);
    }
}
