import car_shop.Shop;

public class Main {
    final static int TIME_FOR_BUYER = 2000;
    public static void main(String[] args) throws InterruptedException {
        final Shop shop = new Shop();
        ThreadGroup buyers = new ThreadGroup("buyers");

        new Thread(buyers, shop::sellCar, "Покупатель1").start();
        Thread.sleep(TIME_FOR_BUYER);
        new Thread(buyers, shop::sellCar, "Покупатель2").start();
        Thread.sleep(TIME_FOR_BUYER);
        new Thread(buyers, shop::sellCar, "Покупатель3").start();
        Thread.sleep(TIME_FOR_BUYER);

        //завод
        Thread driver = new Thread(null, shop::acceptCar, "Производитель Toyota");
        driver.start();
        Thread.sleep(TIME_FOR_BUYER);

        driver.join();
        buyers.interrupt();

    }
}
