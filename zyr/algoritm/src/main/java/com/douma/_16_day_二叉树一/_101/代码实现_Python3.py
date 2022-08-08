# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if not root: return True
        return self.isSymmetricHelp(root, root)

    # DFS
    def isSymmetricHelp1(self, p: TreeNode, q: TreeNode) -> bool:
        if not p and not q:
            return True
        elif not p or not q:
            return False
        elif p.val != q.val:
            return False
        return self.isSymmetricHelp1(p.left, q.right) and self.isSymmetricHelp1(p.right, q.left)

    # BFS
    def isSymmetricHelp(self, p: TreeNode, q: TreeNode) -> bool:
        if not p and not q:
            return True
        if not p or not q:
            return False

        queue1 = collections.deque([p])
        queue2 = collections.deque([q])

        while queue1 and queue2:
            node1 = queue1.popleft()
            node2 = queue2.popleft()
            if node1.val != node2.val:
                return False
            left1, right1 = node1.left, node1.right
            left2, right2 = node2.left, node2.right
            if (not left1) ^ (not right2):
                return False
            if (not right1) ^ (not left2):
                return False
            if left1:
                queue1.append(left1)
            if right2:
                queue2.append(right2)
            if left2:
                queue2.append(left2)
            if right1:
                queue1.append(right1)

        return not queue1 and not queue2