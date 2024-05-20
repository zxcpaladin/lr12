package No6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int numThreads = Runtime.getRuntime().availableProcessors(); // Получаем количество ядер процессора

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        int chunkSize = array.length / numThreads;
        int startIndex = 0;

        for (int i = 0; i < numThreads; i++) {
            int endIndex = startIndex + chunkSize;
            if (i == numThreads - 1) {
                endIndex = array.length; // Последний поток обрабатывает оставшиеся элементы
            }

            final int start = startIndex;
            final int end = endIndex;

            executor.submit(() -> {
                int sum = 0;
                for (int j = start; j < end; j++) {
                    sum += array[j];
                }
                System.out.println("Сумма в потоке: " + sum);
            });

            startIndex = endIndex;
        }

        executor.shutdown();
    }
}
