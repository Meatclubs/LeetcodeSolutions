package main.java.leetcode.algorithms.easy.problems_101_200;

/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * Note: A leaf is a node with no children.
 *
 * Example:
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its depth = 3.
 */
public class MaxDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return traverse(root, 0);
    }

    public int traverse(TreeNode node, int depth) {
        if(node == null) {
            return depth;
        }

        depth++;

        if(node.left == null && node.right == null) {
            return depth;
        }

        int leftDepth = traverse(node.left, depth);
        int rightDepth = traverse(node.right, depth);

        if(depth < leftDepth) {
            depth = leftDepth;
        }
        if(depth < rightDepth) {
            depth = rightDepth;
        }

        return depth;
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
