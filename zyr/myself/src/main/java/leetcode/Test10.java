package leetcode;
//反转链表
public class Test10 {
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr;
        curr = head;
        ListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;

        }
        return pre;
    }

    //递归
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList2(head.next);
        p.next.next = head;
        head.next = null;
        return p;
    }

    private static class ListNode {
        ListNode next;
        int val;
    }
}

