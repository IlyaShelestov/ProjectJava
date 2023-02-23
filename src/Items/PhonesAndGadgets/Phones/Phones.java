package Items.PhonesAndGadgets.Phones;

import Items.PhonesAndGadgets.PhonesAndGadgets;

public abstract class Phones extends PhonesAndGadgets {
    private String battery;
    private double weight;

    public Phones(String model, double price, String brand) {
        super(model, price, brand);
    }
}
