class Solution {
    public boolean isIsomorphic(String s, String t) {
        int arr1[] = new int[256];
        int arr2[] = new int[256];
        for(int i =0 ; i< 256; i++) {
            arr1[i] = -1;
            arr2[i] = -1;
        }
        for(int i=0 ; i<s.length() ; i++){
            int idx1 = s.charAt(i);
            int idx2 = t.charAt(i);
            
            if(arr1[idx1]==-1 && arr2[idx2]==-1){
                arr1[idx1]= idx2; 
                arr2[idx2] = idx1; 
            }
            
            else if((arr2[idx2] != idx1 || arr1[idx1] != idx2)) return false;
        }
        return true;
    }
}