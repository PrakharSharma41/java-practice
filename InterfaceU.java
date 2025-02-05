public interface InterfaceU extends InterfaceO{
    public void check1();
    default boolean test(){
        return true;
    }
    private void test1(){ // java 9 feature

    }
} 