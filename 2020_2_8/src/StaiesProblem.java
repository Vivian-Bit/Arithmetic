public class StaiesProblem {
    public static int test1(int m){
        if(m==2) {
            return 1;
        }
        if(m==1){
            return 1;
        }
        return test(m-1)+test(m-2);
    }
    public static int test(int m){
        if(m==2) {
            return 1;
        }
        if(m==1){
            return 0;
        }
        return test1(m-1)+test1(m-2);
    }
    public static void main(String[] args) {
        System.out.println(test(39));
    }
}
