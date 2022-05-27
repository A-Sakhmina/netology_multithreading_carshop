import car_shop.Shop;

public class Main {
    public static void main(String[] args) {
        final Shop shop = new Shop();
        ThreadGroup buyers = new ThreadGroup("buyers");

        new Thread(buyers, shop::sellCar, "Покупатель1").start();
        new Thread(buyers, shop::sellCar, "Покупатель2").start();
        new Thread(buyers, shop::sellCar, "Покупатель3").start();


        //завод
        new Thread(null,shop::acceptCar,"Производитель Toyota").start();

        //buyers.interrupt();

    }
}
