class Solution {
    public boolean stoneGame(int[] piles) {
        return solve(piles , 0, 0) >= 0;
    }

    int solve(int[] arr , int left, int right){
        if(left == right) return arr[left];

        int first = arr[left] - solve(arr , left+1 , right);
        int second = arr[right] - solve(arr , left , right+1);

        return Math.max(first , second);
    }
}