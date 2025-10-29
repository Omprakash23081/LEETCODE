class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch=='[' || ch=='{' || ch=='('){
                st.push(ch);
            }
            else if(!st.isEmpty() && ch==']' && st.peek()=='['){  
              st.pop();
            }
            else if(!st.isEmpty() && ch=='}' && st.peek()=='{'){
              st.pop();
            }
            else if(!st.isEmpty() && ch==')' && st.peek()=='('){
              st.pop();
            }else 
              return false;
        }
        if(!st.isEmpty())return false;
        return true;
    }
}