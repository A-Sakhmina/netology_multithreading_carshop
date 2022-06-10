package car_shop;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Seller {
    private Shop shop;
    private ReentrantLock locker = new ReentrantLock(true);
    private Condition condition = locker.newCondition();

    public Seller(Shop shop) {
        this.shop = shop;
    }

    public void receiveCar() {

        try {
            locker.lock();
            System.out.println(Thread.currentThread().getName() + " выпустил 1 авто. Итого в салоне "
                    + (shop.getCars().size() + 1) + "шт.");
            shop.getCars().add(new Car());
            condition.signalAll();
        } finally {

            locker.unlock();
        }
    }

    public Car sellCar() {

        try {
            locker.lock();
            System.out.println(Thread.currentThread().getName() + " зашел в автосалон");
            while (shop.getCars().size() == 0) {
                System.out.println(Thread.currentThread().getName() + " Машин нет");
                condition.await();
            }
            System.out.println(Thread.currentThread().getName() + " уехал на новеньком авто");
            return shop.getCars().remove(0);
        } catch (InterruptedException exception) {
            System.out.println(Thread.currentThread().getName() + " ушёл");
        } finally {
            locker.unlock();
        }
        return null;
    }
}
