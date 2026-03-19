class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean visited[][] = new boolean[n][m];
        Queue<int[]> qu = new LinkedList<>();

        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<m ; j++){
                if(mat[i][j]==0) {
                    qu.add(new int[]{i , j , 0});
                    visited[i][j] = true;
                }
            }
        }

        while(!qu.isEmpty()){
            int temp[] = qu.poll();
            int i = temp[0];
            int j = temp[1];
            int wat = temp[2];

            if(i+1<n && !visited[i+1][j]){
                mat[i+1][j] = wat+1;
                qu.add(new int[]{i+1 , j , wat+1});
                visited[i+1][j] = true;
            }
            if(i-1>=0 && !visited[i-1][j]){
                mat[i-1][j] = wat+1;
                qu.add(new int[]{i-1 , j , wat+1});
                visited[i-1][j] = true;
            }
            if(j+1<m && !visited[i][j+1]){ 
                mat[i][j+1] = wat+1;
                qu.add(new int[]{i , j+1 , wat+1});
                visited[i][j+1] = true;
            }
            if(j-1>=0 && !visited[i][j-1]){
                mat[i][j-1] = wat+1;
                qu.add(new int[]{i , j-1 , wat+1});
                visited[i][j-1] = true;
            }
        }
        return mat;
    }
}