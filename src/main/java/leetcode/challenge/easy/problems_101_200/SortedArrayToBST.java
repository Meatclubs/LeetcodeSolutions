package main.java.leetcode.challenge.easy.problems_101_200;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 * Given the sorted array: [-10,-3,0,5,9],
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) {
            return null;
        }

        return toBST(nums, null, 0, nums.length-1);
    }

    public TreeNode toBST(int[] nums, TreeNode parent, int start, int end) {
        if(end - start < 1) {
            parent = new TreeNode(nums[start]);
            return parent;
        }

        int mid = (end + start + 1) / 2;

        parent = new TreeNode(nums[mid]);

        if(mid - start > 0) {
            parent.left = toBST(nums, parent.left, start, mid-1);
        }
        if(end - mid > 0) {
            parent.right = toBST(nums, parent.right, mid+1, end);
        }

        return parent;
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
