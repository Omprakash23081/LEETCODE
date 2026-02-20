class Solution {
    int arr[][];
    int idx;
    List<List<String>> li;
    public List<List<String>> solveNQueens(int n) {
        li = new ArrayList<>();
        arr = new int[n][n];
        idx = n;

        solve(0);
        
        return li;
    }

    void solve(int n) {
        if (n == idx){
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < idx; i++) {
                StringBuilder s = new StringBuilder();
                for (int j = 0; j < idx; j++) {
                    if (arr[i][j] == 1)
                        s.append("Q");
                    else  s.append(".");  
                }
                temp.add(s.toString());
            }
            li.add(temp);
            return;
        }

        for (int i = 0 ; i < idx; i++) {
            if (isSafe(n, i)) {

                arr[n][i] = 1;
                solve(n + 1);
                arr[n][i] = 0;
            }
        }
    }

    boolean isSafe(int i, int j) {
        for (int k = i; k >= 0; k--) {
            if(arr[k][j] == 1) return false;}
        int row = i-1;
        int col = j-1;
        while(row>=0 && col>=0){
            if(arr[row--][col--] == 1) return false;  }
        
        while(i>=0 && j<idx){
            if(arr[i--][j++]==1) return false;}

        return true;
    }
    // nosleeep
}