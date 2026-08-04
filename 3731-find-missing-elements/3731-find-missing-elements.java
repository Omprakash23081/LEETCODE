class Solution {
    public List<Integer> findMissingElements(int[] arr) {
        Arrays.sort(arr);

        List<Integer> li = new ArrayList<>();

        for(int i = 1 ; i<arr.length; i++){
            if(arr[i]-1 != arr[i-1]){
                for(int j = arr[i-1]+1 ; j<arr[i]; j++)li.add(j);
            }
        }
        return li;
    }
}