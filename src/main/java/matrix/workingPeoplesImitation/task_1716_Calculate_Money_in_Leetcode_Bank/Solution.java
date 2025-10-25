package matrix.workingPeoplesImitation.task_1716_Calculate_Money_in_Leetcode_Bank;

// my solution
public class Solution {
    public int totalMoney(int n) {
        int weeklyMoney = 28;
        int dayPerWeek = 7;

        int countWeeks = n / dayPerWeek;
        int ans = weeklyMoney * countWeeks;

        int arithmeticSum = (countWeeks - 1) * countWeeks / 2;
        ans += arithmeticSum * dayPerWeek;

        int countDays = n % dayPerWeek;
        for (int i = 1; i <= countDays; i++) {
            int add = i + countWeeks;
            ans += add;
        }
        return ans;
    }
}
