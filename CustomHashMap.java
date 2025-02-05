
public class CustomHashMap<K,V> {
    private static final int  INITIAL_SIZE = 1<<4; //16
    private static final int MAXIMUM_CAPACITY = 1 << 30;

    Entry[] hashTable;
    public CustomHashMap(){
        hashTable=new Entry[INITIAL_SIZE];
    }
    public CustomHashMap(int size){
        hashTable=new Entry[size];
    }
    class Entry<K,V>{
        K key;
        V value;
        Entry next;
        Entry(K k,V v){
            key=k;value=v;
        }
        public K getKey() {
            return key;
        }
        public void setKey(K key) {
            this.key = key;
        }
        public V getValue() {
            return value;
        }
        public void setValue(V value) {
            this.value = value;
        }
    }
    public void put(K key, V value){
        int hashCode=key.hashCode()%hashTable.length;
        Entry node=hashTable[hashCode];
        if(node==null){
            hashTable[hashCode]=new Entry<K,V>(key, value);
        }else{
            Entry prev=node;
            while(node!=null){
                if(node.key==key){
                    node.value=value;return;
                }
                prev=node;node=node.next;
            }
            prev.next=new Entry(key, prev);
        }
    }
    public V get(K key){
        int hashCode=key.hashCode()%hashTable.length;
        Entry node=hashTable[hashCode];
        if(node==null){
            return null;
        }
        while(node!=null){
            if(node.key==key){
                return (V)node.value;
            }
            node=node.next;
        }
        return null;
    }
}
