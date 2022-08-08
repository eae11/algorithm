package leetcode;

import java.util.ArrayDeque;

//20.根节点到目标节点的最短路径不存在返回(-1)
public class Test20 {
    public static void main(String[] args) {

    }

    //前序遍历,DFS
    public int maxDepth2(TreeNode<Integer> root, Integer target) {
        if (root == null) {
            return -1;
        }
        int minPath = Integer.MAX_VALUE;
        ArrayDeque<Node> stack = new ArrayDeque<>();
        stack.push(new Node(root, 1));
        while (!stack.isEmpty()) {
            Node currNode = stack.pop();
            TreeNode node = currNode.node;
            int currDepth = currNode.depth;
            if ((node.data) == target) {
                minPath = Math.min(minPath, currNode.depth - 1);
            }
            if (node.right != null) {
                stack.push(new Node(node.right, currDepth + 1));
            }
            if (node.left != null) {
                stack.push(new Node(node.left, currDepth + 1));
            }

        }
        return minPath == Integer.MAX_VALUE ? -1 : minPath;
    }

    //层序遍历BFS
    public int maxDepth(TreeNode<Integer> root, Integer target) {
        if (root == null) {
            return -1;
        }
        int minPath = 0;
        ArrayDeque<TreeNode<Integer>> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            //每次遍历一层
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode<Integer> curr = queue.poll();
                if (curr.data == target) {
                    return minPath;
                }
                queue.offer(curr.left);
                queue.offer(curr.right);
            }
            //处理完一层+1
            minPath++;
        }
        return -1;
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
