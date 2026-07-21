class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> li = new ArrayList<>();
        int ch[][] = new int[n][n];
        solve(li , n , 0 , ch);
        return li;
    }

    void solve(List<List<String>> li , int n , int i , int arr[][]){
        if(n==0){
            List<String> res = new ArrayList<>();
            for(int ch[] : arr){
                StringBuilder st = new StringBuilder();
                for(int v : ch){
                    if(v == 1)
                        st.append("Q");
                    else st.append(".");    
                }
                res.add(st.toString());
            }
            li.add(res);
            return;
        }

        if(i >= arr.length) return;

        for(int idx = 0 ; idx<arr.length ; idx++){
            if(isSafe(arr , i , idx)){
                arr[i][idx] = 1;
                solve(li , n-1 , i+1 , arr);
                arr[i][idx]= 0;
            }
        }
    }

    boolean isSafe(int arr[][] , int i , int j){
        int r=i;
        int c = j;

        while(r>=0){
            if(arr[r][c] == 1) return false;
            r--;
        }

        r = i;
        c = j;

        while(r >=0 &&  c>=0){
            if(arr[r--][c--] == 1) return false;
        }

        while(i>=0 && j<arr[0].length){
            if(arr[i][j]== 1) return false;
            i--;
            j++;
        }

        return true;
    }
}