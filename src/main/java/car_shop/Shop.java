package car_shop;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Car> carList = new ArrayList<>(10);
    private Seller seller = new Seller(this);
    final static int TIME_FOR_NEW_CAR = 5000;
    final static int TIME_CAR_DELIVERY = 5000;

    List<Car> soldCars = new ArrayList<>(10);

    public List<Car> sellCar() {
        while (soldCars.size() < 10) {
            try {
                Thread.sleep(TIME_FOR_NEW_CAR);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Car car = seller.sellCar();
            if (car != null) soldCars.add(car);
        }
        return soldCars;
    }

    public void acceptCar() {
        int carNumber = 10;
        for (int i = 0; i < carNumber; i++) {
            try {
                Thread.sleep(TIME_CAR_DELIVERY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            seller.receiveCar();
        }
    }

    public List<Car> getCars() {
        return carList;
    }

}
