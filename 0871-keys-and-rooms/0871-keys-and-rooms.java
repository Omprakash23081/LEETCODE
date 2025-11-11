class Solution {

    private void solve(List<List<Integer>> li , boolean visited[] , int node){
        visited[node] = true;
        for(int v : li.get(node)){
            if(!visited[v]) solve(li , visited , v);
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean visited[] = new boolean[rooms.size()];
        solve(rooms , visited , 0);
        for(boolean v : visited) if(!v) return false;
        return true;
    }
}