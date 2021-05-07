import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x){
        val = x;
    }
};

class FindAllTreePaths{
    public static List<List<Integer>> findPaths(TreeNode root, int sum){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<Integer>();
        dfs(root, sum, current, result);
        return result;
    }

    private static void dfs(TreeNode root, int sum, List<Integer> current, List<List<Integer>> result) {
        if (root == null)
        return;

        current.add(root.val);

        if (root.val == sum && root.left == null && root.right == null) {
            result.add(new ArrayList<Integer>(current));
        } 
        else {

            dfs(root.left, sum - root.val, current, result);
            dfs(root.right, sum - root.val, current, result);
        }
        current.remove(current.size() - 1);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
      }

}