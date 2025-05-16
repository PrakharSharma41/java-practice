import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
        // GridSearch test=new GridSearch(grid);
        // List<int[]> path=test.location("access");
        // if(path!=null){
        //     for(int[] p:path){
        //         System.out.println(p[0]+" "+p[1]);
        //     }    
        // }else{
        //     System.out.println("not present");
        // }
        DateMap<String> dateMap = new DateMap<>();
        Date d1 = new Date();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Date d2 = new Date();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Date d3 = new Date();

        dateMap.put(d1, "First");
        dateMap.put(d2, "Second");

        System.out.println("Get d1: " + dateMap.get(d1)); // "First"
        System.out.println("Get d2: " + dateMap.get(d2)); // "Second"
        System.out.println("Get d3 (no exact match): " + dateMap.get(d3)); 

        // Test test=new Test();
        // System.out.println(test.findNumber(new int[]{1,2,2,3,3}));
        // BinaryNodeTester tester=new BinaryNodeTester();
        // BinaryNode root=tester.create();
        // System.out.println(tester.list(root));
        // Islands islands=new Islands();
        // System.out.println(islands.find(3, 3, new int[][]{{0,0},{1,1},{1,0}}));
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
