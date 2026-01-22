class Solution {
    public int maxIceCream(int[] costs, int coins) {
       Arrays.sort(costs);
        int count  = 0;
       for(int v : costs){
            if(coins>=v){
                coins -= v;
                count++;
            }
       }
       return count;
    }

    // private int solve(int[] costs, int coins , int idx , int count){
    //    if (coins == 0 || idx >= costs.length) return count;

    //     int take = 0;
    //     if(coins >= costs[idx])
    //         take = solve(costs , coins-costs[idx] , idx+1 , count+1);
    //     int notTake = solve(costs , coins , idx+1 , count);

    //     return take > notTake ? take : notTake;
    // }
}