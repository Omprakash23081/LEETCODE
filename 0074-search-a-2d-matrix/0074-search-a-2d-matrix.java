class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int up = 0;
        int down = matrix.length - 1;
        int n = matrix[0].length - 1;
        int mid = -1;
        while (up <= down) {
            mid = up + (down - up) / 2;
            if (matrix[mid][0] <= target && matrix[mid][n] >= target) {
                break;
            }
            if (matrix[mid][0] > target) {
                down = mid - 1;
            } else {
                up = mid + 1;
            }
        }
        if(mid==-1) return false;
        int left = 0;
        int right = n;
        while(left<=right){
            int md = left +(right-left)/2;
            if(matrix[mid][md]==target) return true;
            if(matrix[mid][md]>target) right=md-1;
            else left=md+1;
        }
        return false;
    }
}