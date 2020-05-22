package com.kangyonggan.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意:你可以假设树中没有重复的元素。
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 *
 * @author kyg
 */
public class _0105Solution {

    Map<Integer, Integer> inmap;

    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode treeNode = new _0105Solution().buildTree(preorder, inorder);
        System.out.println(treeNode);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inmap = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            inmap.put(inorder[i], i);
        }

        return buildTree(preorder, inorder, 0, preorder.length, 0, preorder.length);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft >= preRight) {
            return null;
        }

        // 根节点在中序遍历的下标
        int rootIndex = inmap.get(preorder[preLeft]);

        TreeNode treeNode = new TreeNode(preorder[preLeft]);
        treeNode.left = buildTree(preorder, inorder, preLeft + 1, preLeft + 1 + rootIndex - inLeft, inLeft, rootIndex);
        treeNode.right = buildTree(preorder, inorder, preLeft + 1 + rootIndex - inLeft, preRight, inLeft + 1 + rootIndex - inLeft, inRight);

        return treeNode;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
