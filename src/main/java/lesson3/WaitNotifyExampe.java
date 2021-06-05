package lesson3;

public class WaitNotifyExampe {
    boolean isPing = true;

    public synchronized void ping() {
        while (!isPing) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Ping!");
        isPing = false;
        notifyAll();
    }

    public synchronized void pong() {
        while (isPing) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Pong!");
        isPing = true;
        notifyAll();

    }

    public static void main(String[] args) throws InterruptedException {
        final WaitNotifyExampe waitNotifyExampe = new WaitNotifyExampe();
        Thread t1 = new Thread(waitNotifyExampe::ping);
        Thread t2 = new Thread(waitNotifyExampe::pong);
        t1.start();
        t2.start();

    }

}
