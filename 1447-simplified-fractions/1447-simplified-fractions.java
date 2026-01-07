class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String> li = new ArrayList<>();
        Set<Float> set = new HashSet<>();
        for(int i= 1  ; i<n ; i++){
            for(int j=2 ; j<=n ; j++){
                float f = (float)i/j;
                if(f>0 && f<1 && set.add(f)){
                    String st = i + "/" + j;
                    li.add(st);
                }
            }
        }
        return li;
    }
}