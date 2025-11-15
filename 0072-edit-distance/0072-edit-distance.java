class Solution {
    public int minDistance(String word1, String word2) {
        Integer[][] dp = new Integer[word1.length()][word2.length()];
        return solve(word1, word2, word1.length() - 1, word2.length() - 1, dp);
    }

    private int solve(String word1, String word2, int i, int j, Integer[][] dp) {
        if (i < 0) return j + 1;
        if (j < 0) return i + 1; 
        if (dp[i][j] != null) return dp[i][j];

        if (word1.charAt(i) == word2.charAt(j)) {
            return dp[i][j] = solve(word1, word2, i - 1, j - 1, dp);
        } else {
            return dp[i][j] = 1 + Math.min(
                solve(word1, word2, i, j - 1, dp), 
                Math.min(
                    solve(word1, word2, i - 1, j, dp),
                    solve(word1, word2, i - 1, j - 1, dp)
                )
            );
        }
    }
}
