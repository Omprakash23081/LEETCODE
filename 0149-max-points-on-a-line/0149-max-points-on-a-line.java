class Solution {
    public int maxPoints(int[][] arr) {
        int max = 1;

        for(int i =0 ; i<arr.length; i++){
            for(int j = i+1; j<arr.length; j++){
                int count = 2;
                int dx = arr[i][0] - arr[j][0];
                int dy = arr[i][1] - arr[j][1];

                for(int k = 0 ; k<arr.length ; k++){
                    if(k == i || k == j) continue;

                    int dx_ = arr[i][0] - arr[k][0];
                    int dy_ = arr[i][1] - arr[k][1];

                    if((dx * dy_) == (dy * dx_)) count++;
                }
                max = Math.max(max , count);
            }
        }
        return max;
    }
} 