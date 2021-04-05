import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class LevelOrderTraversal {
  public static List<List<Integer>> traverse(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if(root == null){
      return result; 
    }
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);

    while(!q.isEmpty()){
      int levelSize = q.size();
      List<Integer> currentLevel = new ArrayList<>(levelSize);

      for(int i = 0; i < levelSize; i++){
        TreeNode currentNode = q.poll();
        currentLevel.add(currentNode.val);
        if(currentNode.left != null){
          q.offer(currentNode.left);
        }
        if(currentNode.right != null){
          q.offer(currentNode.right);
        }
        result.add(currentLevel);
      }
    }
    return result;
  }
//Time Complexity O(n)
//Space Complelxity O(n)
  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    List<List<Integer>> result = LevelOrderTraversal.traverse(root);
    System.out.println("Level order traversal: " + result);
  }
}
