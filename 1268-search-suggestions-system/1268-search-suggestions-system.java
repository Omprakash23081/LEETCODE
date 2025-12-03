class Solution {

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        List<String> suggestions = new ArrayList<>();
    }

    TrieNode root = new TrieNode();

    private void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (cur.next[idx] == null) {
                cur.next[idx] = new TrieNode();
            }
            cur = cur.next[idx];

            // maintain up to 3 lexicographically smallest words
            if (cur.suggestions.size() < 3) {
                cur.suggestions.add(word);
            }
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);

        // Step 1: build Trie
        for (String p : products) insert(p);

        // Step 2: lookup prefix
        List<List<String>> result = new ArrayList<>();
        TrieNode cur = root;

        for (char c : searchWord.toCharArray()) {
            int idx = c - 'a';

            if (cur != null) cur = cur.next[idx];

            if (cur == null) {
                // no more matches
                result.add(new ArrayList<>());
            } else {
                result.add(new ArrayList<>(cur.suggestions));
            }
        }

        return result;
    }
}
