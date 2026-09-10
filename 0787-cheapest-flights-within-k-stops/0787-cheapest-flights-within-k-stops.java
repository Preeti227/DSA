class Solution {

    class Pair {
        int node;
        int cost;
        int stops;

        Pair(int node, int cost, int stops) {
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();

        for(int i=0;i<n;i++)
            graph.add(new ArrayList<>());


        for(int[] flight: flights){
            graph.get(flight[0])
            .add(new Pair(flight[1], flight[2], 0));
        }


        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a,b)->a.cost-b.cost);


        pq.add(new Pair(src,0,0));


        int[][] visited = new int[n][k+2];

        for(int i=0;i<n;i++)
            Arrays.fill(visited[i], Integer.MAX_VALUE);



        while(!pq.isEmpty()){

            Pair curr = pq.poll();


            if(curr.node == dst)
                return curr.cost;


            if(curr.stops > k)
                continue;



            for(Pair next : graph.get(curr.node)){


                int newCost = curr.cost + next.cost;
                int newStops = curr.stops + 1;


                if(newStops <= k+1 &&
                   newCost < visited[next.node][newStops]){


                    visited[next.node][newStops] = newCost;


                    pq.add(new Pair(
                        next.node,
                        newCost,
                        newStops
                    ));
                }
            }
        }


        return -1;
    }
}