class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int arr[][] = new int[n][2];
        for(int i =0 ; i<n ; i++){
            arr[i][0] = nums1[i];
            arr[i][1] = nums2[i];
        }
        Arrays.sort(arr , (a ,b)-> b[1]-a[1]);

        Queue<Integer> pq = new PriorityQueue<>();
        long sum = 0;
        for(int i=0 ; i<k ; i++){
            pq.add(arr[i][0]);
            sum += arr[i][0];
        }

        long res =sum*arr[k-1][1];
        for(int i = k ; i<n ; i++){
            sum = sum - pq.poll();
            sum += arr[i][0];
            pq.add(arr[i][0]);
            res =Math.max(res , sum*arr[i][1]);
        }
        return res;
    }
}