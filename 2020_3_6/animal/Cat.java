package java15_0306.animal;

public class Cat extends Animal implements IRunning {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(this.name + "使用四条腿跑");
    }
}
