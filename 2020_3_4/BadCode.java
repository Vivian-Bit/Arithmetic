package java15_0304;

class B {
    public B() {
        func();
    }

    public void func() {
        System.out.println("B.func");
    }
}

class D extends B {
    private int num = 1;

    @Override
    public void func() {
        System.out.println("D.func " + num);
    }
}

public class BadCode {
    public static void main(String[] args) {
        // 程序输出效果是啥样子的??
        // 在创建 D 对象的时候, 会先创建对应的父类对象
        // 预期效果, 看起来应该是 构造 B 的时候, 执行 B 的构造方法, 打印 B.func
        // 构造 D 的时候, D 没有构造方法, 也就啥都不打印
        D d = new D();
    }
}
