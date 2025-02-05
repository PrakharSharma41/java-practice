public class Doctor extends Person{
    Doctor(){
        super(2);
        System.out.println("in doctor constructor");
    }
    public void check(){
        System.out.println("inside doctor");
    }
}
