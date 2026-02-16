class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> li = new ArrayList<>();
        int n = s.length();

        int arr[] = new int[26];
        Arrays.fill(arr , -1);

        for(int i = n-1 ; i>=0 ; i--){
            char ch = s.charAt(i);
            if(arr[ch-'a']==-1) arr[ch-'a'] = i;
        }

        int i = 0;

        while(i < n){
           int max = -1;
           int start = i;
           int idx = arr[s.charAt(i)-'a'];
        //    System.out.println(s.charAt(i));	
           for( ; i<= idx; i++){
             max = Math.max(max , arr[s.charAt(i)-'a']);
             if(max > idx) idx = max;
           }
        //    System.out.println(max);	
           if(max >= i) i = max+1;
           li.add((max - start)+1);
        }
        return li;
    }
}