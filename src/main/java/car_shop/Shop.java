package car_shop;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Car> carList = new ArrayList<>(10);
    private Seller seller = new Seller(this);

    public List<Car> sellCar() {
        List<Car> soldCars=new ArrayList<>(10);
        while (soldCars.size()!=10){
            soldCars.add(seller.sellCar());
        }
        return soldCars;
    }

    public void acceptCar() {
        int carNumber = 10;
        for (int i = 0; i < carNumber; i++) {
            seller.receiveCar();
        }
    }

    public List<Car> getCars() {
        return carList;
    }

}
