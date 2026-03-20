class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int freq[] = new int[numCourses];
        List<List<Integer>> li = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[numCourses];

        for (int arr[] : prerequisites)
            freq[arr[1]]++;

        for (int i = 0; i < numCourses; i++)
            li.add(new ArrayList<>());

        for (int arr[] : prerequisites)
            li.get(arr[0]).add(arr[1]);

        for (int i = 0; i < numCourses; i++)
            if (freq[i] == 0)
                st.push(i);

        int count = 0;

        while (!st.isEmpty()) {
            int v = st.pop();
            for (int val : li.get(v)) {
                freq[val]--;
                if (freq[val] == 0)
                    st.push(val);
            }
            ans[count++] = v;
        }
        count = 0;
        for(int v : ans) if(v==0) count++;

        if(count > 1) return new int[]{};

        int left = 0;
        int right = numCourses - 1;
        while (left < right) {
            int temp = ans[left];
            ans[left] = ans[right];
            ans[right] = temp;
            left++;
            right--;
        }

        return ans;  
    }
}