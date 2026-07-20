class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> li = new ArrayList<>();
        li.add(0);
        if(n==0) return li;
        li.add(1);
        int mass = 1;
        for(int i = 2 ; i<=n ; i++){
            mass *=2;
            for(int k = li.size()-1 ; k>=0 ; k--){
                li.add(li.get(k)+mass);
            }
        }
        return li;
    }

    void solve(List<Integer> li , StringBuilder s , int n){
        if(n == s.length()){
            li.add(Integer.parseInt(s.toString() , 2));
            return;
        }
        
        s.append(0);
        solve(li , s , n);
        s.deleteCharAt(s.length()-1);
        s.append(1);
        solve(li , s , n);
        s.deleteCharAt(s.length()-1);
    }
}