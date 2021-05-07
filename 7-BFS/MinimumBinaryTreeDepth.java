import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x){
        val = x;
    }
};

class MinimumBinaryTreeDepth{
    public static int findDepth(TreeNode root){
        int result = 0;

        if(root == null){
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){ 
            result++;

            int levelSize = q.size();

            for(int i = 0; i < levelSize; i++){
                TreeNode currentNode = q.poll();

                if(currentNode.left == null && currentNode.right == null){
                    return result;
                }

                if(currentNode.left != null){
                    q.add(currentNode.left);
                }

                if(currentNode.right != null){
                    q.add(currentNode.right);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
        root.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);
        System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
      }
}