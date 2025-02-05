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
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;


class Test{
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer>mp=new HashMap<>(1000000,9);
        for(int i=0;i<nums.length;i++){
            mp.put(nums[i], 1);
        }
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
        Thread tr=new abcd();
        tr.start();
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
        //         System.out.println("inside run");
                // TODO Auto-generated method stub
                // throw new UnsupportedOperationException("Unimplemented method 'run'");
        //     };
            
        // };
        // rtr.run();
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
        // System.out.println(lowerbound(new ArrayList<Integer>(Arrays.asList(1,1,1,1,100)),20));
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
        TreeMap<Integer,Integer> tm=new TreeMap<>();
        tm.put(1, 1);
        System.out.println(tm.ceilingKey(100));;
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
