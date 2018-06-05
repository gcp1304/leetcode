package com.chandra.problems;

import com.chandra.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 257. Binary Tree Paths
 *
 * Given a binary tree, return all root-to-leaf paths.
 *
 * For example, given the following binary tree:
 *          1
 *        /   \
 *       2     3
 *        \
 *         5
 *
 * All root-to-leaf paths are:
 * ["1->2->5", "1->3"]
 */
public class Problem_257 {

    // Dfs Solution
    public static class Solution1 {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> paths = new ArrayList<>();
            if (root == null) return paths;

            dfs(root, paths, "");
            return paths;

        }

        private void dfs(TreeNode node, List<String> paths, String path) {
            if (node.left == null && node.right == null) {
                paths.add(path + node.val);
                return;
            }

            path += node.val + "->";
            if (node.left != null) {
                dfs(node.left, paths, path);
            }

            if (node.right != null) {
                dfs(node.right, paths, path);
            }
        }
    }

    public static class Solution2 {
        // Recursive

        public List<String> binaryTreePaths(TreeNode root) {
            List<String> paths = new LinkedList<>();

            if (root == null) return paths;

            if (root.left == null && root.right == null) {
                paths.add(root.val + "");
                return paths;
            }

            for (String path : binaryTreePaths(root.left)) {
                paths.add(root.val + "->" + path);
            }

            for (String path : binaryTreePaths(root.right)) {
                paths.add(root.val + "->" + path);
            }

            return paths;
        }
    }
}