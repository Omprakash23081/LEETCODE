class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int arr[] = new int[1001];
        for(int v : nums1) arr[v]++;
        List<Integer> li = new ArrayList<>();
        for(int v : nums2){
            if(arr[v]>0) li.add(v);
            arr[v] = 0;
        }
        int res[] = new int[li.size()];
        for(int i=0 ;i<li.size() ;i++) res[i] = li.get(i);
        return res;
    }
}