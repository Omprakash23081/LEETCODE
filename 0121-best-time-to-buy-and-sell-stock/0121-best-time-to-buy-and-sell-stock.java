class Solution {
    public int maxProfit(int[] prices) {
        int bay =prices[0];
        int profit=0;
        for(int v: prices){
            if(bay>v){
                bay=v;
            }else{
               profit = Math.max(profit ,v-bay);  
            }    
         }
         return profit;
    }
}