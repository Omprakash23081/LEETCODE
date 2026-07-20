class Solution {
    Map<Integer , String> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        map.put(2 , "abc");
        map.put(3 , "def");
        map.put(4 , "ghi");
        map.put(5 , "jkl");
        map.put(6 , "mno");
        map.put(7 , "pqrs");
        map.put(8 , "tuv");
        map.put(9 , "wxyz");

        List<String> li = new ArrayList<>();
        solve(li , digits, 0 , "");
        return li;
    }

    void solve(List<String> li , String d , int idx , String s){
        if(idx >= d.length()){
            li.add(new String(s));
            return;
        }

        String st = map.get(Integer.parseInt(d.charAt(idx)+""));
        for(char ch : st.toCharArray()){
            solve(li , d , idx+1 , s+ch);
        }

    }
}