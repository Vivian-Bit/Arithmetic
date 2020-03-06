package java15_0306.animal;

public class Test {
    public static void main(String[] args) {
        Frog frog = new Frog("小青蛙");
        walk(frog);

        Cat cat = new Cat("小猫");
        walk(cat);

        Insect insect = new Insect("小虫");
        walk(insect);
        fly(insect);

        Robot robot = new Robot();
        walk(robot);
    }

    // walk 表示散步~~
    // 如果参数写成 Animal 不科学的.
    // 不是所有的动物都能散步. 会跑的动物才能散步
    public static void walk(IRunning animal) {
        animal.run();
    }

    public static void fly(IFlying animal) {
        animal.fly();
    }
}
