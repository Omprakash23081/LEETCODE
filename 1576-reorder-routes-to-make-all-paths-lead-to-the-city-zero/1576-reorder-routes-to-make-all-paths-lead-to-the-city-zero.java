class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] c : connections) {
            int u = c[0], v = c[1];
            graph.get(u).add(new int[]{v, 1}); 
            graph.get(v).add(new int[]{u, 0});
        }

        boolean[] visited = new boolean[n];
        return dfs(0, graph, visited);
    }

    private int dfs(int node, List<List<int[]>> graph, boolean[] visited) {
        visited[node] = true;
        int count = 0;

        for (int[] nei : graph.get(node)) {
            int next = nei[0];
            int cost = nei[1];

            if (!visited[next]) {
                count += cost + dfs(next, graph, visited);
            }
        }
        return count;
    } 
}
