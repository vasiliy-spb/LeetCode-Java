package matrix.workingPeoplesImitation.task_450_Delete_Node_in_a_BST;

import java.util.*;

public class Solution {

    // my solution
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null || (root.left == null && root.right == null && root.val == key)) return null;
        if (root.val == key) {
            return deleteRootNode(root);
        }
        TreeNode parent = findParent(root, key);
        TreeNode deletingNode = findNode(root, key);

        if (deletingNode == null) return root;
        if (parent.left != null && parent.left.val == key) deletingNode = parent.left;
        if (parent.right != null && parent.right.val == key) deletingNode = parent.right;

        if (deletingNode.left == null && deletingNode.right == null) {
            if (parent.left == deletingNode) parent.left = null;
            else parent.right = null;
        } else if (deletingNode.left != null && deletingNode.right != null) {
            deleteNodeWithBothChild(deletingNode);
        } else if (deletingNode.left != null) {
            if (parent.left == deletingNode) parent.left = deletingNode.left;
            else parent.right = deletingNode.left;
        } else {
            if (parent.left == deletingNode) parent.left = deletingNode.right;
            else parent.right = deletingNode.right;
        }
        return root;
    }

    public TreeNode deleteRootNode(TreeNode root) {
        if (root.left == null) root = root.right;
        else if (root.right != null && root.left.right == null) {
            root.left.right = root.right;
            root = root.left;
        } else if (root.right == null) root = root.left;
        else if (root.right.left == null) {
            root.right.left = root.left;
            root = root.right;
        } else {
            deleteNodeWithBothChild(root);
        }
        return root;
    }

    private void deleteNodeWithBothChild(TreeNode deletingNode) {
        TreeNode minNode = findMinNode(deletingNode.right);
        TreeNode parentMinNode = findParent(deletingNode, minNode.val);

        if (minNode.left == null && minNode.right == null) {
            deletingNode.val = minNode.val;
            if (minNode == parentMinNode.left) parentMinNode.left = null;
            else parentMinNode.right = null;
        } else {
            int tempVal = minNode.val;
            deleteNode(deletingNode, minNode.val);
            deletingNode.val = tempVal;
        }
    }

    private TreeNode findParent(TreeNode root, int childValue) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return null;
        if (childValue < root.val) {
            if (root.left.val == childValue) return root;
            else return findParent(root.left, childValue);
        } else {
            if (root.right.val == childValue) return root;
            else return findParent(root.right, childValue);
        }
    }

    private TreeNode findMinNode(TreeNode root) {
        if (root == null) return null;
        int value = root.val + 1;
        TreeNode minNode = null;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current.val < value) {
                minNode = current;
                value = minNode.val;
            }
            if (current.left != null) queue.offer(current.left);
            if (current.right != null) queue.offer(current.right);
        }
        return minNode;
    }

    private TreeNode findNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) return root;
        return key < root.val ? findNode(root.left, key) : findNode(root.right, key);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    // from walkccc.me
    public TreeNode deleteNode1(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.val == key) {
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;
            TreeNode minNode = getMin(root.right);
            root.right = deleteNode1(root.right, minNode.val);
            minNode.left = root.left;
            minNode.right = root.right;
            root = minNode;
        } else if (root.val < key) {
            root.right = deleteNode1(root.right, key);
        } else { // root.val > key
            root.left = deleteNode1(root.left, key);
        }
        return root;
    }

    private TreeNode getMin(TreeNode node) {
        while (node.left != null)
            node = node.left;
        return node;
    }

    // from leetcode solutions
    //
    // Steps:
    //    Recursively find the node that has the same value as the key, while setting the left/right nodes equal to the returned subtree
    //    Once the node is found, have to handle the below 4 cases
    //
    //    node doesn't have left or right - return null
    //    node only has left subtree- return the left subtree
    //    node only has right subtree- return the right subtree
    //    node has both left and right - find the minimum value in the right subtree, set that value to the currently found node, then recursively delete the minimum value in the right subtree
    public TreeNode deleteNode2(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(key < root.val){
            root.left = deleteNode2(root.left, key);
        }else if(key > root.val){
            root.right = deleteNode2(root.right, key);
        }else{
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode2(root.right, root.val);
        }
        return root;
    }

    private TreeNode findMin(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }

    // from comments to previous solution
    // I have a slightly different version, while handling in the event of node being found, instead of calling recursion again I handle it right away, this makes my running time faster
    public TreeNode deleteNode3(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val > key) {
            root.left = deleteNode3(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode3(root.right, key);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            TreeNode rightSmallest = root.right;
            while (rightSmallest.left != null) rightSmallest = rightSmallest.left;
            rightSmallest.left = root.left;
            return root.right;
        }
        return root;
    }

    // from leetcode solutions
    private TreeNode deleteRootNode2(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }
        TreeNode next = root.right;
        TreeNode pre = null;
        for(; next.left != null; pre = next, next = next.left);
        next.left = root.left;
        if(root.right != next) {
            pre.left = next.right;
            next.right = root.right;
        }
        return next;
    }

    public TreeNode deleteNode4(TreeNode root, int key) {
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur != null && cur.val != key) {
            pre = cur;
            if (key < cur.val) {
                cur = cur.left;
            } else if (key > cur.val) {
                cur = cur.right;
            }
        }
        if (pre == null) {
            return deleteRootNode2(cur);
        }
        if (pre.left == cur) {
            pre.left = deleteRootNode2(cur);
        } else {
            pre.right = deleteRootNode2(cur);
        }
        return root;
    }
    // Find the node to be removed and its parent using binary search, and then use deleteRootNode to delete the root node of the subtree and return the new root node. This idea is taken from https://discuss.leetcode.com/topic/67309/an-easy-understanding-o-h-time-o-1-space-java-solution.
    //
    // I'd also like to share my thinking of the other solutions I've seen.
    //
    //    There are many solutions that got high votes using recursive approach, including the ones from the Princeton's Algorithm and Data Structure book. Don't you notice that recursive approach always takes extra space? Why not consider the iterative approach first?
    //    Some solutions swap the values instead of swapping the nodes. In reality, the value of a node could be more complicated than just a single integer, so copying the contents might take much more time than just copying the reference.
    //    As for the case when both children of the node to be deleted are not null, I transplant the successor to replace the node to be deleted, which is a bit harder to implement than just transplant the left subtree of the node to the left child of its successor. The former way is used in many text books too. Why? My guess is that transplanting the successor can keep the height of the tree almost unchanged, while transplanting the whole left subtree could increase the height and thus making the tree more unbalanced.

    // from leetcode solutions
    // If the node is found, delete the node.
    // We need a function deleteRoot to delete the root from a BST.
    //
    //    If root==null, then return null
    //    If root.right==null, then return root.left
    //    If root.right!=null, the the new root of the BST is root.right; And what we should do is to put root.left into this new BST. As all nodes in root.left is smaller than the new tree, we just need to find the left-most node.
    public TreeNode deleteNode5(TreeNode root, int key) {
        if (root==null || root.val==key) return deleteRoot(root);
        TreeNode p=root;

        while (true) { // search the node
            if (key>p.val) {
                if (p.right==null || p.right.val==key) {
                    p.right=deleteRoot(p.right);
                    break;
                }
                p=p.right;
            }
            else {
                if (p.left==null || p.left.val==key) {
                    p.left=deleteRoot(p.left);
                    break;
                }
                p=p.left;
            }
        }
        return root;
    }

    private TreeNode deleteRoot(TreeNode root) {
        if (root==null) return null;
        if (root.right==null) return root.left;
        TreeNode x=root.right; // root.right should be the new root
        while (x.left!=null) x=x.left; // find the left-most node
        x.left=root.left;
        return root.right;
    }



    ////////////////////////////////////////////////////////////////////////////////////////////////

//    public static List<List<Integer>> getLevels(TreeNode root) {
//        List<List<Integer>> levels = new ArrayList<>();
//        if (root == null) {
//            return levels;
//        }
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//
//        while (!queue.isEmpty()) {
//            int levelSize = queue.size();
//            List<Integer> currentLevel = new ArrayList<>(levelSize);
//
//            for (int i = 0; i < levelSize; i++) {
//                TreeNode node = queue.poll();
//                if (node != null) {
//                    currentLevel.add(node.val);
//                    queue.add(node.left);
//                    queue.add(node.right);
//                } else {
//                    currentLevel.add(null);
//                }
//            }
//
//            levels.add(currentLevel);
//            System.out.println(currentLevel);
//        }
//
//        System.out.println();
//        return levels;
//    }

//    public void showTree(TreeNode root) {
//        List<List<Integer>> levels = new ArrayList<>();
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            int levelSize = queue.size();
//            List<Integer> level = new ArrayList<>();
//            for (int i = 0; i < levelSize; i++) {
//                TreeNode current = queue.poll();
////                level.add(current);
//            }
//        }
//    }

    /*
       5
      / \
     3   6
    / \   \
   2   4   7


     */
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