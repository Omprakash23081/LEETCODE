class Solution {
    public boolean isBipartite(int[][] graph) {
        int v = graph.length;
        int color[] = new int[v];

        Arrays.fill(color , -1);

        for(int i=0 ; i<v ; i++){
            if(color[i]==-1)
                if(!DFS(graph , i , color)) return false;
        }

        return true;
    }

    private boolean DFS(int graph[][] , int val , int color[]){

        for(int v : graph[val]){
            if(color[v]==-1){
                color[v] = 1 - color[val]; 
                if(!DFS(graph , v , color)) return false;
            }
            else if(color[val] == color[v]) return false;    
        }
        return true;
    }
}