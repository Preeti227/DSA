class Solution {
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = reverse(slow);
        ListNode first = head;
        int maxSum = 0;
        while(second != null) {
            int sum = first.val + second.val;
            maxSum = Math.max(maxSum, sum);
            first = first.next;
            second = second.next;
        }
        return maxSum;
    }
}