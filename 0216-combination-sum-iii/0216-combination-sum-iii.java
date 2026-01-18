class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> li = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(li , temp , 0 , k , n , 1);
        return li;
    }

    private void solve(List<List<Integer>> li , List<Integer> temp , int sum , int k  , int n ,int idx){
        if(temp.size()>=k && sum == n){
            li.add(new ArrayList<>(temp));
            return ;
        }
        if(temp.size()>= k) return ;

        for(int i  = idx ; i<10 ; i++){
            int size = temp.size();
            if(size>0 && temp.get(size-1) == i) continue;
            temp.add(i);
            solve(li , temp , sum+i , k , n , i);
            temp.remove(temp.size()-1);
        }
    }
}