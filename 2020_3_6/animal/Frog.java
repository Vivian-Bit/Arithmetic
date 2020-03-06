package java15_0306.animal;

public class Frog extends Animal implements IRunning, ISwimming {
    public Frog(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(this.name + " 一跳一跳");
    }

    @Override
    public void swim() {
        System.out.println(this.name + " 蛙泳");
    }
}
