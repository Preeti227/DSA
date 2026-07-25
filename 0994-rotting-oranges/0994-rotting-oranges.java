class Solution {
    class Pair {
        int row;
        int col;
        int time;

        Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int fresh = 0;
        // Put all rotten oranges in queue
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                }
                else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        int maxTime = 0;
        // Four directions
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        while(!q.isEmpty()) {
            Pair front = q.remove();
            int row = front.row;
            int col = front.col;
            int time = front.time;
            maxTime = Math.max(maxTime, time);

            for(int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                // Valid fresh orange
                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && grid[nrow][ncol] == 1) {
                    grid[nrow][ncol] = 2;// Make orange rotten
                    fresh--;
                    q.add(new Pair(nrow, ncol, time + 1));
                }
            }
        }
        if(fresh > 0) {
            return -1;
        }
        return maxTime;
    }
}