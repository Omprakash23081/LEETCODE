class Solution {
    public int maxPoints(int[][] arr) {
        int max = 1;

        for(int i =0 ; i<arr.length; i++){
            Map<Double , Integer> map = new HashMap<>();
            int count = 0;
            for(int j = 0; j<arr.length; j++){
                if(i == j) continue;

                int dx = arr[i][0] - arr[j][0];
                int dy = arr[i][1] - arr[j][1]; 

                double ang = Math.atan2(dx , dy);

                map.put(ang , map.getOrDefault(ang , 1)+1);

                max = Math.max(max , map.get(ang));
            }
        } 
        return max;
    }
} 