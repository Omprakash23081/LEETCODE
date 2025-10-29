class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
       int res[] = new int[2];
       int maxCount =0;
        for(int i = 0 ;i<mat.length ;i++){
            int count =0;
            for(int j =0 ; j<mat[0].length ; j++){
                if(mat[i][j]==1) count++;
            }
            if(count>maxCount){
                maxCount = count;
                res[0] = i;
                res[1] = count;
            }
            if(count==mat[0].length)break;
        }
        return res;
    }
}