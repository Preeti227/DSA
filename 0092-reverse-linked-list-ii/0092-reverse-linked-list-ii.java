class Solution {

    public ListNode reverseBetween(ListNode head, int left, int right) {

        ArrayList<ListNode> list = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){

            list.add(temp);
            temp = temp.next;
        }

        int i = left - 1;
        int j = right - 1;
        while(i < j){
            ListNode t1 = list.get(i);
            ListNode t2 = list.get(j);
            list.set(i, t2);
            list.set(j, t1);
            i++;
            j--;
        }

        for(i = 0; i < list.size(); i++){

            if(i == list.size()-1)
                list.get(i).next = null;
            else
                list.get(i).next = list.get(i+1);
        }
        return list.get(0);
    }
}