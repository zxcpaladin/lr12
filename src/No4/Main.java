package No4;

public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            Thread thread = new Thread(new MyThread(i));
            thread.start();
        }
    }
}

class MyThread implements Runnable {
    private int threadNumber;

    public MyThread(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        System.out.println("Поток " + threadNumber + " выполняется.");
    }
}
