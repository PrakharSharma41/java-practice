import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.w3c.dom.ranges.Range;


class Test{
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer>mp=new HashMap<>(1000000,9);
        for(int i=0;i<nums.length;i++){
            mp.put(nums[i], 1);
        }
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int ans=1;
        for(Integer key: mp.keySet()){
            int val=mp.get(key),count=1;
            while(mp.containsKey(val+1)){
                if(mp.get(val+1)>1){
                    count+=mp.get(val+1);break;
                }
                val++;count++;
            }
            mp.put(key, count);
            ans=Math.max(ans,count);
        }
        return ans;
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a1,a2)->{
            if(a1[0]!=a2[0]){
                return a1[0]-a2[0];
            }
            return a1[1]-a2[1];
        });
        ArrayList<ArrayList<Integer>>arr=new ArrayList<>();
        int[] temp=intervals[0];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>temp[1]){
                arr.add(new ArrayList<Integer>(Arrays.asList(temp[0],temp[1])));
                temp[0]=intervals[i][0];
                temp[1]=intervals[i][1];
            }else{
                temp[1]=Math.max(temp[1],intervals[i][1]);
            }
        }
        arr.add(new ArrayList<Integer>(Arrays.asList(temp[0],temp[1])));
        int[][]ans=new int[arr.size()][];
        
        for (int i = 0; i < arr.size(); i++) {
            ArrayList<Integer> sublist = arr.get(i);
            ans[i] = sublist.stream().mapToInt(Integer::intValue).toArray();
        }
        Stream<Integer>str=Stream.of(1,2,3,4);
        Integer[] test;
        int[] test1;
        test=str.toArray((size)->new Integer[size]);
        // test=str.toArray(Integer[]::new)
        test1=str.mapToInt(Integer::intValue).toArray();
        test=str.toArray(new IntFunction<Integer[]>() {
            @Override
            public Integer[] apply(int value) {
                // TODO Auto-generated method stub
                return new Integer[value];
            }
        });
        // Collections.low
        // MergeSort s=MergeSort::new;
        return ans;        
    }    
    public static double divide(int a,int b){
        double ans=(double)(a+b)/2;
        return ans;
    }
    public static void swap(List<Integer>ls,int i,int j){
        int temp;
        temp=ls.get(i);ls.set(i, ls.get(j));ls.set(j, temp);
    }
    public static void check(int [][]arr){
        arr[0][0]=0;
    }
    public static void varArgs(int ...args){
        for(int arg : args){
            System.out.println(arg);
        }
    }

    public <K,V> void genericMethod(Pair<K,V> pair){

    }
    // public static List<List<Integer>> substr(List<Integer>str){
    //     Pair<Integer,Integer>p=new Pair<>();
    // }
  
    public static void main(String[] args) {
        // int [][]arr={{1,2,3},{4,5,6}};
        // System.out.println(arr[0][0]);
        // check(arr);
        // System.out.println(arr[0][0]);
        // Doctor x=new  Doctor(){

        // };
        // OuterClass.InnerClass.print();
        // Immutable im=new Immutable(new ArrayList<>());
        // System.out.println(im.getLs().size());
        // im.getLs().add(2);
        // System.out.println(im.getLs().size());
        // FInterface ft=new FInterface() {
        //     @Override
        //     public void check(String s) {
        //         System.out.println("in anonymous");
        //     }
            
        // };
        // FInterface ft1=(String s)->{
        //     System.out.println("inside lambda");
        // };
        // Consumer<String> c=(String s)->{

        // };
        // Supplier<String> s=()->{
        //     return "as";
        // };
        // Function<String,Integer> f=(String s)->{
        //     return 1;
        // };
        // Predicate<String> p=(String s)->{
        //     return false;
        // };
        // try{
        //     Class d1=Class.forName("Person");
        //     System.out.println(d1.getName());
        //     Class d2=Doctor.class;
        //     Class d3=new Doctor().getClass();
        // }catch(Exception e){
        //     System.out.println("in exception");
        // }
        // try {
        //     Class reflection=Class.forName("Reflection");
        //     Object obj=reflection.newInstance();
        //     Method method=reflection.getMethod("check", String.class);
        //     method.invoke(obj, "reflection");
        //     Reflection dr=new Reflection();
        //     Field f=reflection.getDeclaredField("val");
        //     f.setAccessible(true);
        //     f.set(dr, 1);
        //     dr.getVal();

        //     Class rt=Class.forName("Reflection");
        //     Reflection ref=new Reflection();
        //     Field fi=rt.getDeclaredField("val");
        //     fi.setAccessible(true);
        //     fi.set(ref, 12);
        // } catch (Exception e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
        // Category[] ct=new Eagle().getClass().getAnnotationsByType(Category.class);
        // for(Category ca:ct){
        //     System.out.println(ca.name());
        // }
        // try{
        //     new ExceptionTest().check();
        // }
        // catch(Exception e){
        //     System.out.println("handled");
        // }
        // ArrayList<Integer> x=new ArrayList<>();
        // x.add(1);x.add(2);
        // x.forEach(y->System.out.println(y));
        // Integer[]at=new Integer[2];
        // x.toArray(at);
        // x.size();
        // System.out.println(at[1]);
        // try{
        //     Field f=ArrayList.class.getDeclaredField("elementData");
        //     f.setAccessible(true);
        //     Object[] data=(Object[])f.get(x);
        //     System.out.println("length is "+data.length);
        // }catch(Exception e){
        //     System.out.println("exception occured");
        // }
        // Map<Integer,Integer>mp=new HashMap<>();
        // mp.put(1,1);
        // mp.put(2,2);
        // for(Map.Entry<Integer,Integer>m:mp.entrySet()){
        //     System.out.println(m.getKey()+m.getValue());
        // }
        // for(Integer xt:mp.values()){
        //     System.out.println(xt);
        // }
        // Set<Integer>st=new HashSet<>();
        // st.add(2);
        // st.add(3);
        // Iterator<Integer>itr=st.iterator();
        // while(itr.hasNext()){
        //     System.out.println(itr.next());
        // }
        // List<Integer>arr=new ArrayList<>();
        // arr.add(120);
        // arr.add(4);
        // arr.add(3);
        // arr.add(2);
        // MergeSort.merge(arr,0,arr.size()-1);
        // swap(arr,0,3);
        // System.out.println(arr);
        // QuickSort.sort(arr, 0, arr.size()-1);
        // System.out.println(arr);
        // StreamExample ste=new StreamExample();
        // ste.check();
        // ste.flatMap();
        // Thread tr=new abcd();
        // tr.start();
        // Thread thread=new Thread(()->{
        //     try {
        //         Thread.sleep(8000);
        //         System.out.println(Thread.currentThread().getName()+" woke up");
        //     } catch (InterruptedException e) {
        //         // TODO Auto-generated catch block
        //         e.printStackTrace();
        //     }
        // });
        
        // int random=(int)(Math.random()*5);
        // System.out.println("random is "+random);
        // System.out.println(Math.random()*5);
        // Integer[] arr1={1,23,456,1,2,3,4};
        // int[] x1=Arrays.stream(arr1).mapToInt(Integer::intValue).toArray();
        // Optional<Integer>mn;
        // System.out.println("divide is "+divide(7, 4));
        // Queue<Integer>q1=new PriorityQueue<>();
        // // Integer.va
        // Deque<Integer>dq=new LinkedList<>();
        // // Stack<Integer>st=new Stack<>();
        // List<Integer>ls1=new ArrayList<>();
        // Collections.reverse(ls1);
        
        // select * from tablename where x=y group by abcd having abcd;
        // int []temp=new int[]{3,4};
        // List<Integer>stat=new ArrayList<>(Arrays.asList(temp[0]));
        // System.out.println(stat);
        // thread.setDaemon(true);
        // thread.start();
        // int[][] test=new int[][]{{1,2},{3,4}};
        // int intval=5;
        // long longval=intval;
        // int intval1=(int)longval;
        // SharedResourceReadWrite shr=new SharedResourceReadWrite();
        // ReadWriteLock lock=new ReentrantReadWriteLock();
        // Thread pthread1=new Thread(()->{
        //     shr.producer(lock);
        // });
        // Thread pthread2=new Thread(()->{
        //     shr.producer(lock);
        // });
        // Thread cthread1=new Thread(()->{
        //     shr.consumer(lock);
        // });
        // pthread1.start();pthread2.start();cthread1.start();

        // ConditionSharedResource csr=new ConditionSharedResource();
        // Thread th1=new Thread(()->{
        //     for(int i=0;i<2;i++){
        //         csr.producer();
        //     }
        // });
        // Thread th2=new Thread(()->{
        //     for(int i=0;i<2;i++){
        //         csr.consumer();
        //     }
        // });
        // th1.start();th2.start();
        // new ThreadPoolExample().implement();
        // String val="abcd";
        // for(int i=0;i<val.length();i++){
        //     // val.
        // }
        // PriorityBlockingQueue<Integer> pq=new PriorityBlockingQueue<>();
        // pq.add(null);
        // ConcurrentLinkedDeque dq=new ConcurrentLinkedDeque<>();
        // dq.addFirst(dq);
    //     AtomicInteger atr=new AtomicInteger(0);
    //    System.out.println("value set "+ atr.compareAndSet(1, 1));
        // Map<String, Integer> syncMap = Collections.synchronizedMap(new HashMap<>());
        // SortedMap<Integer, String> syncTreeMap = Collections.synchronizedSortedMap(new TreeMap<>());
        // Map<Integer, String> syncLinkedMap = Collections.synchronizedMap(new LinkedHashMap<>());
        // LinkedBlockingQueue<Integer>q=new LinkedBlockingQueue<>();
        // List<Integer>ans=Arrays.asList(4,3,5,1,7);
        // System.out.println(ans);
        // List<Integer>ls=new LinkedList<>();
        // ls.addLast(12);
        // System.out.println(ls.removeLast());
       
        // for(Character c:val){
        // }
        // int [] hash=new int[245];
        // Character chr='a';
        // hash[chr]=1;
        // System.out.println("asdad "+hash[97]);
        // List<Integer>ls=new ArrayList<>(4);
        // ls.set(3, 2);
        // System.out.println(ls.get(3));
        // Singleton stn=Singleton.singleton;
        // try (FileOutputStream file = new FileOutputStream("abcd.ser")) {
        //     ObjectOutputStream ostr=new ObjectOutputStream(file);
        //     ostr.writeObject(new Check(1, "2"));
        //     FileInputStream input =new FileInputStream("abcd.ser");
        //     ObjectInputStream istr=new ObjectInputStream(input);
        //     istr.readObject();
        // } catch (Exception e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
        // PriorityQueue<Integer>pq=new PriorityQueue<>();
        // LinkedList<Integer>ls=new LinkedList<>();
        // pq.p
        // HashMap<Integer,Integer>mp=new HashMap<>();
        
        // Set<Integer>st=new HashSet<>();

        // BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        // try {
        //     System.out.println(br.readLine());
        // } catch (IOException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
        // StringBuilder str=new StringBuilder("abcd");
        // str.insert(0, 'e');
        // System.out.println(str);
        // int[] arr2=new int[]{5,4,3,2,1};
        // Integer[] arr3 = Arrays.stream(arr2).boxed().toArray(Integer[]::new);
        // Scanner scr=new Scanner(System.in);
        // s
        // Runnable rtr=new Runnable() {

        //     @Override
        //     public void run() {
        //         System.out.println("inside runkjnkjnkl");
        //     };
            
        // };
        // rtr.run();
        // Thread tt=new Thread(rtr);tt.start();
        // HashSet<String>hs=new HashSet();
        // hs.add("adsa");
        // List<String>str=new ArrayList<>();
        // HashMap<String,String>mp=new HashMap();
        // Deque<Integer>dq=new LinkedList<>();
        // mp.re
        // int[] arr=new int[256];
        // arr['a']=2;
        // System.out.println("hbasojdna "+(char)(98));
        // ArrayList<Integer>arr=new ArrayList<>();
        // arr.add(1);
        // arr.add(2);
        // System.out.println("Arr is "+arr);
        // HashMap<String,Integer>mp=new HashMap<>();
        // mp.forEach((a,b)->{

        // });
        // String str="";
        // HashMap<Character,List<Character>>mp=new HashMap<>();
        // char c='a';
        // for(int i=2;i<=9;i++){
        //     if(i!=7&&i!=9)
        //     mp.put((char)(i+'0'),Arrays.asList(c++,c++,c++));
        //     else 
        //     mp.put((char)(i+'0'),Arrays.asList(c++,c++,c++,c++));
        // }
        // System.out.println(mp.get('7'));
        // String x=String.valueOf(12);
        // System.out.println(ans);
        // Queue<Integer>q=new LinkedList<>();
        // List<String[]> badge_times = Arrays.asList(
        //     new String[]{"Paul", "1355"}, new String[]{"Jennifer", "1910"}, new String[]{"Jose", "835"},
        //     new String[]{"Jose", "830"}, new String[]{"Paul", "1315"}, new String[]{"Chloe", "0"},
        //     new String[]{"Chloe", "1910"}, new String[]{"Jose", "1615"}, new String[]{"Jose", "1640"},
        //     new String[]{"Paul", "1405"}, new String[]{"Jose", "855"}, new String[]{"Jose", "930"},
        //     new String[]{"Jose", "915"}, new String[]{"Jose", "730"}, new String[]{"Jose", "940"},
        //     new String[]{"Jennifer", "1335"}, new String[]{"Jennifer", "730"}, new String[]{"Jose", "1630"},
        //     new String[]{"Jennifer", "5"}, new String[]{"Chloe", "1909"}, new String[]{"Zhang", "1"},
        //     new String[]{"Zhang", "10"}, new String[]{"Zhang", "109"}, new String[]{"Zhang", "110"},
        //     new String[]{"Amos", "1"}, new String[]{"Amos", "2"}, new String[]{"Amos", "400"},
        //     new String[]{"Amos", "500"}, new String[]{"Amos", "503"}, new String[]{"Amos", "504"},
        //     new String[]{"Amos", "601"}, new String[]{"Amos", "602"}, new String[]{"Paul", "1416"}
        // );        

        // TreeMap<Integer,Integer>hm=new TreeMap<>();
        // TreeSet<Integer>ts=new TreeSet<>();
        // ts.add(12313);
        // ts.forEach(i->System.out.println(i));
        // Arrays.sort(args);
        // for(int i=2;i<=9;i++){

        // }
    
        // int[] x=arr.stream().mapToInt(Integer::intValue).toArray();
        // arr.stream().Int
        // RunnableExample rt=new RunnableExample();
        // Thread th=new Thread(()->{
        //         System.out.println(Thread.currentThread().getName());
        // });
        // th.start();
        // SharedResource obj=new SharedResource();
        // Stream<Integer>str=Stream.of(1,2,3,4);
        // IntFunction<Integer[]> ftr=(int value)-> new Integer[value];
        // Integer[] ans=str.toArray(ftr);
        // str.peek(x->System.out.println(x));

        // List<Integer>ls;
// Object[] test=ls.stream().filter(some operations here).toArray()
// Integer[] test=ls.stream().toArray((int size)->new Integer[size])

        // Thread producerThread=new Thread(()->{
        //     for(int i=1;i<=5;i++){
        //         try {
        //             Thread.sleep(2000);
        //         } catch (InterruptedException e) {
        //             // TODO Auto-generated catch block
        //             e.printStackTrace();
        //         }
        //         obj.addItem(i);
        //     }
        // });
        // Thread consumerThread=new Thread(()->{
        //     for(int i=1;i<=5;i++){
        //         try {
        //             Thread.sleep(4500);
        //         } catch (InterruptedException e) {
        //             // TODO Auto-generated catch block
        //             e.printStackTrace();
        //         }
        //         obj.consumeItem();
        //     }

        // });
        // producerThread.start();
        // consumerThread.start();
        // Thread producerThread=new Thread(()->{
        //     try {
        //         Thread.sleep(2000);
        //     } catch (InterruptedException e) {
        //         // TODO Auto-generated catch block
        //         e.printStackTrace();
        //     }
        //     obj.addItem();
        // });
        // Thread consumerThread=new Thread(()->{
        //     obj.consumeItem();
        // });
        // producerThread.start();
        // consumerThread.start();
        // List<Integer>lst=Arrays.asList(1,2,3,4);
        // Queue<Integer>q=new ArrayDeque();
        // PriorityQueue<Integer>q=new PriorityQueue<>();
        // // q.add(1);
        // q.add(5);
        // q.add(2);
        // System.out.println(q.peek());
        // List<Check>ls=new ArrayList<>();
        // ls.add(new Check(1, "one"));
        // ls.add(new Check(0, "zero"));
        // ls.add(new Check(3, "three"));
        // ls.add(new Check(2, "two"));
        // Collections.sort(ls);
        // ls.forEach(z->System.out.println(z.value));
        // Collections.sort(ls,new CheckComparator());
        // ls.forEach(z->System.out.println(z.value));
        // System.out.println(d1.getName());
        // Person person=new Doctor();
        // WeakReference<Person> weakReference=new WeakReference<Person>(new Person(0));
        // GenericClass<Integer> gc=new GenericClass<>();
        // gc.setValue(3);
        // GenericClass gc1=new GenericClass<>();
        // gc1.setValue(1);
        // List<UpperBoundWildCard> ls=new ArrayList<>();
        // WildCard.upperbound(ls);
        // WildCard.lowerbound(new ArrayList<Print>());
        // System.out.println(Enum.valueOf("MONDAY").name());
        // EnumSample es=EnumSample.MONDAY;
        // es.test();
        // gc1.setValue("one");
        // person.check();
        // varArgs(1,2,3,4);
        // int x=(int)Math.random()*100;
        // TreeMap<Integer,Integer>tr1=new TreeMap<>();
        // class Pair{
        //     int c,p;
        //     Pair(int c,int p){
        //         this.c=c;this.p=p;
        //     }           
        // }
        // TreeMap<Pair,Integer>tr1=new TreeMap<>((Pair a,Pair b)->{
        //     if(a.c!=b.c)return a.c-b.c;
        //     return a.p-b.p;
        // });        
        // TreeSet<Pair>tr1=new TreeSet<>((Pair a,Pair b)->{
        //     if(a.c!=b.c)return a.c-b.c;
        //     return a.p-b.p;
        // });
        // Pair p1=new Pair(10, 10);
        // tr1.put(p1,1);
        // tr1.put(p1,tr1.get(p1)+1);
        // tr1.put(new Pair(10, 30),1);

        // for(Map.Entry<Pair,Integer> p:tr1.entrySet()){
        //     System.out.println(p.getKey().c+" "+p.getValue());
        // }        
        // Pair p=tr1.floor(new Pair(10, -5));
        
        // System.out.println(p.c+" "+p.p);
        // System.out.println(lowerbound(new ArrayList<Integer>(Arrays.asList(1,1,1,1,1)),1));
        // System.out.println(upperbound(new ArrayList<Integer>(Arrays.asList(1,20,20,30,40,40,40,50,50,60)),21));
        // Map<Integer,Integer>mp=new HashMap<>();
        // Trie1 trie=new Trie1();
        // trie.insert("striver");
        // trie.insert("asdstriver");        trie.insert("stknasdriver");        trie.insert("hbasik");
        // System.out.println(trie.search("stknasdriver"));
        // System.out.println(trie.startsWith("asds"));
        // int[] test=new int[26];
        // Collections.so
        // System.out.println(11<<1);
        // test[0]=1;
        // String ans="";
        // for(int i=0;i<26;i++){
        //     ans+=Character.toString('a'+i);
        // }
        // System.out.println(ans);
        // bound(0);
        // String s="asdad";
        // s.subs
        // String ans=s;ans="as";
        // System.out.println(s);
        // String a="923",b="321";
        // a.sub
        // ArrayList<Integer>ans;
        // ans.su
        // System.out.println(a.compareTo(b));
        // StringBuilder str=new StringBuilder();str.append(2);str.append(4);
        // str.app
        // String str="asda ";
        // String[] as=str.split("f");
        // System.out.println(as.length);

        // Integer.pa
        // Arrays.cop
        // System.out.println(str);
        // List<Integer> list = Arrays.asList(1, 2, 3);
        // int[] array = list.stream().mapToInt(Integer::intValue).toArray();
        // String preOrderStr="";
        // Integer[] t=Arrays.stream(preOrderStr.split(" ")).mapToInt(Integer::parseInt).toArray(Integer[]::new);

        
        // preOrderStr.split(" ").stream().mapToInt(Integer::parseInt).toArray();
        // testing();
        // double x=(double)(1-2)/(6-3);
        // System.out.println(x);
        // LinkedList<Integer>ls=new LinkedList<>();
        // String s="";
        // s.length();
        // s.equals(s)
        // PriorityQueue<Integer>pq=new PriorityQueue<>();
        // pq.isEmpty()
        // List<List<Integer>>adjList=new ArrayList<>();
        // adjList.set(0, new ArrayList<>());
        // Queue<Integer>q=new LinkedList<>();
        // q.add(null);
        // TreeMap<Integer,Integer> tm=new TreeMap<>();
        // tm.put(1, 1);
        // System.out.println(tm.ceilingKey(100));;
        // [-7, -2, -1, -1, 1, 2, 2, 2, 3, 5] 
        // int x=testUber(new ArrayList<>(Arrays.asList(-7,-2,-1,-1,1,2,2,2,3,5)),2);
        // System.out.println("x is "+x);
        // TreeSet<Integer>trs=new TreeSet<>();
        // TreeMap<Integer,Integer>trm=new TreeMap<>();
        // Collections.re
        // Arrays.copyOf(null, 0,);
        // int n=6,k=2;
        // int[][]dp=new int[n+1][k+1];
        // ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        // adj.add(new ArrayList<>());
        // adj.add(new ArrayList<>(Arrays.asList(2)));
        // adj.add(new ArrayList<>(Arrays.asList(5,3)));
        // adj.add(new ArrayList<>(Arrays.asList(4)));
        // adj.add(new ArrayList<>());
        // adj.add(new ArrayList<>());
        // dfs(adj,dp,1,k);
        // for(int i=1;i<=5;i++){
        //     System.out.println("pair from root is "+dp[i][2]);
        // }
        // System.out.println("ans is "+ans);
        // Deque<Integer>qz=new LinkedList<>(); // 1 2 
        // qz.add(1);
        // qz.add(2);
        // // System.out.println(qz.peek());
        // qz.remove();
        // qz.add(3);
        // System.out.println(qz.peek());
        // TreeMap<String,String>mp=new TreeMap<>();
        // Map.Entry<String,String>i=mp.floorEntry("As");
        
        // List<List<Integer>>ans=new ArrayList<>();
        // Node root=new Node(1);
        // root.left=new Node(2);
        // root.right=new Node(3);
        // root.left.left=new Node(4);
        // root.left.right=new Node(5);
        // find(root,ans);
        // System.out.println("akjsnas");
        // for(List<Integer>ls:ans){
        //     for(int i:ls){
        //         System.out.print(i+" ");
        //     }
        //     System.out.println();
        // }
        // char c='a';
        // String val="abcd";
        // Stack<Character>st=new Stack<>();
        // StringBuilder sb=new StringBuilder();

        // sb.append("as");
        // sb.reverse();
        
        // System.out.println(sb);
        // System.out.println(findReward(new int[]{0,0,0,2}, new int[]{0,2,2,3}, 2));
        // System.out.println(countBits(2));
        // TreeMap<Integer,Integer>mp=new TreeMap<>();
        // mp.firstEntry().getValue();
        // mp.cei
        // // mp.lastEntry()
        // int[] x=new int[]{};
        // Arrays.stream(x).boxed().toArray();
        // Integer[] itr=new Integer[];
        // x=Arrays.stream(itr).mapToInt(Integer::intValue).toArray();
        // int[][][]dp=new int[][][];
        splitwiseTest(new int[][]{{1,2,100},{2,3,100},{3,4,200}});
    }

    public static void splitwiseTest(int[][]transactions){ //{{a,b,c},{d,e,f}} a gives c amount of money to b
        HashMap<Integer,Integer>mp=new HashMap<>();
        for(int[] i:transactions){
            mp.put(i[0],mp.getOrDefault(i[0], 0)-i[2]);
            mp.put(i[1],mp.getOrDefault(i[1], 0)+i[2]);
        }
        List<int[]>balanceList=new ArrayList<>();
        mp.forEach((user,amount)->{
            balanceList.add(new int[]{user,amount});
            System.out.println(user+" "+amount);
        });
        List<int[]>ans=new ArrayList<>(); // [{a,b,c},{d,e,f}]  a paid c amount to b
        System.out.println("minimum transactions are "+dfs(balanceList,0,ans));
        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i)[0]+" paid "+ans.get(i)[2]+" amount to "+ans.get(i)[1]);
        }
    }

    public static int dfs(List<int[]> balanceList, int currentIndex, List<int[]> ans) {
        while (currentIndex < balanceList.size() && balanceList.get(currentIndex)[1] == 0) {
            currentIndex++;
        }

        if (currentIndex == balanceList.size()) return 0;

        int minTransactions = Integer.MAX_VALUE;
        int thisUser = balanceList.get(currentIndex)[0];
        int thisAmount = balanceList.get(currentIndex)[1];

        for (int i = currentIndex + 1; i < balanceList.size(); i++) {
            int otherAmount = balanceList.get(i)[1];
            int otherUser = balanceList.get(i)[0];

            // They must be of opposite signs (debtor vs creditor)
            if (thisAmount * otherAmount < 0) {
                int amountToSettle = Math.min(Math.abs(thisAmount), Math.abs(otherAmount));
                int sign = thisAmount > 0 ? -1 : 1;

                // Update balances
                balanceList.get(i)[1] += sign * amountToSettle;
                balanceList.get(currentIndex)[1] -= sign * amountToSettle;

                ans.add(new int[]{thisUser, otherUser, amountToSettle});

                int transactions = 1 + dfs(balanceList, currentIndex + 1, ans);
                minTransactions = Math.min(minTransactions, transactions);

                // Backtrack
                ans.remove(ans.size() - 1);
                balanceList.get(i)[1] = otherAmount;
                balanceList.get(currentIndex)[1] = thisAmount;

                // Optional: Optimization to stop early
                if (balanceList.get(i)[1] == 0) break;
            }
        }

        return minTransactions == Integer.MAX_VALUE ? 0 : minTransactions;
    }
    // public static String findLargestTreeRoot(Map<String, String> childParentMap) {
    //     HashMap<String,Integer>mp=new HashMap<>();
    //     for(Map.Entry<String,String>etr:childParentMap.entrySet()){
    //         String child=etr.getKey();
    //         String parent=etr.getValue();
    //         if(mp.containsKey(child)==false){
    //             mp.put(parent,1+dfs(child,mp,childParentMap));
    //         }else{
    //             mp.put(parent,);
    //         }
    //     }
    // }
    // public static int dfs(String node,HashMap<String,Integer>mp,Map<String, String> childParentMap){
    //     if(childParentMap.containsKey(node)==false)return 0;
    //     if(mp.containsKey(node))return mp.get(node);
    //     int size=1+dfs(childParentMap.get(node),mp.childParentMap);
    //     mp.put(node,size);
    //     return size;
    // }
    public static int findReward(int[] reward1,int[] reward2,int k){
        int n=reward1.length;
        int[][] dp=new int[n+1][k+1];
        for (int i = 0; i <= n; i++)
        Arrays.fill(dp[i], Integer.MIN_VALUE);
        dp[0][0] = 0;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=Math.min(i,k);j++){
                dp[i][j]=Math.max(dp[i-1][j]+reward2[i-1],dp[i][j]);    // intern 2
                if(j>0)
                dp[i][j]=Math.max(dp[i-1][j-1]+reward1[i-1],dp[i][j]); // intern 1
                                         
            }
        }
        return dp[n][k];
    }
    public static int countBits(int n){
        int ans=0;
        while(n>0){
            ans++;
            n/=2;
        }
        return ans;
    }
    public static int find(Node root,List<List<Integer>>ans){
        if(root==null)return 0;
        int leftHeight=find(root.left,ans);
        int rightHeight=find(root.right,ans);
        int nodeHeight=Math.max(leftHeight,rightHeight)+1;
        if(ans.size()<nodeHeight)ans.add(new ArrayList<>());
        ans.get(nodeHeight-1).add(root.value);
        return nodeHeight;
    }
    static class Node{
        int value;
        Node left,right;
        Node(int value){
            this.value=value;
        }
    }
    static int ans=0;
    public static void dfs(ArrayList<ArrayList<Integer>>adj,int[][]dp,int root,int k){
        dp[root][0]=1;
        for(Integer node:adj.get(root)){
            dfs(adj,dp,node,k);
            for(int i=0;i<k;i++){
                ans+=dp[node][i]*dp[root][k-i-1];
                System.out.println(root+" "+node+" "+ i+" "+ans);
            }
            for(int i=1;i<=k;i++){
                dp[root][i]+=dp[node][i-1];
            }            
        }
    }

    public static void test(int[][]paint){
        TreeMap<Interval,Interval>mp=new TreeMap<>();
        
        int[] result=new int[paint.length];
        int n=result.length;
        for(int i=0;i<paint.length;i++){
            int st=paint[i][0];
            int en=paint[i][1];
            while(true){
                Map.Entry<Interval,Interval>te=mp.ceilingEntry(null);
                // te.
                // Interval ceiling=mp.floorKey(null)
            }
        }
        for(int i=0;i<n;i++){
            System.out.println(result[i]);
        }
    }
    
    public static int bound(int num){
        int t=num,ans=1;
        while((t>>1)>0){
            ans*=2;t=t>>1;
        }
        System.out.println("smaller power of 2 is: "+ans);
        ans=1;num--;
        t=num;t=t<<1;
        while((t>>1)>0){
            ans*=2;t=t>>1;
        }
        System.out.println("higher power of 2 is: "+ans);

        return 0;
    }
    
    public static int search(List<Integer>a,List<Integer>b,int k){
        int n=a.size(),m=b.size();
        if(n>m)return search(b, a, k);
        int low=Math.max(0,k-m),high=Math.min(k,n);
        while(low<=high){
            int mid1=(low+high)/2;
            int mid2=k-mid1;
            int l1=Integer.MIN_VALUE,l2=Integer.MIN_VALUE;
            int r1=Integer.MAX_VALUE,r2=Integer.MAX_VALUE;
            if(mid1<n)r1=a.get(mid1);
            if(mid2<m)r2=b.get(mid2);
            if(mid1>0)l1=a.get(mid1-1);
            if(mid2>0)l2=b.get(mid2-1);
            if(l1<=r2&&l2<=r1){
                return Math.max(l1,l2)*Math.max(l1,l2);
            }
            if(l1>r2){
                high=mid1-1;
            }else{
                low=mid1+1;
            }
        }
        return 0;
    }
    public static int testUber(ArrayList<Integer> arr,int k){
        int pivot=lowerbound(arr, 0);
        System.out.println("pivot is "+pivot);
        if(pivot==arr.size())return arr.get(arr.size()-k)*arr.get(arr.size()-k);
        if(pivot==0)return arr.get(k-1)*arr.get(k-1);
        else return search(arr.subList(0, pivot),arr.subList(pivot, arr.size()),k);
    }
    public static int lowerbound(ArrayList<Integer>ls,int val){
        int l=0,r=ls.size()-1,mid,ans=ls.size();
        while(l<=r){
            mid=(l+r)/2;
            if(ls.get(mid)>=val){  
                ans=mid;              
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
    public static int upperbound(ArrayList<Integer>ls,int val){
        int l=0,r=ls.size()-1,mid,ans=ls.size();
        while(l<=r){
            mid=(l+r)/2;
            if(ls.get(mid)>val){  
                ans=mid;              
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
    static class Range implements Comparable<Range>{
        int start,end;
        public Range(int start, int end){
            this.start = start;
            this.end = end;
        }
        public int compareTo(Range other){
            return Integer.compare(this.end,other.end);
        }            
    }
    public static void testing(){
        int[][]paint=new int[][]{{1,3},{4,7},{8,9},{1,10}};
        TreeSet<Range>tr=new TreeSet<>();
        int n=paint.length;
        TreeMap<Integer,Integer>mp=new TreeMap<>();
        // int x=(int)(Math.random()*100);
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            int st=paint[i][0];
            int end=paint[i][1];
            int cover=end-st;
            while(true){
                Range ceiling=tr.ceiling(new Range(0, st));
                if(ceiling==null||ceiling.start>end)break;
                cover-=(Math.min(end,ceiling.end)-Math.max(st,ceiling.start));
                st=Math.min(st,ceiling.start);
                end=Math.max(end,ceiling.end);
                
                tr.remove(ceiling);
            }            
            tr.add(new Range(st, end));
            ans.add(cover);
        }
        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i));
        }
    }
    

}
