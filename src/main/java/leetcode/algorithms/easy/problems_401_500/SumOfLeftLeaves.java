package main.java.leetcode.algorithms.easy.problems_401_500;

/**
 * Find the sum of all left leaves in a given binary tree.
 *
 * Example:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        return traverse(root, false);
    }

    public int traverse(TreeNode node, boolean isLeft) {
        if(node == null) {
            return 0;
        }

        /**
         * if node is a leaf node, then check if it's the left child since we only want to sum up left leaf node values
         * if it's a right leaf node, return 0 so it wont impact the total sum.
         */
        if(node.left == null && node.right == null) {
            if(isLeft) {
                return node.val;
            } else {
                return 0;
            }
        }

        int leftSum = traverse(node.left, true);
        int rightSum = traverse(node.right, false);

        return leftSum + rightSum;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
