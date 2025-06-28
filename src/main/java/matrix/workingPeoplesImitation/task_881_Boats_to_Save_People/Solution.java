package matrix.workingPeoplesImitation.task_881_Boats_to_Save_People;

import java.util.Arrays;

public class Solution {

    // my solution
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int count = 0;
        while (left <= right) {
            if (left != right && people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            count++;
        }
        return count;
    }

    // from leetcode code sample
    public int numRescueBoats2(int[] people, int limit) {
        // TC : O(nlogn)
        // SC : O(1)
        // int i = 0;
        // int j = people.length - 1;
        // int ans = 0;
        // Arrays.sort(people);
        // while(i<=j){
        //     if(people[i] + people[j] <= limit){
        //         i++;
        //         ans++;
        //     }else if(people[j] <= limit){
        //         ans++;
        //     }
        //     j--;
        // }
        // return ans;


        //optimized
        // TC: O(n)
        // SC: O(n)

        int[] buckets = new int[limit + 1];
        for(int weight : people ){
            buckets[weight]++;
        }


        int start = 0;
        int end = buckets.length - 1;
        int boats = 0;
        while(start<=end){
            while(start<=end && buckets[start] <= 0 ) start++;
            while(start<=end && buckets[end] <= 0 ) end--;

            if(buckets[start] <=0 && buckets[end] <=0) break;

            boats++;
            if(start + end <= limit){
                buckets[start]--;
            }
            buckets[end]--;
        }
        return boats;
    }

    // from walkccc.me
    public int numRescueBoats3(int[] people, int limit) {
        int ans = 0;

        Arrays.sort(people);

        for (int i = 0, j = people.length - 1; i <= j; ++ans) {
            final int remain = limit - people[j--];
            if (people[i] <= remain)
                ++i;
        }

        return ans;
    }

}
