class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int grid[][] = mat;
        int m = grid.length;
        int n = grid[0].length;
        int arr[][] = new int[m][n];
        boolean visited[][] = new boolean[m][n];
        Queue<int[]> qu = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    qu.add(new int[] { i, j, 0 });
                    visited[i][j] = true;
                }
            }
        }

        while (!qu.isEmpty()) {
            int temp[] = qu.poll();
            int i = temp[0];
            int j = temp[1];
            int wat = temp[2];

            if (i + 1 < m && !visited[i + 1][j]) {
                arr[i + 1][j] = wat + 1;
                qu.add(new int[] { i + 1, j, wat + 1 });
                visited[i + 1][j] = true;
            }
            if (i - 1 >= 0 && !visited[i - 1][j]) {
                arr[i - 1][j] = wat + 1;
                qu.add(new int[] { i - 1, j, wat + 1 });
                visited[i - 1][j] = true;

            }
            if (j + 1 < n && !visited[i][j + 1]) {
                arr[i][j + 1] = wat + 1;
                qu.add(new int[] { i, j + 1, wat + 1 });
                visited[i][j + 1] = true;

            }
            if (j - 1 >= 0 && !visited[i][j - 1]) {
                arr[i][j - 1] = wat + 1;
                qu.add(new int[] { i, j - 1, wat + 1 });
                visited[i][j - 1] = true;
            }
        }
        return arr;
    }
}