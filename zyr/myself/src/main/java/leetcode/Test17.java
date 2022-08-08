package leetcode;

public class Test17 {
    public static void main(String[] args) {

    }

    //合并两个升序链表
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummyNode = new ListNode(-1);
        ListNode curr = dummyNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;

            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if (l1 != null) {
            curr.next = l1;
        }
        if (l2 != null) {
            curr.next = l2;
        }
        return dummyNode.next;
    }

    // 递归实现
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // 找到中间节点
        ListNode slow = head, fast = head.next;//偶数节点的前一个节点,如果fast设置为head,则是偶数节点的第二个节点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rightHead = slow.next;
        slow.next = null;
        //对左边链表进行排序
        ListNode left = sortList(head);//分到最后就是元素为一个的链表,当然有序了
        //对右边链表进行排序
        ListNode right = sortList(rightHead);

        return mergeTwoLists1(left, right);

    }
}
