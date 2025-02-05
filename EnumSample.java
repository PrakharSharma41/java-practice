public enum EnumSample {
    MONDAY{
        public void test(){
            System.out.println("in overridden test");
        }
    },
    TUESDAY;
    public void test(){
        System.out.println("in default test");
    }
}
