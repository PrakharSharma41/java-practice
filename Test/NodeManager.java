import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NodeManager {
    Node root;
    HashMap<String,List<Node>>nodePath;
    NodeManager(Node root){
        this.root=root;
        nodePath=new HashMap<>();
    }
    public void setup(){
        dfs(root,new ArrayList<>());
    }
    public void dfs(Node node,List<Node>path){
        if(node==null)return ;
        path.add(node);
        nodePath.put(node.getValue(), new ArrayList<>(path));
        for(Node child:node.getChildren()){
            path.add(child);
            dfs(child,path);
            path.remove(path.size()-1);
        }
        path.remove(node);
    }
    public String findCommonParent(List<String>input){
        if(input==null||input.size()==0)return "-";
        String ans="";
        int index=0,minLenPath=Integer.MAX_VALUE;
        for(int i=0;i<input.size();i++){
            if(nodePath.containsKey(input.get(i))==false)return "-";
            minLenPath=Math.min(minLenPath,nodePath.get(input.get(i)).size());
        }
        boolean parentFound=false;
        while(index<minLenPath){            
            for(int i=1;i<input.size();i++){
                if(nodePath.get(input.get(i)).get(index).getValue()!=nodePath.get(input.get(i-1)).get(index).getValue()){
                    parentFound=true;
                    break;
                }
            }
            if(parentFound)break;
            ans=nodePath.get(input.get(0)).get(index).getValue();
            index++;
        }
        return ans;
    }
}
//input1: 
//input2: 
//input3: 