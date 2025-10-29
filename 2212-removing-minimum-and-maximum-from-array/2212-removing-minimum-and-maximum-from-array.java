class Solution {
    public int minimumDeletions(int[] nums) {
        int min = Integer.MAX_VALUE , max = Integer.MIN_VALUE;
        int minIdx = 0 , maxIdx=0 , n = nums.length-1;
        for(int i=0 ; i<=n ; i++){
            if(nums[i]>max){
                max = nums[i];
                maxIdx = i;
            }
            if(nums[i]<min){
                min = nums[i];
                minIdx = i;
            }
        }
        //when both min nad max at same location
        if(maxIdx==minIdx)return minIdx+1;

        //same side
        int sam = Math.min(n-Math.min(minIdx,maxIdx) , Math.max(minIdx , maxIdx))+1;

        //diff side
        int diff = Math.min(minIdx , maxIdx) + Math.min(n-minIdx , n-maxIdx) + 2;

        return  Math.min(sam , diff);
    }
}