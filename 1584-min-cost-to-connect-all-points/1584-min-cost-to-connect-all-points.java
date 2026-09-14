class Solution {

    class Triplet implements Comparable<Triplet> {
        int node;
        int dist;

        Triplet(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        public int compareTo(Triplet t) {
            return Integer.compare(this.dist, t.dist);
        }
    }

    public int minCostConnectPoints(int[][] points) {

        int n = points.length;

        PriorityQueue<Triplet> pq = new PriorityQueue<>();

        pq.add(new Triplet(0, 0));

        boolean[] vis = new boolean[n];

        int sum = 0;

        while (!pq.isEmpty()) {

            Triplet top = pq.remove();

            int node = top.node;
            int dist = top.dist;

            if (vis[node])
                continue;

            vis[node] = true;
            sum += dist;

            for (int i = 0; i < n; i++) {

                if (vis[i])
                    continue;

                int x1 = points[node][0];
                int y1 = points[node][1];

                int x2 = points[i][0];
                int y2 = points[i][1];

                int mDist = Math.abs(x1 - x2)
                          + Math.abs(y1 - y2);

                pq.add(new Triplet(i, mDist));
            }
        }

        return sum;
    }
}