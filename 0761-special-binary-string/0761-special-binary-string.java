class Solution {
    public String makeLargestSpecial(String s) {
        return solve(s);
    }

    String solve(String s){
        if(s.length()==0) return ""; 
        List<String> li = new ArrayList<>();
        int start = 0;
        int sum = 0;
       
        for(int i = 0 ; i<s.length() ; i++){
            sum += s.charAt(i) == '1' ? 1 : -1;
            if(sum==0){
                li.add("1" + solve(s.substring(start+1 , i))+"0");
                start = i+1;
            }
        }

        li.sort((a, b) -> b.compareTo(a));
        StringBuilder st = new StringBuilder();
        
        for(String string : li) st.append(string);
        return st.toString();
    }
}