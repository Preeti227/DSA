class Solution {
    public int findCircleNum(int[][] adj) {
      int n=adj.length;
      boolean[] visited=new boolean[n];
      int count=0;
      for(int i=0;i<n;i++){
        if(visited[i]==false){
            bfs(i,visited,adj);
            count++;
        }
      }
    return count;
    }
    private void bfs(int i,boolean[] visited,int[][]adj){
        int n=adj.length;
        Queue<Integer> q=new LinkedList<>();
        q.add(i);
        visited[i]=true;
        while(q.size()>0){
            int front=q.remove();
            for(int j=0;j<n;j++){
                if(adj[front][j]==1 && visited[j]==false){
                    q.add(j);
                    visited[j]=true;
                }
            }
        }
    }
}