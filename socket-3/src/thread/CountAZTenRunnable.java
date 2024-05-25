package thread;

public class CountAZTenRunnable implements Runnable {
    public static void main(String[] args) {
        char c1 = 97;
        char c2 = (char) (c1 + 1);

        System.out.println(c1);
        System.out.println(c2);

        CountAZTenRunnable ct = new CountAZTenRunnable();

        Thread t1 = new Thread(ct);

        t1.start();

        try {
            for (int i=0; i < 10;i++) {
                System.out.println(i);
                Thread.sleep(500);
            }
        } catch(InterruptedException e) {
            System.err.println(e);
        }
    }

    public void run() {
        try {
            for(int i = 0; i < 10;i++) {
                System.out.println(i);
                Thread.sleep(1000);
            }
        } catch(InterruptedException e) {
            System.err.println(e);
        }
    }

}
