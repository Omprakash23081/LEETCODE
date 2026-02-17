class Solution {
    int max = -1;

    public int longestCycle(int[] edges) {

        int n = edges.length;

        boolean[] visited = new boolean[n];
        boolean[] pathVisited = new boolean[n];
        int[] depth = new int[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, edges, visited, pathVisited, depth, 0);
            }
        }

        return max;
    }

    private void dfs(int node, int[] edges,boolean[] visited, boolean[] pathVisited, int[] depth, int d) {

        visited[node] = true;
        pathVisited[node] = true;
        depth[node] = d;

        int next = edges[node];

        if (next != -1) {

            if (!visited[next]) {
                dfs(next, edges, visited, pathVisited, depth, d + 1);
            } else if (pathVisited[next]) {
                max = Math.max(max, (depth[node] - depth[next]) + 1);
            }
        }

        pathVisited[node] = false;
    }
}
