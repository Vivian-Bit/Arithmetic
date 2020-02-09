/*
1 2 3 4 5 6 7 8 9 = 110 //填写+-符号
 */
public class FillSymbol {
    //a：参加运算的元素
    //index：目前考虑的元素的下标
    //result：结果串
    //goal：计算目标
    public static void test(int[] a,int index,String result,int goal){
        if(index == 0){
            if(a[0]==goal){
                System.out.println(a[0]+result);
            }
            return;
        }

        //假设a[index]前为+
        test(a,index-1,"+"+a[index]+result,goal-a[index]);

        //假设a[index]前为-
        test(a,index-1,"-"+a[index]+result,goal+a[index]);

        //假设a[index]前为-
        int old = a[index-1];
        a[index-1] = Integer.parseInt(""+a[index-1]+a[index]); //89
        test(a,index-1,result,goal);
        //注意：数组a发生改变  一定要在递归结束后立刻更改回去
        a[index-1] = old;
    }
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9};
        test(a,8,"",110);
    }

    /*
            12+34+56+7-8+9
            123+4-5-6-7-8+9
            1+2+34+5+67-8+9
            1+234-56-78+9
            123-4+5-6-7+8-9
            123-4-5+6+7-8-9
            12+3+45+67-8-9
            1-2+3+45-6+78-9
            12-3+4-5+6+7+89
            123+4+5+67-89
     */
}
