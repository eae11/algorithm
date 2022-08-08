package leetcode;
//16.链表进行插入排序
public class Test16 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        ListNode listNode = insertionSortList(listNode1);

    }

    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = head;
        ListNode curr = pre.next;
        while (curr != null) {
            if (curr.val < pre.val) {
                ListNode p = dummy;
                while (p.next.val < curr.val) {
                    p = p.next;
                }
                pre.next = curr.next;
                curr.next = p.next;
                p.next = curr;
                curr = pre.next;
            } else {
                curr = curr.next;
                pre = pre.next;
            }
        }
        return dummy.next;

    }
}
