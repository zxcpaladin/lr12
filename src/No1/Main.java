package No1;

public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread 1: " + Thread.currentThread().getName() + " - " + System.currentTimeMillis());
                try {
                    Thread.sleep(1000); // Подождать 1 секунду
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread 2: " + Thread.currentThread().getName() + " - " + System.currentTimeMillis());
                try {
                    Thread.sleep(1000); // Подождать 1 секунду
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
