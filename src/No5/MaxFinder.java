package No5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class MaxFinder {
    public static int findMaxMultiThreaded(int[] arr) {
        int numThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        int chunkSize = arr.length / numThreads;
        AtomicInteger max = new AtomicInteger(Integer.MIN_VALUE);

        for (int i = 0; i < numThreads; i++) {
            final int start = i * chunkSize;
            final int end = (i == numThreads - 1) ? arr.length : (i + 1) * chunkSize;

            executor.execute(() -> {
                int localMax = Integer.MIN_VALUE;
                for (int j = start; j < end; j++) {
                    localMax = Math.max(localMax, arr[j]);
                }
                synchronized (MaxFinder.class) {
                    max.set(Math.max(max.get(), localMax));
                }
            });
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
            // Wait for all threads to finish
        }

        return max.get();
    }

    public static void main(String[] args) {
        int[] arr = {2, 6, 16, 54};
        int max = findMaxMultiThreaded(arr);
        System.out.println("Максимальный элемент: " + max);
    }
}