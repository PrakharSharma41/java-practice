public class Creator {
    public static Node create(){
        Node root=new Node("a");
        Node left=new Node("b");
        Node right=new Node("c");
        root.addChildren(left);
        root.addChildren(right);
        left.addChildren(new Node("d"));
        left.addChildren(new Node("e"));
        Node child1=new Node("f");
        Node child2=new Node("g");
        right.addChildren(child1);
        right.addChildren(child2);
        child1.addChildren(new Node("h"));
        child2.addChildren(new Node("i"));
        return root;
    }
}
