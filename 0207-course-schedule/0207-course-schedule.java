class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0) return true;
        int freq[] = new int[numCourses];
        List<List<Integer>> li = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        for(int arr[] : prerequisites) freq[arr[1]]++;

        for(int i =0 ; i< numCourses ; i++) li.add(new ArrayList<>());

        for(int arr[] : prerequisites) li.get(arr[0]).add(arr[1]);

        for(int i =0 ; i<numCourses ; i++) if(freq[i]==0) st.push(i);

        if(st.isEmpty()) return false;

        int count = 0;

        while(!st.isEmpty()){
            int v = st.pop();  
            for(int val : li.get(v)){
                freq[val]--;
                if(freq[val]== 0) st.push(val);
            }
            count++;
        }

        return count == numCourses ? true : false;
    }
}