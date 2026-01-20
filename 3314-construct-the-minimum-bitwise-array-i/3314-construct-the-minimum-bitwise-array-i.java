class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int arr[] = new int[nums.size()];
        int i=0;
        for(int v : nums){
            int j = v | (v+1);
            int res = -1;
            for(int k=1  ; k<=j ; k++){
                if((k | (k+1))==v){
                    res = k;
                    break;
                }
            }
            arr[i++] = res;
        }
        return arr;
    }
}