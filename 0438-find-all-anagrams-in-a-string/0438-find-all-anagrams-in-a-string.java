class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int map[] = new int[26];
        int arr[] = new int[26];
        List<Integer> li = new ArrayList<>();
        for(char ch : p.toCharArray()) map[ch-'a']++;

        int idx= 0;
        int n = p.length()-1;
        for(int i= 0 ; i<s.length() ; i++){
            arr[s.charAt(i)-'a']++;
            if(i>=n){
                if(isSame(map , arr)) li.add(i-n);
                arr[s.charAt(i-n)-'a']--; 
            }
        }
        return li;
    }

    private boolean isSame(int map[] , int arr[]){
        for(int i =0 ; i<26 ; i++){
            if(map[i] != arr[i]) return false;
        }
        return true;
    }
}