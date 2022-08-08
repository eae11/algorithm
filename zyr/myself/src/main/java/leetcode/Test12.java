package leetcode;

//删除链表倒数第N个节点
public class Test12 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        removeNthFromEnd1(head, 2);
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode slow = dummyNode;
        ListNode fast = dummyNode;

        // fast 先走 n + 1
        while (n-- >= 0) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode delNode = slow.next;
        slow.next = delNode.next;
        delNode.next = null;

        return dummyNode.next;
    }

    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        if (head == null) return null;
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        // 1. 计算链表长度
        int length = 0;
        ListNode curr = dummyNode;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        // 2. 找到倒数第 n 个节点的前一个节点
        ListNode prev = dummyNode;
        for (int i = 1; i < length - n; i++) {
            prev = prev.next;
        }
        // 3. 删除倒数第 n 个节点
        ListNode delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;

        return dummyNode.next;
    }

    private static class ListNode {
        ListNode next;
        int val;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(ListNode next, int val) {
            this.next = next;
            this.val = val;
        }

        public ListNode(ListNode next) {
            this.next = next;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }
}
