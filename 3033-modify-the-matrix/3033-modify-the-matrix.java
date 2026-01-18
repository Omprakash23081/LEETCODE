class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int arr[] = new int[n];

        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){
                arr[j] = Math.max(arr[j] , matrix[i][j]);
            }
        }

        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){
               if(matrix[i][j]==-1){
                  matrix[i][j] = arr[j];
               }
            }
        }
        

        return matrix;
    }
}