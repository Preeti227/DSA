import java.util.*;

class Solution {

    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }


    public int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int count = 0;

        boolean[][] visited = new boolean[m][n];


        for(int i = 0; i < m; i++) {

            for(int j = 0; j < n; j++) {

                if(grid[i][j] == '1' && !visited[i][j]) {

                    bfs(i,j,visited,grid);

                    count++;
                }
            }
        }

        return count;
    }
    private void bfs(int i,
        int j,boolean[][] visited,char[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(i,j));

        visited[i][j] = true;
        while(!q.isEmpty()) {

            Pair front = q.remove();
            int row = front.row;
            int col = front.col;

            // Up
            if(row-1 >= 0 && !visited[row-1][col] && grid[row-1][col]=='1') {

                q.add(new Pair(row-1,col));
                visited[row-1][col]=true;
            }


            // Down
            if(row+1 < m && !visited[row+1][col] && grid[row+1][col]=='1') {
                q.add(new Pair(row+1,col));
                visited[row+1][col]=true;
            }
            // Left
            if(col-1 >= 0 && !visited[row][col-1] && grid[row][col-1]=='1') {
                q.add(new Pair(row,col-1));
                visited[row][col-1]=true;
            }

            // Right
            if(col+1 < n && !visited[row][col+1] && grid[row][col+1]=='1') {

                q.add(new Pair(row,col+1));
                visited[row][col+1]=true;
            }
        }
    }
}