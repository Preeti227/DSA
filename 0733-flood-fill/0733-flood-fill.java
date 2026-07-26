class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original=image[sr][sc];
        if(original==color) return image;
        int[] delr={-1,1,0,0};
        int[] delc={0,0,-1,1};
        dfs(sr,sc,image,original,color,delr,delc);
        return image;
    }
    private void dfs(int row,int col,int[][] image,int original,int color,int[] delr,int[] delc){
        int m=image.length;
        int n=image[0].length;
        image[row][col]=color;
        for(int i=0;i<4;i++){
            int nrow=row+delr[i];
            int ncol=col+delc[i];
            if(nrow>=0 && nrow<m &&ncol>=0 && ncol<n && image[nrow][ncol]==original){
                dfs(nrow,ncol,image,original,color,delr,delc);                
            }
        }
    }
}