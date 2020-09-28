package main.java.leetcode.algorithms.easy.problems_201_300;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 * Note: A leaf is a node with no children.
 *
 * Example:
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }

        return traverse(root, "");
    }

    public List<String> traverse(TreeNode node, String path) {
        List<String> paths = new ArrayList<>();

        /**
         * Using stringbuilder to build strings is faster and uses less memory compared to string concatenation.
         */
        StringBuilder sb = new StringBuilder();

        /**
         * If path is empty string, then we are processing root node.. so no need to append preceding arrow.
         */
        if(path.equals("")) {
            sb.append(path);
            sb.append(String.valueOf(node.val));
        } else {
            sb.append(path);
            sb.append("->");
            sb.append(String.valueOf(node.val));
        }

        path = sb.toString();

        if(node.left == null && node.right == null) {
            paths.add(path);
            return paths;
        }

        if(node.left != null) {
            paths.addAll(traverse(node.left, path));
        }

        if(node.right != null) {
            paths.addAll(traverse(node.right, path));
        }

        return paths;
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
