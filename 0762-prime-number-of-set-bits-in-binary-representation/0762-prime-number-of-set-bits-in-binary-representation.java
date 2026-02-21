class Solution {
    public int countPrimeSetBits(int left, int right) {
        int res = 0;
        for(int i = left ; i<= right ; i++){
            int temp = i;
            int count = 0;
            while(temp != 0){
                if((temp&1) == 1)count++;
                temp = temp>>1;
            }
            if(isPrime(count))res++;
        }
        return res;
    }

    boolean isPrime(int n){
        if(n==1) return false;
        for(int i = 2 ; i<n ; i++){
            if(n%i==0) return false;
        }
        return true;
    }
}