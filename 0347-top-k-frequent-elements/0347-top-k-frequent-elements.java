class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int v : nums) {
            map.put(v, map.getOrDefault(v, 0) + 1);
        }
        Queue<Integer> qu = new PriorityQueue<>(Collections.reverseOrder());

        for (int v : map.values()) {
            qu.add(v);
        }

        int res[] = new int[k];
        int small = Integer.MAX_VALUE;
        for(int i =0 ; i<k ; i++){
            int temp = qu.poll();
            if(temp<small) small = temp;
        }

        int i = 0;
        for(int val : map.keySet()){
            int temp = map.get(val);
            if(temp>=small)res[i++]= val;
        }

        return res;
    }
}