package No3;

public class EvenOddPrinter {
    static boolean flag = true;

    public static void main(String[] args) {
        Runnable odd = () -> {
            for (int i = 1; i <= 10;) {
                if (EvenOddPrinter.flag) {
                    System.out.println(Thread.currentThread().getName() + " " + i);
                    i += 2;
                    EvenOddPrinter.flag = !EvenOddPrinter.flag;
                }
            }
        };

        Runnable even = () -> {
            for (int i = 2; i <= 10;) {
                if (!EvenOddPrinter.flag) {
                    System.out.println(Thread.currentThread().getName() + " " + i);
                    i += 2;
                    EvenOddPrinter.flag = !EvenOddPrinter.flag;
                }
            }
        };

        Thread t1 = new Thread(odd);
        Thread t2 = new Thread(even);

        t1.setName("Thread-1");
        t2.setName("Thread-2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Printing over");
    }
}




