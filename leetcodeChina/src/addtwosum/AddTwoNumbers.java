package addtwosum;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zwxbest on 2018/3/5.
 */


public class AddTwoNumbers {

    @Test
    public void main() {


        Solution solution = new Solution();
        //输入正序，结果正序
        Assert.assertEquals(solution.addTwoNumbers(ArrayToList(new int[]{3, 4, 2}), ArrayToList(new int[]{4, 6, 5})), ArrayToList(new int[]{8, 0, 7}));
        Assert.assertEquals(solution.addTwoNumbers(ArrayToList(new int[]{2}), ArrayToList(new int[]{4, 6, 5})), ArrayToList(new int[]{4, 6, 7}));
        Assert.assertEquals(solution.addTwoNumbers(ArrayToList(new int[]{4, 6, 5}), ArrayToList(new int[]{2})), ArrayToList(new int[]{4, 6, 7}));
        Assert.assertEquals(solution.addTwoNumbers(ArrayToList(new int[]{4, 6, 5}), ArrayToList(new int[]{5})), ArrayToList(new int[]{4, 7, 0}));
        Assert.assertEquals(solution.addTwoNumbers(ArrayToList(new int[]{9, 9, 9}), ArrayToList(new int[]{1})), ArrayToList(new int[]{1,0, 0, 0}));
        Assert.assertEquals(solution.addTwoNumbers(ArrayToList(new int[]{4, 3, 2}), ArrayToList(new int[]{3, 2, 60})), ArrayToList(new int[]{7, 6, 52}));
        Assert.assertEquals(solution.addTwoNumbers(ArrayToList(new int[]{4, 3, 2}), ArrayToList(new int[]{3, 2, 60})), ArrayToList(new int[]{7, 6,52}));
        Assert.assertEquals(solution.addTwoNumbers(ArrayToList(new int[]{3, 4, 20}), ArrayToList(new int[]{4, 6, 80})), ArrayToList(new int[]{8, 1,90}));

    }

    public ListNode ArrayToList(int[] array) {

        ListNode cur = null;
        ListNode newnode;
        for (int val : array) {
            newnode = new ListNode(val);
            newnode.next = cur;
            cur = newnode;
        }
        return cur;
    }

    public String LinkToString(ListNode node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.val);
            node = node.next;
        }
        return sb.toString();
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof ListNode))
                return false;
            if (obj == null)
                return false;
            ListNode node = (ListNode) obj;
            ListNode cur = this;
            while (true) {
                if (cur == null && node == null)
                    return true;
                if ((cur != null && node == null) || (cur == null && node != null))
                    return false;
                if (cur.val != node.val)
                    return false;
                node = node.next;
                cur = cur.next;
            }
        }
    }

    class Solution {

        public ListNode GenerateReverseLinkedList(ListNode l) {
            ListNode cur = null;
            ListNode newnode;
            do {
                newnode = new ListNode(l.val);
                newnode.next = cur;
                cur = newnode;
            } while ((l = l.next) != null);
            return cur;
        }

        public ListNode HandleTwoNumbers(ListNode l1, ListNode l2) {

            ListNode newnode;
            ListNode cur = null;
            int carry = 0;
            while (l1 != null && l2 != null) {
                int sum = l1.val + l2.val + carry;
                newnode = new ListNode(sum >= 10 ? sum - 10 : sum);
                newnode.next = cur;
                carry = sum >= 10 ? 1 : 0;
                cur = newnode;
                l1 = l1.next;
                l2 = l2.next;
            }

            //todo:重复代码，不好
            ListNode left = l1 != null ? l1 : l2;
            while (left != null) {
                int sum = left.val + carry;
                newnode = new ListNode(sum >= 10 ? sum - 10 : sum);
                newnode.next = cur;
                cur = newnode;
                carry = sum >= 10 ? 1 : 0;
                left = left.next;
            }
            if (carry == 1) {
                newnode = new ListNode(1);
                newnode.next = cur;
                cur = newnode;
            }

            return cur;
        }

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            ListNode ret;
            ret = HandleTwoNumbers(l1, l2);
            return GenerateReverseLinkedList(ret);
        }

    }
}
