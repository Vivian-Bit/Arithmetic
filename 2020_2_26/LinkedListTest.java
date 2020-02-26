package java15_0226;

import java15_0105.LinkedList;
import javafx.scene.layout.Pane;

public class LinkedListTest {
    // 给内部类加 static 效果和其他的 static 类似. 让这个类和 LinkedListTest 类相关, 而和对象不相关.
    // 后续如果要创建 ListNode 的实例的话, 就不需要依赖 LinkedListTest 的实例
    static class ListNode {
        int val;
        ListNode next;

        // alt + insert 弹出一个下拉菜单, 选择生成构造方法.
        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        // 删除头部节点和删除中间节点, 逻辑不一样.
        // 需要分别对待.
        if (head == null) {
            // 空链表, 没的删
            return null;
        }
        // 1. 先删除中间节点的情况(非头部的情况)
        ListNode prev = head;  // prev 始终指向 cur 的前一个位置
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                // 这个节点就需要删除掉
                prev.next = cur.next; // 这一行代码下来, cur 对应的节点就被删掉了
                cur = prev.next;        // cur 指向下一个元素, 方便进行下次循环
            } else {
                // 这个节点不需要删除
                prev = cur;
                cur = cur.next;
            }
        }
        // 2. 最后再考虑删除头结点的情况(放到最后, 只需要处理一次即可)
        if (head.val == val) {
            head = head.next;
        }
        return head;
    }

    // 诸如链表为空等特殊情况一定要重点考虑到
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            // 空链表, 不需要逆置
            return null;
        }
        if (head.next == null) {
            // 链表中只有一个元素, 也不需要逆置
            return head;
        }
        ListNode newHead = null;
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) {
                // 当前 cur 就是原链表的末尾
                newHead = cur;
            }
            // 逆置的核心操作
            cur.next = prev;
            // 更新三兄弟的指向位置
            prev = cur;
            cur = next;
        }
        return newHead;
    }

    public ListNode middleNode(ListNode head) {
        int steps = size(head) / 2;
        ListNode cur = head;
        for (int i = 0; i < steps; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public int size(ListNode head) {
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        return size;
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int size = size(head);
        if (k <= 0 || k > size) {
            // k 是非法值
            return null;
        }
        int steps = size - k;
        ListNode cur = head;
        for (int i = 0; i < steps; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            // l1 为空, 最终结果就是 l2
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                // 把 cur1 对应的节点插入到新链表的末尾
                // 此处需要考虑到两种情况, newTail 为 null 和非 null 的情况.
                newTail.next = cur1;
                newTail = newTail.next;
                cur1 = cur1.next;
            } else {
                newTail.next = cur2;
                newTail = newTail.next;
                cur2 = cur2.next;
            }
        }
        // 当循环结束时, 意味着当前 cur1 和 cur2 一定有一个到达了链表末尾.
        // 把另外一个没到末尾的剩下的元素都连接在最终链表的尾部
        if (cur1 == null) {
            newTail.next = cur2;
        } else {
            newTail.next = cur1;
        }
        return newHead.next;
    }

    public ListNode partition(ListNode pHead, int x) {
        if (pHead == null) {
            return null;
        }
        if (pHead.next == null) {
            return pHead;
        }
        ListNode bigHead = new ListNode(-1);
        ListNode bigTail = bigHead;
        ListNode smallHead = new ListNode(-1);
        ListNode smallTail = smallHead;

        for (ListNode cur = pHead; cur != null; cur = cur.next) {
            if (cur.val < x) {
                // 插入到 smallTail 后面, 创建崭新的节点(新节点的 next 一定是 null)
                smallTail.next = new ListNode(cur.val);
                smallTail = smallTail.next;
            } else {
                // 插入到 bigTail 的后面
                bigTail.next = new ListNode(cur.val);
                bigTail = bigTail.next;
            }
        }

        // 将两个链表收尾相接到一起
        smallTail.next = bigHead.next;
        return smallHead.next;
    }

    public static void main(String[] args) {
        // 构造一下刚才的数据, 本地测试一下
        ListNode a = new ListNode(9);
        ListNode b = new ListNode(5);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(7);
        ListNode e = new ListNode(3);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = null;

        int x = 4; // 基准值
        LinkedListTest test = new LinkedListTest();
        ListNode result = test.partition(a, x);
        for (ListNode cur = result; cur != null; cur = cur.next) {
            System.out.println(cur.val);
        }
    }
}
