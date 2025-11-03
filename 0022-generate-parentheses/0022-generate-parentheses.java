class Solution {
    List<String> li = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        StringBuilder st = new StringBuilder();
        generateParenthesisHelper(st, n, 0, 0);
        return li;
    }

    private void generateParenthesisHelper(StringBuilder st, int n, int open, int close) {
        if (st.length() == n * 2) {
            li.add(st.toString());
            return;
        }
        if (open < n) {
            st.append("(");
            generateParenthesisHelper(st, n, open + 1, close);
            st.deleteCharAt(st.length()-1);
        }
        if (close < open) {
            st.append(")");
            generateParenthesisHelper(st, n, open, close + 1);
            st.deleteCharAt(st.length() - 1); 
        }
    }
}