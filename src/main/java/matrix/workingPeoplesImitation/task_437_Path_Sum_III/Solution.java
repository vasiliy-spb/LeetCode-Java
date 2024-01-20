package matrix.workingPeoplesImitation.task_437_Path_Sum_III;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Solution {

    // my solution
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        int pathCount = 0;
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        parents.put(root, null);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current.left != null) {
                queue.offer(current.left);
                parents.put(current.left, current);
            }
            if (current.right != null) {
                queue.offer(current.right);
                parents.put(current.right, current);
            }
            TreeNode pathNode = current;
            long sum = 0;
            while (pathNode != null) {
                sum += pathNode.val;
                if (sum == targetSum) {
                    pathCount++;
                }
                pathNode = parents.get(pathNode);
            }
        }
        return pathCount;
    }

    // from walkccc.me
    // recursive DFS
    public int pathSum2(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return dfs(root, sum) + pathSum2(root.left, sum) + pathSum2(root.right, sum);
    }

    private int dfs(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return (sum == root.val ? 1 : 0) +
                dfs(root.left, sum - root.val) +
                dfs(root.right, sum - root.val);
    }

    // from leetcode solutions (from: tankztc)
    //
    //      So the idea is similar as Two sum, using HashMap to store
    // ( key : the prefix sum, value : how many ways get to this prefix sum) ,
    // and whenever reach a node, we check if prefix sum - target exists in hashmap or not,
    // if it does, we added up the ways of prefix sum - target into res.
    //      For instance : in one path we have 1,2,-1,-1,2, then the prefix sum will be: 1, 3, 2, 1, 3,
    // let's say we want to find target sum is 2, then we will have{2}, {1,2,-1}, {2,-1,-1,2} and {2}ways.
    //      I used global variable count, but obviously we can avoid global variable
    // by passing the count from bottom up. The time complexity is O(n).
    // This is my first post in discuss, open to any improvement or criticism. :)
    public int pathSum3_1(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap();
        preSum.put(0,1);
        helper3_1(root, 0, sum, preSum);
        return count;
    }
    int count = 0;
    public void helper3_1(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) {
            return;
        }

        currSum += root.val;

        if (preSum.containsKey(currSum - target)) {
            count += preSum.get(currSum - target);
        }

        if (!preSum.containsKey(currSum)) {
            preSum.put(currSum, 1);
        } else {
            preSum.put(currSum, preSum.get(currSum)+1);
        }

        helper3_1(root.left, currSum, target, preSum);
        helper3_1(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);
    }

    // Thanks for your advice, @StefanPochmann . Here is the modified version, concise and shorter:
    public int pathSum3_2(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap();
        preSum.put(0,1);
        return helper3_2(root, 0, sum, preSum);
    }

    public int helper3_2(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) {
            return 0;
        }

        currSum += root.val;
        int res = preSum.getOrDefault(currSum - target, 0);
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);

        res += helper3_2(root.left, currSum, target, preSum) + helper3_2(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);
        return res;
    }

    // from leetcode solutions (from: star1993)
    public int pathSum4(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  //Default sum = 0 has one count
        return backtrack(root, 0, sum, map);
    }
    //BackTrack one pass
    public int backtrack(TreeNode root, int sum, int target, Map<Integer, Integer> map){
        if(root == null)
            return 0;
        sum += root.val;
        int res = map.getOrDefault(sum - target, 0);    //See if there is a subarray sum equals to target
        map.put(sum, map.getOrDefault(sum, 0)+1);
        //Extend to left and right child
        res += backtrack(root.left, sum, target, map) + backtrack(root.right, sum, target, map);
        map.put(sum, map.get(sum)-1);   //Remove the current node so it wont affect other path
        return res;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
