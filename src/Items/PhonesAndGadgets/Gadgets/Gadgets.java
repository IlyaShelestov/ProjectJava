package Items.PhonesAndGadgets.Gadgets;

import Items.PhonesAndGadgets.PhonesAndGadgets;

public abstract class Gadgets extends PhonesAndGadgets {
    private String color;
    private String size;
    private String OS;

    public Gadgets(String model, double price, String brand) {
        super(model, price, brand);
    }

    public String getOS() {
        return OS;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }
}