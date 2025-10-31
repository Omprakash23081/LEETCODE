class Solution {
    public int countPrimes(int n) {
         if (n <= 2) {
            return 0; // Primes are greater than 1, so for n=0, 1, 2, there are no primes less than n.
        }

        // Create a boolean array "is_prime[0..n-1]" and initialize all entries it as true.
        // A value in is_prime[i] will finally be false if i is Not a prime, else true.
        boolean[] is_prime = new boolean[n];
        for (int i = 2; i < n; i++) {
            is_prime[i] = true;
        }

        // Start from 2, mark multiples of prime numbers as false.
        for (int p = 2; p * p < n; p++) {
            // If is_prime[p] is still true, then it is a prime
            if (is_prime[p]) {
                // Mark all multiples of p as false
                for (int i = p * p; i < n; i += p) {
                    is_prime[i] = false;
                }
            }
        }

        // Count prime numbers
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (is_prime[i]) {
                count++;
            }
        }
        return count;
    }
}