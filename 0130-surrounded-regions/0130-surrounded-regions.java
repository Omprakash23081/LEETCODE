class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        Queue<int[]> qu = new LinkedList<>();

        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){
                if((i==0 || j== n-1 || i== m-1 || j==0) && board[i][j]=='O'){
                    qu.add(new int[]{i , j});
                    board[i][j] = 'H';
                } 
            }
        }

        while(!qu.isEmpty()){
            int arr[] = qu.poll();
            int i = arr[0];
            int j = arr[1];

            if (i + 1 < m && board[i+1][j]=='O') {
                qu.add(new int[]{i+1 , j});
                board[i+1][j] = 'H';
            }
            if (i - 1 >= 0 && board[i-1][j]=='O') {
                qu.add(new int[]{i-1 , j});
                board[i-1][j] = 'H';
            }
            if (j + 1 < n && board[i][j+1]=='O') {
                qu.add(new int[]{i , j+1});
                board[i][j+1] = 'H';
            }
            if (j - 1 >= 0 && board[i][j-1]=='O') {
                qu.add(new int[]{i , j-1});
                board[i][j-1] = 'H';
            }
        }
        
        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){
                if(board[i][j]=='O'){
                    board[i][j] = 'X';
                }
                if(board[i][j]=='H'){
                    board[i][j] = 'O';
                }
            }
        }
    }
}