class Solution {

    class Pair {
        int node;
        double prob;
        Pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<Pair>());
        }
        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            adj.get(u).add(new Pair(v, prob));
            adj.get(v).add(new Pair(u, prob));
        }

        double[] ans = new double[n];
        ans[start] = 1;

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a,b) -> Double.compare(b.prob, a.prob));
        pq.add(new Pair(start,1));

        while(!pq.isEmpty()) {
            Pair curr = pq.remove();
            int node = curr.node;
            double prob = curr.prob;

            if(node == end)
                return prob;
            if(prob < ans[node])
                continue;

            for(Pair neighbour : adj.get(node)) {
                int nextNode = neighbour.node;
                double newProb = prob * neighbour.prob;

                if(newProb > ans[nextNode]) {
                    ans[nextNode] = newProb;
                    pq.add(new Pair(nextNode,newProb));
                }
            }
        }
        return 0.0;
    }
}