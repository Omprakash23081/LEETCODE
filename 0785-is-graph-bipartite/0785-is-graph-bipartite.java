class Solution {
    int col[];
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        boolean visited[] = new boolean[n];
        col = new int[n];
        for(int i =0 ; i<n ; i++){
            if(!visited[i]){
                if(!solve(graph , visited , i , 0)) return false;
            }
        }
        return true;
    }

    boolean solve(int arr[][] , boolean visited[] , int v , int color){
        visited[v] = true;
        col[v] = color;
        for(int val : arr[v]){
            if(!visited[val]){
               if(!solve(arr , visited , val , 1-color)) return false;
            }
            else if(col[val]==color) return false;
        }
        return true;
    }
}