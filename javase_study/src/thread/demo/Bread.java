package thread.demo;

public class Bread {
    private int count = 20;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void consume() {
        System.out.println("消費者正在消費，目前數量是" + this.count--);
    }

    public void produce() {
        System.out.println("生產者正在生產，目前數量是" + this.count++);
    }


}
