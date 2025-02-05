public class Trie1 {
    
    class Node{
        Node[] links=new Node[26];
        boolean isEnd;
        boolean containsKey(char ch){
            return links[ch-'a']!=null;
        }
        void put(char ch,Node node){
            links[ch-'a']=node;
        }
        Node get(char ch){
            return links[ch-'a'];
        }
        void setEnd(){
            isEnd=true;
        }
        boolean getEnd(){
            return isEnd;
        }
    }
    Node root;
    public Node getRoot(){
        if(root!=null)return root;
        else root=new Node();
        return root;
    }
    public void insert(String str){
        root=getRoot();
        Node temp=root;
        for(int i=0;i<str.length();i++){
            if(!temp.containsKey(str.charAt(i))){
                temp.put(str.charAt(i),new Node());
            }
            temp=temp.get(str.charAt(i));
        }
        temp.setEnd();
    }
    public boolean search(String str){
        root=getRoot();
        Node temp=root;
        for(int i=0;i<str.length();i++){
            if(temp.containsKey(str.charAt(i))){
                temp=temp.get(str.charAt(i));
            }
            else return false;
        }
        return temp.getEnd();
    }
    public boolean startsWith(String str){
        root=getRoot();
        Node temp=getRoot();
        for(int i=0;i<str.length();i++){
            if(!temp.containsKey(str.charAt(i))){
                return false;
            }
            temp=temp.get(str.charAt(i));
        }
        return true;
    }
}
