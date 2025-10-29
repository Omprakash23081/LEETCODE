class Solution {
    private void heler(int nums[], int s, int mid, int e) {
        int n1 = mid - s + 1; 
        int n2 = e - mid;
        int[] l = new int[n1];
        int[] r = new int[n2];
        for (int i = 0; i < n1; i++) l[i] = nums[i + s];
        for (int j = 0; j < n2; j++) r[j] = nums[j + mid +1]; 
        int i = 0, j = 0, k = s;
        while (i < n1 && j < n2) {
            if (l[i] <= r[j]) nums[k++] = l[i++];
            else  nums[k++] = r[j++];
        }
        while (i < n1) nums[k++] = l[i++]; 
        while (j < n2) nums[k++] = r[j++];
    }

    private void merge(int nums[], int s, int e) {
        if (s < e) {
            int mid = (e + s) / 2;
            merge(nums, s, mid);
            merge(nums, mid + 1, e);
            heler(nums, s, mid, e);
        }
    }

    public int[] sortArray(int[] nums) {
        merge(nums, 0, nums.length-1);
        return nums;
    }
}