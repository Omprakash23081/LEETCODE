import java.util.*;

class Solution {
    public int maxSumDivThree(int[] nums) {
        int total = 0;
        ArrayList<Integer> mod1 = new ArrayList<>();
        ArrayList<Integer> mod2 = new ArrayList<>();

        for (int a : nums) {
            total += a;
            int r = a % 3;
            if (r == 1) mod1.add(a);
            else if (r == 2) mod2.add(a);
        }

        if (total % 3 == 0) return total;

        Collections.sort(mod1);
        Collections.sort(mod2);

        int rem = total % 3;
        int option1 = Integer.MAX_VALUE; 
        int option2 = Integer.MAX_VALUE; 

        if (rem == 1) {
            if (!mod1.isEmpty()) option1 = mod1.get(0);
            if (mod2.size() >= 2) option2 = mod2.get(0) + mod2.get(1);
        } else {
            if (!mod2.isEmpty()) option1 = mod2.get(0);
            if (mod1.size() >= 2) option2 = mod1.get(0) + mod1.get(1);
        }

        int toRemove = Math.min(option1, option2);
        if (toRemove == Integer.MAX_VALUE) return 0; 
        return total - toRemove;
    }
}
