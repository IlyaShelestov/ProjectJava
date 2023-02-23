package Items.PCandLaptops.Laptops;

import Items.PCandLaptops.PCandLaptops;

public abstract class Laptop extends PCandLaptops {
    private double weight;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


    public Laptop(String model, double price, String brand) {
        super(model, price, brand);
    }
}
