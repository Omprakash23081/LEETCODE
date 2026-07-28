class Solution {
    public int[] singleNumber(int[] nums) {
         // Step 1: XOR all elements to get the XOR sum of the two unique numbers (xorSum)
        int xorSum = 0;
        for (int num : nums) {
            xorSum ^= num;
        }

        // Step 2: Find a distinguishing bit (rightmost set bit) in xorSum
        // This bit will be different between the two unique numbers.
        int distinguishingBit = xorSum & (-xorSum); 
        // Alternatively: distinguishingBit = xorSum & (~xorSum + 1);

        // Step 3: Partition the numbers into two groups based on the distinguishing bit
        // One group will have the distinguishing bit set, the other will not.
        int num1 = 0;
        int num2 = 0;
        for (int num : nums) {
            if ((num & distinguishingBit) == 0) {
                // Number does not have the distinguishing bit set
                num1 ^= num;
            } else {
                // Number has the distinguishing bit set
                num2 ^= num;
            }
        }

        // Step 4: num1 and num2 now hold the two unique numbers
        return new int[]{num1, num2};
    }
}