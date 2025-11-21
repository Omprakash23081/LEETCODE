// // class Solution {
// //     public int countPalindromicSubsequence(String s) {
// //         StringBuilder st = new StringBuilder();
// //         return solve(s , st , 0);
// //     }

// //     private int solve(String s , StringBuilder st , int idx){
// //         if(st.length()>=3){
// //             if(isPlandrom(st)) return 1;
// //             else return 0;
// //         }
// //         if(idx>=s.length()) return 0;
// //         int ans =0;
// //         for(int i = idx ; i<s.length() ; i++){
// //             if(i>idx && s.charAt(i)==s.charAt(idx)) continue;
// //             ans += solve(s , st.append(s.charAt(idx)) , i);
// //             st.deleteCharAt(st.length()-1); 
// //         }
// //         // int x = solve(s , st.append(s.charAt(idx)) , idx+1);
// //         // int y = solve(s , st , idx+1);
// //         return ans;
// //     }

// //     private boolean isPlandrom(StringBuilder st){
// //         int left =0 , right = st.length()-1;
// //         while(left<right){
// //             if(st.charAt(left) != st.charAt(right)) return false;
// //             left++;
// //             right--;
// //         }
// //         return true;
// //     }
// // }


// class Solution {
//     Map<String , int[]> map = new HashMap<>();
//     public int countPalindromicSubsequence(String s) {
//         StringBuilder st = new StringBuilder();
//         return solve(s , st , 0);
//     }

//     private int solve(String s , StringBuilder st , int idx){
//         if(st.length()>=3){
//             if(isPlandrom(st)) return 1;
//             return 0;
//         }
//         if(idx>=s.length()) return 0;

//         String key = st.toString();
//         if(map.containsKey(key) && map.get(key)[0]==idx) return map.get(key)[1]; 
//         int x = 0;
//         if(idx==0 || (idx>0 && s.charAt(idx)!=s.charAt(idx-1))){
//              x = solve(s , st.append(s.charAt(idx)) , idx+1);
//         }
//         if(st.length()>0)
//             st.deleteCharAt(st.length()-1);  
//         int y = solve(s , st , idx+1);

//         map.put(new String(st) , new int[]{idx , x+y});
//         return x + y;
//     }

//     private boolean isPlandrom(StringBuilder st){
//         int left =0 , right = st.length()-1;
//         while(left<right){
//             if(st.charAt(left) != st.charAt(right)) return false;
//             left++;
//             right--;
//         } 
//         return true;
//     }
// }


class Solution{
    public int countPalindromicSubsequence(String s){
        int ans = 0;
        for(char ch = 'a' ; ch<= 'z' ; ch++){
            int left = s.indexOf(ch);
            int right = s.lastIndexOf(ch);

            if(left==-1 || right == -1 || right-left<2) continue;

            boolean arr[] = new boolean[26];
            for(int i = left+1 ; i<right ; i++) arr[s.charAt(i)-'a'] = true;

            for(boolean b : arr){
                if(b) ans++;
            }
        }
        return ans; 
    }
}