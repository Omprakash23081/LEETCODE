class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long sum = 0;

        for(int i =0 ; i<m ; i++){
            for(int j =0 ; j<n ; j++){
                sum += grid[i][j];
            }
        }

        long subSum = 0;

        for(int i =0 ; i<m ; i++){
            for(int j = 0 ; j<n ; j++){
                subSum += grid[i][j];
            }
            if(subSum == (sum - subSum)){
                return true;
            }
        }

        subSum = 0;

        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<m ; j++){
                subSum += grid[j][i];
            }
            if(subSum == (sum - subSum)){
               return true;
            }
        }

        return false;
    }
}