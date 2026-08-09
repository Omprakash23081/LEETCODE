class Solution {

    public List<Integer> remainingMethods(
            int n,
            int k,
            int[][] invocations) {

        Set<Integer> li = new HashSet<>();
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] arr : invocations) {
            int u = arr[0];
            int v = arr[1];

            list.get(u).add(v);
        }

        boolean[] visited = new boolean[n];

        getAllss(list, k, visited);

        for (int[] arr : invocations) {

            int u = arr[0];
            int v = arr[1];

            if (!visited[u] && visited[v]) {

                List<Integer> ans = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    ans.add(i);
                }

                return ans;
            }
        }

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {
                li.add(i);
            }
        }

        return new ArrayList<>(li);
    }

    void getAllss(List<List<Integer>> li, int v, boolean[] visited) {

        if (visited[v])
            return;

        visited[v] = true;

        for (int val : li.get(v)) {
            getAllss(li, val, visited);
        }
    }
}