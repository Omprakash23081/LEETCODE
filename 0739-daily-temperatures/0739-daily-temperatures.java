class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        Stack<Integer> idx = new Stack<>();
        int n = temperatures.length;
        int res[] = new int[n];
        int remove =0;
        for (int i = n - 1; i >= 0; i--) {
            if (st.isEmpty()) {
                res[i] = 0;
            } else if (st.peek() > temperatures[i]) {
                res[i] = 1;
            } else if (st.peek() <= temperatures[i]) {
                while(!(st.isEmpty()) && st.peek()<=temperatures[i]){
                    st.pop();
                    idx.pop();
                }
                if(st.isEmpty()) res[i] = 0;
                else res[i] = idx.peek()-i;
            }
            st.add(temperatures[i]);
            idx.add(i);
        }
        return res;
    }
}