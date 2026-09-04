class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<ListNode> list = new ArrayList<>();
        for(ListNode node : lists) {
            if(node != null)
                list.add(node);
        }
        while(list.size() > 1) {
            int n = list.size();
            ListNode first = list.get(n - 1);
            ListNode second = list.get(n - 2);
            ListNode merged = merge(first, second);
            // Remove last two
            list.remove(n - 1);
            list.remove(n - 2);

            list.add(merged);
        }
        return list.size() == 0 ? null : list.get(0);
    }
    public ListNode merge(ListNode a, ListNode b) {

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(a != null && b != null) {
            if(a.val <= b.val) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        if(a != null)tail.next = a;
        if(b != null)tail.next = b;
        return dummy.next;
    }
}