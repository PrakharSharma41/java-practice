
public class OuterClass {
    static int staticVar=10;
    int instanceVar=20;
    class InnerClass{
        InnerClass(){
            System.out.println("inside inner class");
        }
        public static void print(){
            System.out.println(staticVar+"asa");
        }
    }
    @Example
    public static void abcd(){
        System.out.println("inside abcd");
    }
}
