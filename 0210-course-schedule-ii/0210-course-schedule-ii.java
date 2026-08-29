class Solution {
    public int[] findOrder(int n, int[][] pre) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for (int i = 0; i < pre.length; i++) {
            int a = pre[i][0];
            int b = pre[i][1];
            adj.get(b).add(a);
            indegree[a]++;
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int front = q.remove();
            ans.add(front);

            for (int ele : adj.get(front)) {
                indegree[ele]--;
                if (indegree[ele] == 0) {
                    q.add(ele);
                }
            }
        }
        if (ans.size() != n) {
            return new int[0];
        }
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = ans.get(i);
        }

        return result;
    }
}