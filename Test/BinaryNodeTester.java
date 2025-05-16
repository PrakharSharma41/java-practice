import java.util.ArrayList;
import java.util.List;

public class BinaryNodeTester {
    public BinaryNode create(){
        BinaryNode root=new BinaryNode(1);
        root.left=new BinaryNode(2);
        root.right=new BinaryNode(3);
        root.left.left=new BinaryNode(4);
        root.left.right=new BinaryNode(5);
        root.left.left.right=new BinaryNode(6);
        return root;
    }
    public List<List<Integer>> list(BinaryNode root){
        List<List<Integer>>ans=new ArrayList<>();
        dfs(root,ans);
        return ans;
    }
    public int dfs(BinaryNode root,List<List<Integer>>ans){
        if(root==null)return 0;
        int leftDepth=dfs(root.left,ans);
        int rightDepth=dfs(root.right,ans);
        int maxDepth=Math.max(leftDepth,rightDepth)+1;
        if(maxDepth>ans.size()){
            ans.add(new ArrayList<>());
        }
        ans.get(maxDepth-1).add(root.value);
        return maxDepth;
    }
}
