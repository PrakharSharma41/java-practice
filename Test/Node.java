import java.util.ArrayList;
import java.util.List;

public class Node{
    String value;
    List<Node>children;
    Node(String value){
        this.value=value;
        children=new ArrayList<>();
    }
    public void addChildren(Node node){
        children.add(node);
    }
    public List<Node>getChildren(){
        return children;
    }
    public String getValue(){
        return value;
    }
}