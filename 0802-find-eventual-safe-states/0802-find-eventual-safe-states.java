class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean visited[] = new boolean[n];
        boolean path[] = new boolean[n];
        List<Integer> li = new ArrayList<>();

        for(int i =0 ; i<n ; i++){
            if(solve(graph , visited , path , i))
              li.add(i);
        }
        
        return li;
    }

    boolean solve(int arr[][] , boolean visited[] , boolean path[] , int val){
        visited[val] = true;
        path[val] = true;

        for(int v : arr[val]){ 
            if(!visited[v]){
                if(!solve(arr , visited , path , v)) return false;
            }else if(path[v]) return false;
        }
        path[val] = false;
        return true;
    }
}