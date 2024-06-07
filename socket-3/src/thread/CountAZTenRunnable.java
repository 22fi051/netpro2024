package thread;

import java.util.concurrent.Semaphore;

public class CountAZTenRunnable {

    public static void main(String[] args) {
        Thread[] threads = new Thread[26];
        Semaphore[] semaphores = new Semaphore[26];

        for(int i = 0; i < 26; i++) {
            semaphores[i] = new Semaphore(i == 0 ? 1 : 0);
        }

        for(int i = 0; i < threads.length; i++) {
            final int threadNum = i;
            final Semaphore currentSemaphore = semaphores[i];
            final Semaphore nextSemaphore = semaphores[(i + 1) % 26];
            threads[i] = new Thread(() -> {
                try {
                    currentSemaphore.acquire();
                    for(int j = 1; j <= 10; j++) {
                        System.out.println((char)('a' + threadNum) + String.valueOf(j));
                        Thread.sleep(100);
                    }
                    nextSemaphore.release();
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        for(Thread thread : threads) {
            thread.start();
        }
    }
}
