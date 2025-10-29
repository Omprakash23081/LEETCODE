class Solution {
    public int maxFrequencyElements(int[] nums) {
      int arr[] = new int[101];
      for(int v : nums) arr[v]++;
      int maxFreq = 0;
      for(int i=0 ; i<=100 ;i++) if(arr[i]>maxFreq) maxFreq= arr[i];
      int res =0;
      for(int v : nums) if(arr[v]==maxFreq) res++;
      return res;  
    }
}