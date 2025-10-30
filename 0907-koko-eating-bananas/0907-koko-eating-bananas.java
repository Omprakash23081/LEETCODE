class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1 ;
        int right =  Arrays.stream(piles).max().getAsInt();;
        while(left<right){
            int mid = left + (right-left)/2;
            int sum = solve(piles , mid);
            if(sum>h) left = mid+1;
            else right = mid;
        }
        return right;
    }

    private int solve(int arr[] , int k){
        int totalTime = 0;
        for(int v : arr){
            totalTime += Math.ceil((double)v/k);
        }
        return totalTime;
    }
}