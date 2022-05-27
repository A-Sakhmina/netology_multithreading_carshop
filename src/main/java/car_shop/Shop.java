package car_shop;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Car> carList = new ArrayList<>(10);
    private Seller seller = new Seller(this);

    List<Car> soldCars = new ArrayList<>(10);

    public List<Car> sellCar() {
        while (soldCars.size() < 10) {
            try {
                int timeForNewCar = 5000;
                Thread.sleep(timeForNewCar);
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
                int timeForNewCarToBeDelivered = 5000;
                Thread.sleep(timeForNewCarToBeDelivered);
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
