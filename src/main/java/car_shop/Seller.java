package car_shop;

public class Seller {
    private Shop shop;

    public Seller(Shop shop) {
        this.shop = shop;
    }

    public synchronized void receiveCar() {
        try {
            int carCreatingTime = 1000;
            Thread.sleep(carCreatingTime);
            System.out.println(Thread.currentThread().getName() + " выпустил 1 авто. Итого в салоне "
                    + (shop.getCars().size() + 1) + "шт.");
            shop.getCars().add(new Car());
            notifyAll();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    public synchronized Car sellCar() {
        try {
            System.out.println(Thread.currentThread().getName() + " зашел в автосалон");
            while (shop.getCars().size() == 0) {
                System.out.println(Thread.currentThread().getName() + " Машин нет");
                wait();
            }
            System.out.println(Thread.currentThread().getName() + " уехал на новеньком авто");
            return shop.getCars().remove(0);
        } catch (InterruptedException exception) {
//            exception.printStackTrace();
            System.out.println(Thread.currentThread().getName() + " ушёл");
        }
        return null;
    }
}
