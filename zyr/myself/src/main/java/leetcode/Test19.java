package leetcode;

//给定一个二叉树root和一个目标节点target
//判断从这个二叉树的root节点到 target 节点是否有路径
public class Test19 {
    public static void main(String[] args) {

    }

    public boolean hasPath(TreeNode<Integer> root, int target) {
        if (root == null) {
            return false;
        }
        if (root.data == target) {
            return true;
        }
        return hasPath(root.left, target) || hasPath(root.right, target);
    }


}
