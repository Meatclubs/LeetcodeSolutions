package main.java.leetcode.challenge.easy.problems_101_200;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * But the following [1,2,2,null,3,null,3] is not:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * Follow up: Solve it both recursively and iteratively.
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }

        /**
         * recursive solution
         */
        return checkLeftAndRight(root.right, root.left);
    }


    private boolean checkLeftAndRight(TreeNode right, TreeNode left) {
        if(left == null && right == null) {
            return true;
        }
        if((left != null && right == null) || (left == null && right != null)) {
            return false;
        }
        if(left.val != right.val) {
            return false;
        }

        boolean outerMatches = checkLeftAndRight(right.right, left.left);
        boolean innerMatches = checkLeftAndRight(right.left, left.right);

        return outerMatches && innerMatches;
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
