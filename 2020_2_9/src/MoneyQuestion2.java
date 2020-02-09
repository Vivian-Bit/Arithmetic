//考虑第一个人
public class MoneyQuestion2 {
    //m：持有5角的人
    //n：持有1元的人
    //conductor：售票员手里有多少5角钱
    public static int test(int m,int n,int conductor){
        if(m+conductor<n){
            return 0;
        }
        if(m == 0){
            return 1;
        }
        if(n == 0){
            return 1;
        }
        int r = test(m-1,n,conductor+1);//假设第一个人是5角钱
        if(conductor>0){
            r += test(m,n-1,conductor-1);
        }
        return r;
    }
    public static void main(String[] args) {
        System.out.println(test(2,2,0));//2
        System.out.println(test(3,2,0));//5
        System.out.println(test(5,3,0));//28
        System.out.println(test(2,6,0));//0
        System.out.println(test(10,8,0));//11934
    }
}
