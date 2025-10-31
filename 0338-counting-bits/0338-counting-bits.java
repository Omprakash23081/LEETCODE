class Solution {
    public int[] countBits(int n) {
        int[] lookup = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            lookup[i] = lookup[i >> 1] + (i & 1);
        }
        return lookup;
    }
}
// int arr[] = new int[n + 1];
// int j = 1;
// int count =4;
// int temp=0;
// arr[0]=0;
// for (int i = 1; i <= n; i++) {
//    if(i%count==0){
//      arr[i]=1;
//    }
//    else if((i+1)%count==0){
//      arr[i] = i/count+2+temp;
//    }else{
//      arr[i]=i/count+1+temp;
//    }
//    if(i>=count){
//      count = count*2;
//      temp++;
//    }
// }
// return arr;