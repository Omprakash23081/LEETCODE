class Solution {
    
    private int helper(int arr[][] , Integer DP[][] , int row , int cal){
        if(row>arr.length || row<0 || cal>arr[0].length || cal<0){
            return 0;
        }
        if(row==arr.length-1 && cal==arr[0].length-1)return 1;
        if(DP[row][cal]!=null)return DP[row][cal];
        return DP[row][cal] = helper(arr , DP , row+1 , cal) + helper(arr , DP , row , cal+1);
    }

    public int uniquePaths(int m, int n) {
        int arr[][] = new int[m][n]; 
        Integer DP[][] = new Integer[m+1][n+1]; 
        return helper(arr ,DP , 0 , 0);
    }
}