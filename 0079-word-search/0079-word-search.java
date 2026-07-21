class Solution {
    int x[] = {0 , 0 , 1 , -1};
    int y[] = {1 , -1 , 0 , 0};
    boolean visited[][];
    public boolean exist(char[][] arr, String word) {
        visited = new boolean[arr.length][arr[0].length];
        for(int i =0 ; i<arr.length; i++){
            for(int j =0 ; j<arr[0].length ;j++){
                if(solve(arr , word , i , j , 0))return true;
            }
        }
        return false;
    }

    boolean solve(char arr[][] , String st , int i , int j , int idx){
        int n = arr.length;
        int m = arr[0].length;
        if(idx >= st.length() || (idx == st.length()-1 && arr[i][j] == st.charAt(idx))) return true;

        if(i >= n || j>= m || i<0 || j<0){
            return false;
        }

        if(arr[i][j] != st.charAt(idx)) return false;
        boolean res = false;

        visited[i][j] = true;

        for(int v =0 ; v<4 ; v++){
            int nx = x[v]+i;
            int ny = y[v]+j;

            if(nx >= n || ny>= m || nx<0 || ny<0) continue;

            if(arr[i][j] == st.charAt(idx) && !visited[nx][ny]) {
                res = (res || solve(arr , st , nx , ny , idx+1));
            }

            if(res) return res;    
        }
        visited[i][j] = false;
        return false;     
    }
}