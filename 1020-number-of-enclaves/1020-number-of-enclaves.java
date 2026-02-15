class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> qu = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || j == n - 1 || i == m - 1 || j == 0) && grid[i][j] == 1) {
                    qu.add(new int[] { i, j });
                    grid[i][j] = -1;
                }
            }
        }

        while (!qu.isEmpty()) {
            int arr[] = qu.poll();
            int i = arr[0];
            int j = arr[1];

            if (i + 1 < m && grid[i + 1][j] == 1) {
                qu.add(new int[] { i + 1, j });
                grid[i + 1][j] = -1;
            }
            if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                qu.add(new int[] { i - 1, j });
                grid[i - 1][j] = -1;
            }
            if (j + 1 < n && grid[i][j + 1] == 1) {
                qu.add(new int[] { i, j + 1 });
                grid[i][j + 1] = -1;
            }
            if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                qu.add(new int[] { i, j - 1 });
                grid[i][j - 1] = -1;
            }
        }

        int count  = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}