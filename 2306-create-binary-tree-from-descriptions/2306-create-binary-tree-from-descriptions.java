class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodes = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] d : descriptions) {
            int parentVal = d[0], childVal = d[1], isLeft = d[2];

            nodes.putIfAbsent(parentVal, new TreeNode(parentVal));

            nodes.putIfAbsent(childVal, new TreeNode(childVal));

            if (isLeft == 1)
                nodes.get(parentVal).left = nodes.get(childVal);
            else
                nodes.get(parentVal).right = nodes.get(childVal);

            children.add(childVal);
        }

        for (int key : nodes.keySet()) {
            if (!children.contains(key))
                return nodes.get(key);
        }

        return null;
    }
}
