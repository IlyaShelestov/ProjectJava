package Items;

public abstract class Device {
    protected String model;
    protected double price;
    protected String brand;

    public Device(String model, double price, String brand) {
        this.model = model;
        this.price = price;
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Device{" +
                "model='" + model + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                '}';
    }
}
