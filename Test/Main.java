import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Node root=Creator.create();
        // NodeManager nodeManager=new NodeManager(root);
        // nodeManager.setup();
        // System.out.println(nodeManager.findCommonParent(Arrays.asList("o","h")));
        // LinkedNode root=new LinkedNode("1", new LinkedNode("2", new LinkedNode("3", new LinkedNode("4", 
        // new LinkedNode("5", new LinkedNode("6", new LinkedNode("7", new LinkedNode("8", new LinkedNode("9", null)))))))));
        // print(root);
        // root=convert(root);
        // print(root);
        // char[][]grid=new char[][]    
        // {{'b', 'b', 'b', 'a', 'l', 'l', 'o', 'o'},
        // {'b', 'a', 'c', 'c', 'e', 's', 'c', 'n'},
        // {'a', 'l', 't', 'e', 'w', 'c', 'e', 'w'},
        // {'a', 'l', 'o', 's', 's', 'e', 'c', 'c'},
        // {'w', 'o', 'o', 'w', 'a', 'c', 'a', 'w'},
        // {'i', 'b', 'w', 'o', 'w', 'w', 'o', 'w'}};
        // Test test=new Test(grid);
        // List<int[]> path=test.location("access");
        // if(path!=null){
        //     for(int[] p:path){
        //         System.out.println(p[0]+" "+p[1]);
        //     }    
        // }else{
        //     System.out.println("not present");
        // }
        // System.out.println(maxSum(new int[]{1, -2, 3, 4, -1, 2, 1, -5, 4}));
        // System.out.println(maxProduct(new int[]{2, 0, -2, 4}));
        // 1 2 3 5 6 4 7 8 9
        // 2 3 1 4 5 6 7 8 9
        // 2 3 1 5 6 4
        // 1 2 
    }    

    public static LinkedNode  convert(LinkedNode root){
        LinkedNode l1,l2,l3,newRoot=null,prev=null;
        l1=root;
        if(l1==null|| l1.next==null || l1.next.next==null)return root;
        l2=l1.next;
        l3=l2.next;
        newRoot=l2;
        while(true){
            if(prev!=null)
            prev.next=l2;
            l1.next=l3.next;
            l3.next=l1;
            prev=l1;
            if(l1.next==null || l1.next.next==null|| l1.next.next.next==null)break;
            l1=l1.next;
            l2=l1.next;
            l3=l2.next;
        }
        return newRoot;
    }
    public static void print(LinkedNode root){
        while(root!=null){
            System.out.print(root.value+" ");
            root=root.next;
        }
        System.out.println();
    }
}
