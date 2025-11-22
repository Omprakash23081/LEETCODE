class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = potions.length;

        for(int i=0 ; i<spells.length ; i++){
            int idx = -1;
            int left = 0, right = n-1;

            while(left <= right){

                int mid = (left + right) / 2;
                long temp = (long) spells[i] * potions[mid];

                if(temp >= success){
                    idx = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            if(idx == -1) spells[i] = 0;
            else spells[i] = n - idx;
        }

        return spells;
    }
}
