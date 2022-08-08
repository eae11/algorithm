package org.javaboy.tree.binaryTree;

import java.util.*;

public class BinaryTreeTest {
    public static void main(String[] args) {
       /* TreeNode<Integer> root = new TreeNode<>(23);
        TreeNode<Integer> node1 = new TreeNode<>(34);
        TreeNode<Integer> node2 = new TreeNode<>(21);
        TreeNode<Integer> node3 = new TreeNode<>(99);
        TreeNode<Integer> node4 = new TreeNode<>(77);
        TreeNode<Integer> node5 = new TreeNode<>(90);
        TreeNode<Integer> node6 = new TreeNode<>(45);
        TreeNode<Integer> node7 = new TreeNode<>(60);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node3.left = node4;
        node3.right = node5;
        node2.left = node6;
        node2.right = node7;*/

        TreeNode<Integer> root = new TreeNode<>(1);
        TreeNode<Integer> r2 = new TreeNode<>(2);
        root.right = r2;
        TreeNode<Integer> r3 = new TreeNode<>(3);
        r2.left = r3;
        List<Integer> integers = preOrderR(root);
        System.out.println(integers);
    }

    // 前序遍历(递归)
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public static List<Integer> preOrder(TreeNode<Integer> root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode<Integer>> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode<Integer> curr = stack.pop();
            res.add(curr.data);
            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
        }
        return res;
    }

    // 前序遍历(递归)  根左右
    public static List<Integer> preOrderR(TreeNode<Integer> root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        preOrderR(root, res);
        return res;
    }

    public static void preOrderR(TreeNode<Integer> node, List<Integer> res) {
        if (node == null) {
            return;
        }
        res.add(node.data);
        preOrderR(node.left, res);
        preOrderR(node.right, res);
    }

    // 中序遍历 左根右
    // 时间复杂度：O(n), n 表示二叉树节点个数
    // 空间复杂度：O(n)
    public static List<Integer> inOrder(TreeNode<Integer> root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode<Integer>> stack = new ArrayDeque<>();
        TreeNode<Integer> curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode<Integer> node = stack.pop();
            res.add(node.data);
            curr = node.right;
        }
        return res;
    }

    // 中序遍历(递归) 左根右
    public static List<Integer> inOrderR(TreeNode<Integer> root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        inOrderR(root, res);
        return res;
    }

    public static void inOrderR(TreeNode<Integer> node, List<Integer> res) {
        if (node == null) {
            return;
        }
        inOrderR(node.left, res);
        res.add(node.data);
        inOrderR(node.right, res);

    }

    // 后序遍历 左右根
    // 时间复杂度：O(n), n 表示二叉树节点个数
    // 空间复杂度：O(n)
    public static List<Integer> postOrder(TreeNode<Integer> root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode<Integer>> stack = new ArrayDeque<>();
        stack.push(root);
        while (stack.isEmpty()) {
            TreeNode<Integer> curr = stack.pop();
            res.addFirst(curr.data);
            if (curr.left != null) {
                stack.push(curr.left);
            }
            if (curr.right != null) {
                stack.push(curr.right);
            }
        }
        return res;
    }

    // 后序遍历(递归) 左右根
    public static List<Integer> postOrderR(TreeNode<Integer> root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        postOrderR(root, res);
        return res;
    }

    public static void postOrderR(TreeNode<Integer> node, List<Integer> res) {
        if (node == null) {
            return;
        }
        postOrderR(node.left, res);
        postOrderR(node.right, res);
        res.add(node.data);
    }

    // 层序遍历
    // 时间复杂度：O(n), n 表示二叉树节点个数
    // 空间复杂度：O(n)
    public static List<Integer> levelOrder(TreeNode<Integer> root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        ArrayDeque<TreeNode<Integer>> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 每轮循环遍历处理一个节点
            TreeNode<Integer> curr = queue.poll();
            res.add(curr.data);
            if (curr.left != null) {
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
            }

        }
        return res;
    }

    public static List<Integer> levelOrder2(TreeNode<Integer> root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        ArrayDeque<TreeNode<Integer>> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 每轮循环遍历处理一层的节点
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode<Integer> curr = queue.poll();
                res.add(curr.data);
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }

        }
        return res;
    }
}