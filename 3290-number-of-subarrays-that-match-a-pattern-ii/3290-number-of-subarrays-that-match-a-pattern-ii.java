class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = nums.length;
        int m = pattern.length;
        
        int[] rel = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] > nums[i]) rel[i] = 1;
            else if (nums[i + 1] == nums[i]) rel[i] = 0;
            else rel[i] = -1;
        }

        int[] lps = buildLPS(pattern);
        int i = 0, j = 0, count = 0;

        while (i < rel.length) {
            if (rel[i] == pattern[j]) {
                i++;
                j++;
                if (j == m) {
                    count++;
                    j = lps[j - 1];
                }
            } else {
                if (j > 0) j = lps[j - 1];
                else i++;
            }
        }
        return count;
    }

    private int[] buildLPS(int[] pattern) {
        int m = pattern.length;
        int[] lps = new int[m];
        int len = 0, i = 1;

        while (i < m) {
            if (pattern[i] == pattern[len]) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len > 0) len = lps[len - 1];
                else i++;
            }
        }
        return lps;
    }
}
