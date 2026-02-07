class Solution {
    public int minimumDeletions(String s) {
        int Tb = 0;
        int Ta = 0;
        int n = s.length();

        for(char ch : s.toCharArray()) if(ch=='b') Tb++;

        if(Tb == n) return 0;

        Ta = n - Tb;

        int res = Integer.MAX_VALUE;
        int a = 0;
        int b = 0;

        for(int i = 0 ; i< n ; i++){
            char ch = s.charAt(i);
            if(ch=='a')a++;
            else b++;

            int temp = a + (Tb - b);

            res = Math.min(res , n - temp);
        }

        return res > Ta ? Ta : res;
    }
}