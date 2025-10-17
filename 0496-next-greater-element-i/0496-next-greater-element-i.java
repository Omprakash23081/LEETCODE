class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        Map<Integer , Integer> map = new HashMap<>();
        for(int i=0 ;i<nums1.length ;i++){
            map.put(nums1[i] , i);
        }

        for(int i= nums2.length-1 ; i>=0 ; i--){
            if(map.containsKey(nums2[i])){ 
                int idx = map.get(nums2[i]);
                if(st.isEmpty()){
                    nums1[idx] = -1;
                }
                else if(st.peek()>nums2[i]){ 
                    nums1[idx] = st.peek();
                } else{
                    while(!st.isEmpty() && st.peek()<nums2[i]) st.pop();
                     if(st.isEmpty()){
                        nums1[idx] = -1;
                     }else{
                        nums1[idx] = st.peek();
                     }
                }
            }
            while(!st.isEmpty() && st.peek()<nums2[i]) st.pop();
            st.push(nums2[i]);
        }
        return nums1;
    }
}