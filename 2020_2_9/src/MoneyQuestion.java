//考虑最后一个人
public class MoneyQuestion {
    //持有5角的有m人，持有1元的有n人
    public static int test(int m,int n){
        if(m<n){
            return 0;
            //无论如何都不能完成
        }
        if(m == 1){
            return 1;
            //此时肯定是m=1,n=1 否则从第一个if返回
        }
        if(n == 0){
            return 1;
            //此时m!=0
        }
        return test(m-1,n)+test(m,n-1);
        //队尾持有5角 前面的人test(m-1,n)有多少种解法
        //队尾持有1元  前面的人test(m,n-1)有多少种解法
    }
    public static void main(String[] args) {
        System.out.println(test(2,2));//2
        System.out.println(test(3,2));//5
        System.out.println(test(5,3));//28
        System.out.println(test(2,6));//0
        System.out.println(test(10,8));//11934
    }
}
