import car_shop.Shop;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final Shop shop = new Shop();
        ThreadGroup buyers = new ThreadGroup("buyers");

        final int timeForABuyer = 2000;
        new Thread(buyers, shop::sellCar, "Покупатель1").start();
        Thread.sleep(timeForABuyer);
        new Thread(buyers, shop::sellCar, "Покупатель2").start();
        Thread.sleep(timeForABuyer);
        new Thread(buyers, shop::sellCar, "Покупатель3").start();
        Thread.sleep(timeForABuyer);

        //завод
        Thread driver = new Thread(null, shop::acceptCar, "Производитель Toyota");
        driver.start();
        Thread.sleep(timeForABuyer);

        driver.join();
        buyers.interrupt();

    }
}
