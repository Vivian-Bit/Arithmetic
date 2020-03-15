package lianxi_0313;

public class Solution {
    public static int calculateMax(int[] prices) {
        int firstBuy = Integer.MAX_VALUE; // 第一次买入最好的价格，越低越好
        int firstSell = 0; // 第一次卖出后的最高收益，越高越好
        int secondBuy = Integer.MIN_VALUE; // 第二次买入时还剩余的最高收益，越高越好
        int secondSell = 0; // 第二次卖出时总的最高收益，越高越好
        for (int price : prices) {
            // 当前价格下第一次买入的价格
            firstBuy = Math.min(firstBuy, price);
            // 当前价格 - 买入价格 就是当前价格下第一次买卖的收益
            firstSell = Math.max(firstSell, price - firstBuy);

            // 第一次卖出的收益 - 当前价格，即当前价格下，第二次买入后还剩余收益
            secondBuy = Math.max(secondBuy, firstSell - price);
            // 剩余收益 + 当前价格，即当前价格下，第二次买卖的收益
            secondSell = Math.max(secondSell, secondBuy + price);
        }
        return secondSell;
    }
}
 class Solution3 {
    private int[] prices;
    public int maxProfit(int[] prices) {
        if(prices.length<=1) return 0;
        this.prices=prices;
        return dfs(0,false,0,0);
    }

    private  int dfs(int i,boolean isBuy,int buyTime,int count){
        //如果已经买了两次了并且第二次已经卖掉了，或者已经遍历到最后，则停止遍历。
        if((buyTime>=2 && !isBuy) || i>=prices.length) return count;
        int currentPrices=prices[i];
        if(isBuy){
            //手上有股票，所以只能卖或者保持不动
            //卖股票的情况
            int sellCount=dfs(i+1,false,buyTime,count+currentPrices);
            //保持不动的情况
            int notSell=dfs(i+1,true,buyTime,count);
            //计算是卖股票的情况与保持不动的利润比较，获取大的
            count=Math.max(sellCount,notSell);
        }else{
            //手上没有股票，所以只能买或者保持不动
            //1、买股票的情况
            int buyCount=dfs(i+1,true,buyTime+1,count-currentPrices);
            //2、保持不动的情况
            int notBuy=dfs(i+1,false,buyTime,count);
            //比较两种情况的利润，获取最大的利润
            count=Math.max(buyCount,notBuy);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println( new Solution3().maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }
}

class Solution1 {
    public int maxProfit(int[] prices) {
        if(prices.length<=1) return 0;
        int length=prices.length;
        int k=2;//最多只能买卖两次

        //一维的下标是代表第几天，二维的下标是代表最多交易次数,
        // 三维的下标代表当前手上是否持有股票，0未持有，1持有.对应的值为当前最大利润.
        int dp[][][]=new int[length][k+1][2];

        //第一天
        dp[0][2][0]=0;//未买股票。
        dp[0][2][1]=-prices[0];//买了股票
        dp[0][1][0]=0;//未买股票
        dp[0][1][1]=-prices[0];//买了股票

        for(int i=1;i<length;i++){
            for(int j=k;j>0;j--){
                //从第二天开始，有两种情况。
                //如果想今天持有股票，那么有两种情况
                //1、前面一天已经买了股票，今天持有,利润不变
                int hold=dp[i-1][j][1];
                //2、前面一天没有持有股票，今天买了股票.
                int buy=dp[i-1][j-1][0]-prices[i];
                dp[i][j][1]=Math.max(hold,buy);

                //如果今天没有股票，那么也有两种情况
                //1、前一天就没有股票,今天也不买
                int notBuy=dp[i-1][j][0];
                //2、前一天有股票，但是今天卖了。
                int sell=dp[i-1][j][1]+prices[i];
                dp[i][j][0]=Math.max(notBuy,sell);
            }
        }
        return dp[length-1][k][0];
    }
}
//优化代码结构,我们发现当天的最大利润，只跟前面一天的最大利润有关。所以我们不需要数组存储每天的利润，最需要存储前一天的最大利润即可。
class Solution2 {
    public int maxProfit(int[] prices) {
        if(prices.length<=1) return 0;
        int length=prices.length;
        int buyOneHaveStock=-prices[0];//最多买一次，并且有股票
        int buyOneNotStock=0;//最多买一次，手上没有股票
        int buyTwoHaveStock=-prices[0];//最多买两次，并且有股票
        int buyTwoNotStock=0;//最多买两次，手上没有股票
        for(int i=1;i<length;i++){
            //今天最多买一次，手上没有股票，有两种情况
            //要么昨天手上就没有股票，要么今天卖出了,卖出时需要加上当前股票价格。取两者最大值
            buyOneNotStock=Math.max(buyOneNotStock,buyOneHaveStock+prices[i]);
            //今天手上有股票
            //要么昨天手上就有股票，今天持有，要么就是昨天没有股票，今天买入.
            //-prices[i]解释：因为今天是最多买一次，那么今天买入的话，前面几天都不能买，也就是总利润为0.
            buyOneHaveStock=Math.max(buyOneHaveStock,-prices[i]);

            buyTwoNotStock=Math.max(buyTwoNotStock,buyTwoHaveStock+prices[i]);
            //buyOneNotStock-prices[i]解释:因为今天做多买两次，且今天要买1次，那么前面些天最多只能买1次，所以前面些天的利润为buyOneNotStock-prices[i]
            buyTwoHaveStock=Math.max(buyTwoHaveStock,buyOneNotStock-prices[i]);

        }
        return buyTwoNotStock;
    }
}

