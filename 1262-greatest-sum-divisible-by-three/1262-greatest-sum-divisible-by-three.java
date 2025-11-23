class Solution {
    public int maxSumDivThree(int[] nums) {
        int total = 0;

        int mod10 = Integer.MAX_VALUE, mod11 = Integer.MAX_VALUE;
        int mod20 = Integer.MAX_VALUE, mod21 = Integer.MAX_VALUE;

        for (int a : nums) {
            total += a;
            int r = a % 3;

            if (r == 1) {
                if (a < mod10) {
                    mod11 = mod10;
                    mod10 = a;
                } else if (a < mod11) 
                    mod11 = a;
            }

            else if (r == 2) {
                if (a < mod20) {
                    mod21 = mod20;
                    mod20 = a;
                } else if (a < mod21)
                    mod21 = a;
            }
        }

        if (total % 3 == 0)
            return total;

        int rem = total % 3;
        int option1 = Integer.MAX_VALUE, option2 = Integer.MAX_VALUE;

        if (rem == 1) {
            if (mod10 != Integer.MAX_VALUE)
                option1 = mod10;
            if (mod20 != Integer.MAX_VALUE && mod21 != Integer.MAX_VALUE)
                option2 = mod20 + mod21;
        } else {
            if (mod20 != Integer.MAX_VALUE)
                option1 = mod20;
            if (mod10 != Integer.MAX_VALUE && mod11 != Integer.MAX_VALUE)
                option2 = mod10 + mod11;
        }

        int toRemove = Math.min(option1, option2);
        return total - toRemove;
    }
}
