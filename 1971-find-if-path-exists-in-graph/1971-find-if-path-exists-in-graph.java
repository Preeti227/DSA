class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source==destination) return true;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int a=edges[i][0],b=edges[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        boolean[] visited=new boolean[n];
        visited[source]=true;
        bfs(source,adj,visited,destination);
        return visited[destination];
    }
    private void bfs(int source,List<List<Integer>> adj,boolean[] visited,int destination){
        Queue<Integer> q=new LinkedList<>();
        q.add(source);
        while(q.size()>0){
            int front=q.remove();
            for(int ele:adj.get(front)){
                if(!visited[ele]){
                    q.add(ele);
                    visited[ele]=true;
                }
            }
        }
    }
}