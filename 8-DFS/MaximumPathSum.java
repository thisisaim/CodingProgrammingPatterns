import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x){
        val = x;
    }
};
class MaximumPathSum{
    private static int globalMax;
    
    public static int findMaxPathSum(TreeNode root){
        globalMax = Integer.MIN_VALUE;
        dfs(root);
        return globalMax;
    }
    
    private static int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
    
        int left = dfs(root.left);
        int right = dfs(root.right);
        int localMax = left + right + root.val;
        globalMax = Math.max(globalMax, localMax);
    
        return Math.max(left, right) + root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaxPathSum(root));
        
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaxPathSum(root));
        
        root = new TreeNode(-1);
        root.left = new TreeNode(-3);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaxPathSum(root));
      }
}
