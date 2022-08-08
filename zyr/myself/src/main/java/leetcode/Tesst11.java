package leetcode;

/*给定一个带有头结点 head 的非空单链表，
返回链表的中间结点。·如果有两个中间结点，
则返回第二个中间结点。
 */
public class Tesst11 {
    public static void main(String[] args) {

    }

    //快慢指针
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode middleNode1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 1. 计算链表的长度
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            length++;
        }
        // 2. 找到链表的中间节点
        for (int i = 0; i < length / 2; i++) {
            head = head.next;
        }
        return head;
    }

    private static class ListNode {
        ListNode next;
        int val;
    }
}
