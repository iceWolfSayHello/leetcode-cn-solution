package topic_1_200.t51_100;

/**
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 *
 * 返回同样按升序排列的结果链表。
 * 示例 1：

 * 输入：head = [1,1,2]
 * 输出：[1,2]
 *
 * 示例 2：

 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 */
public class T83_DeleteDuplicates {

    /**
     * 由于是排序过的，只需要将前一个节点的值与后一个节点值进行对比，
     * 若相同则将后面节点进行删除即可
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {return head;}
        ListNode preNode = null, currentNode = head;
        while (currentNode != null) {
            if (preNode != null && (preNode.val == currentNode.val)) {
                preNode.next = currentNode.next;
            }else {
                preNode = currentNode;
            }
            currentNode = currentNode.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        T83_DeleteDuplicates deleteDuplicates = new T83_DeleteDuplicates();
        deleteDuplicates.deleteDuplicates(head);
        ListNode currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.val);
            currentNode = currentNode.next;
        }
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}