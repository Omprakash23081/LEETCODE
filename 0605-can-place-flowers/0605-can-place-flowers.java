class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int l= flowerbed.length;
        if(l==1 && flowerbed[0]==0 && n==1) return true;
        int count = 0;
        int arr[] = flowerbed;
        if(l>1 && arr[0]==0 && arr[1]==0){
            n--;
            arr[0] = 1;
        }
        for(int i =1 ; i<l-1 ; i++){
            if(arr[i]==1) continue;
            if(i>0 && arr[i-1]==0 && arr[i+1]==0){
                n--;
                arr[i]= 1;
            }
        }
        if(l>1 && arr[l-1]==0 && arr[l-2]==0) n--;
        return n<=0 ? true : false;
    }
}