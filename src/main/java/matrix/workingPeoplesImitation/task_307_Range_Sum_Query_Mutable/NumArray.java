package matrix.workingPeoplesImitation.task_307_Range_Sum_Query_Mutable;

// my solution
public class NumArray {
    private final int[] tree;
    private final int n;

    public NumArray(int[] nums) {
        this.n = nextPowerOfTwo(nums.length);
        this.tree = new int[2 * n];
        initTree(nums, n);
    }

    private void initTree(int[] nums, int n) {
        for (int i = n; i - n < nums.length; i++) {
            tree[i] = nums[i - n];
        }
        for (int i = n - 1; i > 0; i--) {
            tree[i] = tree[2 * i] + tree[2 * i + 1];
        }
    }

    private int nextPowerOfTwo(int n) {
        int power = 1;
        while (power < n) {
            power <<= 1;
        }
        return power;
    }

    public void update(int index, int val) {
        index += n;
        int diff = tree[index] - val;
        tree[index] = val;
        updateParent(index / 2, diff);
    }

    private void updateParent(int index, int diff) {
        if (index == 0) {
            return;
        }
        tree[index] -= diff;
        updateParent(index / 2, diff);
    }

    public int sumRange(int left, int right) {
        left += n;
        right += n;
        return getSum(left, right);
    }

    private int getSum(int left, int right) {
        if (left > right) {
            return 0;
        }
        if (left == right) {
            return tree[left];
        }
        int sum = 0;
        if (left % 2 != 0) {
            sum += tree[left];
            left++;
        }
        if (right % 2 == 0) {
            sum += tree[right];
            right--;
        }
        return sum + getSum(left / 2, right / 2);
    }
}
