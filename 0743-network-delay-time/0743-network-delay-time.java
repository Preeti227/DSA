class Solution {
    class Pair {
        int node;
        int time;
        Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Pair>());
        }

        for(int i = 0; i < times.length; i++) {

            int u = times[i][0];
            int v = times[i][1];
            int time = times[i][2];
            adj.get(u).add(new Pair(v, time));
        }

        // Distance array
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;
        // Min heap
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.time - b.time);
        pq.add(new Pair(k,0));

        // Dijkstra
        while(!pq.isEmpty()) {
            Pair curr = pq.remove();
            int node = curr.node;
            int time = curr.time;

            if(time > dist[node])
                continue;
            for(Pair neighbour : adj.get(node)) {
                int nextNode = neighbour.node;
                int newTime = time + neighbour.time;

                if(newTime < dist[nextNode]) {
                    dist[nextNode] = newTime;
                    pq.add(new Pair(nextNode,newTime));
                }
            }
        }
        // Find maximum time
        int ans = 0;
        for(int i = 1; i <= n; i++) {
            if(dist[i] == Integer.MAX_VALUE)
                return -1;
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}