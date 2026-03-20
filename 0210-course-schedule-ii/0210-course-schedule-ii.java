import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int indegree[] = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] arr : prerequisites) {
            int a = arr[0], b = arr[1];
            graph.get(b).add(a);   
            indegree[a]++;        
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int ans[] = new int[numCourses];
        int index = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            ans[index++] = node;

            for (int nei : graph.get(node)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        if (index != numCourses) {
            return new int[]{}; 
        }

        return ans;
    }
}