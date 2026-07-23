class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean[] visited=new boolean[n];
        visited[0]=true;
        bfs(0,visited,rooms);
        for(boolean ele:visited){
            if(ele==false) return false;
        }
        return true;
    }
    private void bfs(int i, boolean[] visited,List<List<Integer>> rooms){
        Queue<Integer> q=new LinkedList<>();
        q.add(i);
        while(q.size()>0){
            int front=q.remove();
            for(int ele:rooms.get(front)){
                if(visited[ele]==false){
                    q.add(ele);
                    visited[ele]=true;
                }
            }
        }
    }
}