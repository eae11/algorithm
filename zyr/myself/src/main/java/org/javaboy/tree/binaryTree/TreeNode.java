package org.javaboy.tree.binaryTree;

class TreeNode<E> {
    E data;
    TreeNode<E> left;
    TreeNode<E> right;

    TreeNode(E data) {
        this.data = data;
        left = right = null;
    }
}
