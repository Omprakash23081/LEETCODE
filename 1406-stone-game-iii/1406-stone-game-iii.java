class Solution {
    Integer[] dp;
    public String stoneGameIII(int[] arr) {
        dp = new Integer[arr.length];
        // int p1 = 0;
        // int p2 = 0;

        // int i = 0;
        // while(i < arr.length){
        //     int sum = Integer.MIN_VALUE;
        //     int temp = 0;
        //     int idx = i;

        //     for(int j = i ; j < i+3 && j<arr.length; j++){
        //         temp += arr[j];
        //         if(temp > sum){
        //             sum = temp;
        //             idx = j+1;
        //         }
        //     }
        //     p1 += (sum == Integer.MIN_VALUE ? 0 : sum);
        //     i = idx;
        //     System.out.println(idx + " "+sum);

        //     sum = Integer.MIN_VALUE;
        //     temp = 0;

        //     for(int j = i ; j < i+3 && j<arr.length; j++){
        //         temp += arr[j];
        //         if(temp > sum){
        //             sum = temp;
        //             idx = j+1;
        //         }
        //     }
        //     i = idx;
        //     p2 += (sum == Integer.MIN_VALUE ? 0 : sum);
        //     System.out.println(idx + " "+sum + " "+i);
        // }
        int res = solve(arr , 0);
        return res >= 0 ? (res == 0 ? "Tie" : "Alice") : "Bob";
    }

    int solve(int arr[] , int idx){
        if(idx >= arr.length) return 0;

        if(dp[idx] != null) return dp[idx];
        
        int ans = Integer.MIN_VALUE;
        int take = 0;

        for(int i = idx; i<Math.min(idx+3 , arr.length); i++){

           take += arr[i];

           ans = Math.max(ans , take - solve(arr , i+1));
        }

        return dp[idx] = ans;
    }
}