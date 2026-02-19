class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int idx = -1;
        int sum1 = 0;
        int sum2 = 0;
        for(int i =0 ; i<cost.length; i++){
            sum1 += gas[i];
            sum2 += cost[i];
        }
        if(sum2>sum1)return -1;

        int ans = 0;
        int costs = 0;
        for(int i =0 ; i<gas.length ; i++){
            costs += gas[i] - cost[i];
            if(costs < 0){
                costs = 0;
                ans = i+1;
            }
        }
        return ans;
    }
}