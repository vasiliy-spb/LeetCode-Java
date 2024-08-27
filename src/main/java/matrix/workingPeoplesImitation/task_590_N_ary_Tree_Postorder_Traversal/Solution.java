package matrix.workingPeoplesImitation.task_590_N_ary_Tree_Postorder_Traversal;

import matrix.workingPeoplesImitation.tree_helper.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

// my solution
public class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
//        recursiveTraverse(root, ans);
        iterateTraverse(root, ans);
        return ans;
    }
    private void recursiveTraverse(Node root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        if (root.children != null) {
            for (Node node : root.children) {
                recursiveTraverse(node, ans);
            }
        }
        ans.add(root.val);
    }
    private void iterateTraverse(Node root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            Node current = stack.pop();
            ans.add(current.val);
            if (current.children != null) {
                for (int i = 0; i < current.children.size(); i++) {
                    stack.push(current.children.get(i));
                }
            }
        }
        Collections.reverse(ans);
    }
}
