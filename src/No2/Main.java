package No2;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        // Используем IntStream для создания потока чисел от 1 до 10
        IntStream.rangeClosed(1, 10)
                .forEachOrdered(number -> {
                    System.out.println(number);
                    try {
                        Thread.sleep(1000); // Задержка в 1 секунду
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
    }
}

