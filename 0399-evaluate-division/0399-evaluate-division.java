class Solution {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, Map<String, Double>> graph = new HashMap<>();

        // Build graph
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());

            graph.get(a).put(b, val);
            graph.get(b).put(a, 1.0 / val);
        }
        
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            res[i] = dfs(start, end, graph, new HashSet<>(), 1.0);
        }

        return res;
    }

    private double dfs(String curr, String target, 
                       Map<String, Map<String, Double>> graph, 
                       Set<String> visited, double product) {

        if (!graph.containsKey(curr)) return -1.0;
        if (curr.equals(target)) return product;

        visited.add(curr);

        for (Map.Entry<String, Double> entry : graph.get(curr).entrySet()) {
            String next = entry.getKey();
            double val = entry.getValue();

            if (!visited.contains(next)) {
                double result = dfs(next, target, graph, visited, product * val);
                if (result != -1.0) return result;
            }
        }

        return -1.0;
    }
}
