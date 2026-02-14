class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> qu = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int zero = 0;
        
        for(int i=0 ; i<m ; i++){
            for(int j =0 ; j<n ; j++){
                if(grid[i][j]==2)
                    qu.add(new int[]{i , j});
                if(grid[i][j]==0) zero++;    
            }
        }

        if(n*m == zero) return 0;

        int count  = -1;

        while(!qu.isEmpty()){
            int size = qu.size();
            for(int i=0 ; i<size ; i++){
                int idx[] = qu.poll();
                int idx1 = idx[0];
                int idx2 = idx[1];
                // System.out.println(idx1 + " " + idx2);
                if(idx1 + 1 < m && grid[idx1+1][idx2]==1){
                    grid[idx1+1][idx2] = 2;
                    qu.add(new int[]{idx1+1 , idx2});
                }
                if(idx1 - 1 >= 0 && grid[idx1-1][idx2]==1){
                    grid[idx1-1][idx2] = 2;
                    qu.add(new int[]{idx1-1 , idx2});
                }
                if(idx2 + 1 < n && grid[idx1][idx2+1]==1){
                    grid[idx1][idx2+1] = 2;
                    qu.add(new int[]{idx1 , idx2+1});
                }
                if(idx2 - 1 >= 0 && grid[idx1][idx2-1]==1){
                    grid[idx1][idx2-1] = 2;
                    qu.add(new int[]{idx1 , idx2-1});
                }      
            }
            count++;
        }

        for(int i=0 ; i<m ; i++){
            for(int j =0 ; j<n ; j++){
                if(grid[i][j]==1)
                    count = -1;
            }
        }
        return count;
    }
}