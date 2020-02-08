public class StackNum {
    //a : 栈外还有多少辆车准备入栈
    //b : 栈内一共有多少辆车
    //不考虑从栈中开车去的车
    public static int test(int a,int b){
        if(a == 0){
            return 1;
            //此时栈中的车开出去只有一种顺序
        }
        if(b == 0){
            return test(a-1,1);
            //能走到这个循环 则栈外的车肯定!=0
            //故从栈外的车开一辆进栈内
        }
        return test(a-1,b+1)+test(a,b-1);
        //栈外开入栈内一辆车 //栈内开走一辆车
    }
    public static int f(int n){
        return test(n,0);
    }
    public static void main(String[] args) {
        for(int i = 1; i<17 ;i++){ //车辆1-16
            System.out.println(i+": "+f(i));
        }
    }
}
