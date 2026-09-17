class Solution {
    class Pair {
        int row;
        int col;
        int dist;
        Pair(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] vis = new int[n][m];
        int[][] dist = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (mat[i][j] == 0) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 1;
                } 
                else {
                    vis[i][j] = 0;
                }
            }
        }

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        while (!q.isEmpty()) {
            Pair top = q.remove();
            int r = top.row;
            int c = top.col;
            int d = top.dist;
            dist[r][c] = d;

            for (int i = 0; i < 4; i++) {

                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if (nrow >= 0 && nrow < n &&
                    ncol >= 0 && ncol < m &&
                    vis[nrow][ncol] == 0) {
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow, ncol, d + 1));
                }
            }
        }
        return dist;
    }
}