class Solution {
    public int countNegatives(int[][] grid) {
        int count=0;
        int n = grid[0].length;
        for(int arr[] : grid){
            for(int i=0 ; i<n ; i++){
                if(arr[i]<0){
                    count += (n-i);
                    break;
                }
            }
        }
        return count;
    }
}