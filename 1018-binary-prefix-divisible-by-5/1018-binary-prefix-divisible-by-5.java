class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> li = new ArrayList<>();
        long v = 0;
        for(int val : nums){
            v = (v<<1) | val;
            v = v%5;
            if(v==0)li.add(true);
            else li.add(false);
        }
        return li;
    }
}