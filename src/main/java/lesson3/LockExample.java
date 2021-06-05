package lesson3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample implements Runnable {
    private final Lock lock = new ReentrantLock();
    private static Integer counter = 0;

    @Override
    public void run() {
        lock.lock();
        counter++;
        //убираем лок
        lock.unlock();
        System.out.println(counter);
    }

    public static void main(String[] args) {
        final LockExample lockExample1 = new LockExample();
        final LockExample lockExample2 = new LockExample();
        final LockExample lockExample3 = new LockExample();
        lockExample1.run();
        lockExample2.run();
        lockExample3.run();

    }

}
