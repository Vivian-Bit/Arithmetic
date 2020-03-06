package java15_0306.sort;

// 我找男票的标准
// 1. 钱
// 2. 颜值
public class Boy implements Comparable<Boy> {
    private String name;
    private int money;
    private int faceValue;

    public Boy(String name, int money, int faceValue) {
        this.name = name;
        this.money = money;
        this.faceValue = faceValue;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "name='" + name + '\'' +
                ", money=" + money +
                ", faceValue=" + faceValue +
                '}';
    }

    @Override
    public int compareTo(Boy o) {
        // 比较 this 和 other
        // 如果是 this 在 other 前面, 就应该返回 < 0
        // 如果是 this 在 other 后面, 就应该返回 > 0
        // 如果是 this 和 other 并列, 就应该返回 0
        if (this.money > o.money) {
            // this 在前
            return -1;
        }
        if (this.money < o.money) {
            // other 在前
            return 1;
        }
        // 钱一样多, 再比较脸
        if (this.faceValue > o.faceValue) {
            return -1;
        }
        if (this.faceValue < o.faceValue) {
            return 1;
        }
        // 钱和脸都一样的话, 两者就并列
        return 0;
    }
}
