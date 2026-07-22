class Solution {
    public void solveSudoku(char[][] arr) {
        solve(arr, 0, 0);
    }

    boolean solve(char arr[][], int i, int j) {
       
       if(i == 9) return true;

       int ni = i;
       int nj = j+1;
       
       if(nj == 9){
         nj = 0;
         ni++;
       }

       if(arr[i][j] != '.') return solve(arr , ni , nj);

        
        for (char idx = '1'; idx <= '9'; idx++) {
            if (isSafe(arr, i, j, idx)) {
                arr[i][j] = idx;
                if(solve(arr , ni , nj)) return true;              
                arr[i][j] = '.';
            }
        }
        return false;
    }

    boolean isSafe(char arr[][], int i, int j, char v) {
        for (int idx = 0; idx < 9; idx++) {
            if (arr[i][idx] == v)
                return false;
        }
        for (int idx = 0; idx < 9; idx++) {
            if (arr[idx][j] == v)
                return false;
        }

        int nr = (i/3)*3;
        int nc = (j/3)*3;

        for(int ni = nr ; ni < nr+3; ni++){
            for(int nj = nc ; nj < nc+3 ; nj++){
                if(arr[ni][nj]==v) return false;
            }
        }
        return true;
    }
}