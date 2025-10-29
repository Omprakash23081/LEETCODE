class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left[] = new int[n];
        int right[] = new int[n];
        int max =height[0];
        for(int i=1 ; i<n ; i++){
            if(height[i]<=max) left[i] = max - height[i];
            else {
                left[i] = 0;
                max = height[i];
            }
        }
        max = height[n-1];
        for(int i = n-2 ; i>=0 ; i--){
            if(height[i]<=max) right[i] = max - height[i];
            else {
                right[i] = 0;
                max = height[i];
            }
        }
        int count =0;
        for(int i=0 ; i<n ; i++){
            left[i] = Math.min(left[i] , right[i]);
            count += left[i];
        }
        return count;
    }
}