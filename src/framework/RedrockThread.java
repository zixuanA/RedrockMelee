package framework;

public class RedrockThread {
    public static void main(String[] args) {

        Looper looper = new Looper();
        looper.prepare();
        looper.loop();

        System.out.println("游戏结束");

    }
}
