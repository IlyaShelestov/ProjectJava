package Items.PhonesAndGadgets;

import Items.Device;

public abstract class PhonesAndGadgets extends Device {
    private final boolean isWearable = true;

    public PhonesAndGadgets(String model, double price, String brand) {
        super(model, price, brand);
    }
}
