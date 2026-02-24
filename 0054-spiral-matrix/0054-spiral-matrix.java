class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> li = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int min = Math.min(m/2 , n/2);
        int count  = 0;
        for(int i =0 ; i<=min ; i++){
            for(int j =i ; j<n-i ; j++) {
                li.add(matrix[i][j]);
                count++;
            }

            if(count == m*n) break;
            for(int j = i+1 ; j<m-i ; j++){
                li.add(matrix[j][n-i-1]); 
                count++;
            }
            if(count == m*n) break;

            for(int j = n-i-2 ; j >= i ; j--) {
                li.add(matrix[m-i-1][j]); 
                count++;
            }
            if(count == m*n) break;
 
            for(int j = m-i-2 ; j > i ; j--) {
                li.add(matrix[j][i]);
                count++;
            }
            if(count == m*n) break;
        }
        return li;
    }

    // void solve(int arr[][] , int i , int j){
    //     if(i>=arr.length || i<0 || j>=arr[0].length || j<0) return;
    //     if(visited[i][j]) return;

    //     visited[i][j] = true;

    //     li.add(arr[i][j]);
    //     solve(arr , i , j+1);
    //     solve(arr , i+1 , j);
    //     solve(arr , i , j-1);
    //     solve(arr , i-1 , j);
    // }
}