class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int l = 0;
        int r = n-1;
        int lmax = arr[0];
        int rmax = arr[n-1];
        int res = 0;

        while(l <= r){
            lmax = Math.max(lmax , arr[l]);
            rmax = Math.max(rmax , arr[r]);
            if(arr[l] > arr[r]){
                int hdiff = Math.min(lmax , rmax) - arr[r];
                if(hdiff > 0)
                    res += hdiff;
                r--;
            }else{
                int hdiff = Math.min(lmax , rmax) - arr[l];
                if(hdiff > 0)
                    res += hdiff;
                l++;
            }
        }
        return res;
    }
}