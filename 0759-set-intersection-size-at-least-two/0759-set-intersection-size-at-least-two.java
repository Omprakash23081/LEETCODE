class Solution {
    public int intersectionSizeTwo(int[][] intervals) {

        // Sort: end asc, start desc
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1]) return b[0] - a[0];
            return a[1] - b[1];
        });

        int p1 = -1, p2 = -1; // largest and second largest chosen points
        int count = 0;

        for (int[] in : intervals) {
            int s = in[0], e = in[1];

            boolean p1In = p1 >= s && p1 <= e;
            boolean p2In = p2 >= s && p2 <= e;

            if (p1In && p2In) {
                continue;
            }

            if (p1In) {
                // only p1 inside → add 1 more
                count++;
                p2 = p1;
                p1 = e;
            } else {
                // none inside → add 2 points
                count += 2;
                p2 = e - 1;
                p1 = e;
            }
        }

        return count;
    }
}
