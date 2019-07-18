package topic_1_200.t1_50;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * @author ：wy.
 * @date ：Created in 12:14 2019/6/26
 */
public class T23_MergeKLinkList {

    private ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        ListNode head = null;
        ListNode current = null;
        ListNode[] tempLists = new ListNode[lists.length];
        for (int i = 0; i < tempLists.length; i++) {
            tempLists[i] = lists[i];
        }
        while (true) {
            boolean done = true;
            Integer minValue = null;
            int minIndex = 0;
            //取出所有链表的头数据，找出最小值
            for (int i = 0; i < tempLists.length; i++) {
                if (tempLists[i] != null) {
                    done = false;
                    if (minValue == null || tempLists[i].val < minValue) {
                        minValue = tempLists[i].val;
                        minIndex = i;
                    }
                }
            }
            if (done) {
                break;
            }
            //move index
            tempLists[minIndex] = tempLists[minIndex].next;
            //store data
            ListNode node = new ListNode(minValue);
            if (head == null) {
                head = node;
                current = node;
            }
            else {
                current.next = node;
                current = current.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(5);
        lists[0] = head1;
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);
        lists[1] = head2;
        ListNode head3 = new ListNode(2);
        head3.next = new ListNode(6);
        lists[2] = head3;
        T23_MergeKLinkList mergeKLinkList = new T23_MergeKLinkList();
        ListNode h = mergeKLinkList.mergeKLists(lists);
        while (h != null){
            System.out.print(h.val+"->");
            h=h.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
