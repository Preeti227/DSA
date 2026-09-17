class Solution {
    class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public int numEnclaves(int[][] grid) {
        Queue<Pair> q=new LinkedList<Pair>();
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0||j==0||i==n-1||j==m-1){
                    if(grid[i][j]==1){
                        q.add(new Pair(i,j));
                        vis[i][j]=1;
                    }
                }
            }
        }
        int[] delRows={-1,0,+1,0};
        int[] delCols={0,+1,0,-1};
        while(q.size()>0){
            Pair top=q.remove();
            int r=top.first;
            int c=top.second;
            for(int i=0;i<4;i++){
                int nrows=r+delRows[i];
                int ncols=c+delCols[i];
                if(nrows<n && ncols<m && nrows>0 && ncols>0 && vis[nrows][ncols]==0 && grid[nrows][ncols]==1){
                    q.add(new Pair(nrows,ncols));
                    vis[nrows][ncols]=1;
                }
            }
        }

        int count=0;
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]==1){
                    count++;
                }
            }
         }
        return count;
    }
}