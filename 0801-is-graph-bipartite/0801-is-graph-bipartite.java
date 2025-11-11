class Solution {
    private boolean dfs(int[][] graph, int[] color, int node, int currColor) {
        color[node] = currColor;

        for (int neighbor : graph[node]) {
            // If neighbor not colored, color it with opposite color
            if (color[neighbor] == 0) {
                if (!dfs(graph, color, neighbor, -currColor)) return false;
            }
            // If neighbor already has same color → not bipartite
            else if (color[neighbor] == currColor) {
                return false;
            }
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V]; 

        for (int i = 0; i < V; i++) {
            if (color[i] == 0) { 
                if (!dfs(graph, color, i, 1)) return false;
            }
        }

        return true;
    }
}
