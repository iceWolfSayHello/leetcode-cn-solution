package topic_1_200.t51_100;

/**
 * 你单链表的头节点 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 示例 2：
 *
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 *  
 *
 * 提示：
 *
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 *
 */
public class T92_ReverseBetween {

    /**
     * 将每个区间内的节点都插到区间内的头节点之前
     */
  public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right || head.next == null) {return head;}
        ListNode curNode = head, leaderNode = null,tailNode = null,
                preNode = null, leaderPreNode = null;
        for (int i = 1; i <= right; i++) {
            if (i == left) {
                leaderNode = curNode;
                leaderPreNode = preNode;
            }else if (i > left && i <= right) {
                ListNode nextNode = curNode.next;
                if (leaderPreNode != null) {
                    leaderPreNode.next = curNode;
                }else {
                    head = curNode;
                }
                curNode.next = leaderNode;
                if (tailNode == null) {
                    tailNode = leaderNode;
                }
                tailNode.next = nextNode;
                leaderNode = curNode;
                curNode = nextNode;
                continue;
            }
            preNode = curNode;
            curNode = curNode.next;
        }
        return head;
    }

    /**
     * 将链表转化为数组，然后对数组进行反转
     */
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        if (left == right || head.next == null) {return head;}
        // 1 将链表的前后数字交换转为数组的前后数字交换
        int size = right - left + 1;
        ListNode curNode = head;
        ListNode[] nodeArray = new ListNode[size];
        for (int i = 1; i <= right; i++) {
            if (i >= left && i <= right) {
                nodeArray[i-left] = curNode;
            }
            curNode = curNode.next;
        }
        // 2 数组前后数字交换
        for (int i = 0; i < size / 2; i++) {
            int preVal = nodeArray[i].val;
            nodeArray[i].val = nodeArray[size - i - 1].val;
            nodeArray[size - i - 1].val = preVal;
        }
        return head;
    }

    public static void main(String[] args) {
        T92_ReverseBetween reverseBetween = new T92_ReverseBetween();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head = reverseBetween.reverseBetween(head, 2,4);
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + "\t");
            cur = cur.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }
}
