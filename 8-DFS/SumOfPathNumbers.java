class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x){
        val = x;
    }
};

class SumOfPathNumbers{
    public static int findSumOfPathNumbers(TreeNode root){
        return dfs(root, 0);
    }

    private static int dfs(TreeNode root, int sum){
        if(root == null) {
            return 0;
        }

        sum = 10 * sum + root.val;

        if(root.right == null && root.left == null){
            return sum;
        }

        return dfs(root.right, sum) + dfs(root.left, sum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
      }
}