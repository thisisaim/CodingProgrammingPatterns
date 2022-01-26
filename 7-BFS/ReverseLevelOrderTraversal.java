import java.util.*;

class ReverseLevelOrderTraversal{
    public static List<List<Integer>> traverse(TreeNode root){
        List<List<Integer>> result = new LinkedList<List<Integer>>();

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
            }
            result.add(0, currentLevel);

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
        List<List<Integer>> result = ReverseLevelOrderTraversal.traverse(root);
        System.out.println("Reverse level order traversal: " + result);
    }

}