package matrix.workingPeoplesImitation.task_382_Linked_List_Random_Node;

import matrix.workingPeoplesImitation.linked_list_helper.ListNode;

import java.util.Random;

// from leetcode code sample (2)
public class Solution4 {
    /**
     * Reservoir Sampling Algorithm
     * Step 1: Initialization
     * Fill the reservoir with the first k elements from the stream.
     * <p>
     * Step 2: Iteration
     * For each subsequent element (from the k+1th element onward):
     * Generate a random number j between 1 and the current index i (the position of the current element in the stream).
     * If j is less than or equal to k, replace the j-th element in the reservoir with this new element.
     */

    // this question k = 1
    private Random rand;
    private ListNode head;

    public Solution4(ListNode head) {
        this.head = head;
        rand = new Random();
    }

    public int getRandom() {
        ListNode p = head;
        int i = 0, res = p == null ? -1 : head.val;

        while (p != null) {
            i++;
            // 生成一个 [0, i) 之间的整数
            // 这个整数等于 0 的概率就是 1/i
            int r = rand.nextInt(i);
            if (0 == r) {
                res = p.val;
            }
            p = p.next;
        }
        // 第 i 个元素被选择的概率是 1/i，在第 i+1 次不被替换的概率是 1 - 1/(i+1)，在第 i+2 次不被替换的概率是 1 - 1/(i+2)，以此类推，相乘的结果是第 i 个元素最终被选中的概率，也就是 1/n
        return res;
    }
}
/*
学会了洗牌算法，扫雷游戏的随机初始化问题就解决了。不过别忘了，洗牌算法只是一个取巧方案，我们还是得面对「在若干元素中随机选择 k 个元素」这个终极问题。
    要知道洗牌算法能够生效的前提是你使用数组这种数据结构，如果让你在一条链表中随机选择 k 个元素，肯定不能再用洗牌算法来蒙混过关了。

    Reservoir sampling is an algorithm for randomly selecting a sample of k items from a population of unknown size n (where n may be growing, or streaming data). The key advantage of this method is that it allows you to sample from data without knowing the full size of the dataset ahead of time, making it ideal for streaming scenarios.

    // 返回链表中 k 个随机节点的值
    int[] getRandom(ListNode head, int k) {
        Random r = new Random();
        int[] res = new int[k];
        ListNode p = head;

        // 前 k 个元素先默认选上
        for (int i = 0; i < k && p != null; i++) {
            res[i] = p.val;
            p = p.next;
        }

        int i = k;
        // while 循环遍历链表
        while (p != null) {
            i++;
            // 生成一个 [0, i) 之间的整数
            int j = r.nextInt(i);
            // 这个整数小于 k 的概率就是 k/i
            if (j < k) {
                res[j] = p.val;
            }
            p = p.next;
        }
        return res;
    }
 */
