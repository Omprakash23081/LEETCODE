class Solution {
    public boolean predictTheWinner(int[] nums) {
       return solve(nums , 0 , nums.length-1 , true , 0 , 0);
    }

    boolean solve(int arr[] , int s , int e , boolean flag , int s1 , int s2){
        if(s > e) return s1 >= s2;

        if(flag){
            return solve(arr , s+1 , e , false , s1 + arr[s] , s2)
            || solve(arr , s , e-1 , false , s1 + arr[e] , s2);
        }else{
            return solve(arr , s+1 , e , true , s1 , s2 + arr[s])
            && solve(arr , s , e-1 , true , s1 , s2 + arr[e]);
        }
    }
} 