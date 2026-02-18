class Solution {
    public int bestClosingTime(String customers) {
        int y = 0;
        int n = customers.length();
        for(char ch  : customers.toCharArray()) if(ch=='Y') y++;
        if(y==n)return n;

        int max = Integer.MAX_VALUE;
        int pn = 0;
        int res = 0;
        for(int i=0 ; i<n ; i++){
            if(y+pn < max){
                max = y+pn;
                res = i;
            }
            // System.out.println(max+" "+i);
            if(customers.charAt(i)=='Y')y--;
            else pn++;
        }
        if(y+pn < max)
            res = n;
        return res;
    }
}