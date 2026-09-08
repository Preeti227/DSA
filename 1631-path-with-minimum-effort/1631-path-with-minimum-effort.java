class Solution {
    class Triplet implements Comparable<Triplet>{
        int row, col, dist;

        Triplet(int row,int col,int dist){
            this.row=row;
            this.col=col;
            this.dist=dist;
        }
        public int compareTo(Triplet t){
            if(this.dist==t.dist) return this.row-t.row;
            return this.dist-t.dist;
        }
    }

    public int minimumEffortPath(int[][] arr) {
        int m=arr.length, n=arr[0].length;
        int[][] ans=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans[i][j]=Integer.MAX_VALUE;
            }
        }

        ans[0][0]=0;
        PriorityQueue<Triplet> pq=new PriorityQueue<>();

        pq.add(new Triplet(0,0,0));
        while(pq.size()>0){
            Triplet top=pq.remove();
            int row=top.row;
            int col=top.col;
            int dist=top.dist;

            if(row==m-1 && col==n-1)
                return dist;
            // up
            if(row>0){
                int e=Math.abs(arr[row][col]-arr[row-1][col]);
                e=Math.max(e,dist);
                if(e<ans[row-1][col]){
                    ans[row-1][col]=e;
                    pq.add(new Triplet(row-1,col,e));
                }
            }
            // down
            if(row<m-1){

                int e=Math.abs(arr[row][col]-arr[row+1][col]);
                e=Math.max(e,dist);
                if(e<ans[row+1][col]){
                    ans[row+1][col]=e;
                    pq.add(new Triplet(row+1,col,e));
                }
            }
            // left
            if(col>0){
                int e=Math.abs(arr[row][col]-arr[row][col-1]);
                e=Math.max(e,dist);
                if(e<ans[row][col-1]){
                    ans[row][col-1]=e;
                    pq.add(new Triplet(row,col-1,e));
                }
            }

            // right
            if(col<n-1){

                int e=Math.abs(arr[row][col]-arr[row][col+1]);
                e=Math.max(e,dist);
                if(e<ans[row][col+1]){
                    ans[row][col+1]=e;
                    pq.add(new Triplet(row,col+1,e));
                }
            }
        }
        return 0;
    }
}