package main.java.leetcode.algorithms.easy.problems_101_200;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * Note: A leaf is a node with no children.
 *
 * Example:
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        return traverse(root, sum, 0);
    }

    public boolean traverse(TreeNode node, int sum, int curTotal) {
        if(node == null) {
            return false;
        }

        curTotal += node.val;

        /**
         * if current total = sum, and node is a leaf node
         */
        if(sum == curTotal && (node.left == null && node.right == null)) {
            return true;
        }

        boolean left = traverse(node.left, sum, curTotal);
        boolean right = traverse(node.right, sum, curTotal);

        return (left || right);
    }

    /**
     * Definition for a binary tree node.
     */
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
