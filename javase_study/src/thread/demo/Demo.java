package thread.demo;

public class Demo {
    public static void main(String[] args) {
        Bread bread = new Bread();
        new Consumers(bread).start();
        new Producers(bread).start();
    }
}
