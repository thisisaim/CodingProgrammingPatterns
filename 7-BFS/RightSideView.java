import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode (int x){
        val = x;
    }
};


class RightSideView{
    public static List<TreeNode> traverse(TreeNode root){
        List<TreeNode> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int levelSize = q.size();
            for(int i = 0; i < levelSize; i++){
                TreeNode currentNode = q.poll();

                if(i == levelSize - 1){
                    result.add(currentNode);
                }

                if(currentNode.left != null){
                    q.offer(currentNode.left);
                }

                if(currentNode.right != null){
                    q.offer(currentNode.right);
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.left.left.left = new TreeNode(3);
        List<TreeNode> result = RightSideView.traverse(root);
        for (TreeNode node : result) {
          System.out.print(node.val + " ");
        }
      }
}