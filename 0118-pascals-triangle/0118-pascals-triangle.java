class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> li = new ArrayList<>();

        for(int i = 1 ; i<=numRows ; i++){
            int priv = 1;
            List<Integer> temp = new ArrayList<>();
            for(int j = 1 ; j<=i ; j++){
                temp.add(priv);
                priv = priv * (i-j)/j;
            }
            li.add(temp);
        }

        return li;
    }
}