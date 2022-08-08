package leetcode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;


//树的最大深度
public class Test18 {
    public static void main(String[] args) {

    }

    //递归 dfs  (深度优先)
    public int maxDepth(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int maxDepth = 0;
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        maxDepth = Math.max(leftMax, rightMax) + 1;
        return maxDepth;
    }

    // BFS 层序遍历 (广度优先)
    public int maxDepth3(TreeNode root) {
        if (root == null) return 0;
        int maxDepth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 每轮循环遍历处理一层的节点
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            maxDepth++;
        }
        return maxDepth;
    }

    //前序遍历 DFS
    public int maxDepth2(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int maxDepth = 0;
        ArrayDeque<Node> stack = new ArrayDeque<>();
        stack.push(new Node(root, 1));
        while (!stack.isEmpty()) {
            Node currNode = stack.pop();
            TreeNode node = currNode.node;
            int currDepth = currNode.depth;
            maxDepth = Math.max(maxDepth, currDepth);
            if (node.right != null) {
                stack.push(new Node(node.right, currDepth + 1));
            }
            if (node.left != null) {
                stack.push(new Node(node.left, currDepth + 1));
            }

        }
        return maxDepth;
    }

    private class Node {
        TreeNode node;
        int depth;

        public Node(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}
