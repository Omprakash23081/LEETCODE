class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char arr[] = new char[26];
        for(char ch  : s.toCharArray()){
            int temp = ch-97;
            arr[temp]++;
        } 
        for(char ch : t.toCharArray()){
            int idx = ch - 97;
            if(arr[idx]==0)return false;
            else arr[idx]--;
        }
        return true;
    }
}