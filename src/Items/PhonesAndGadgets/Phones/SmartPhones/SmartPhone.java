package Items.PhonesAndGadgets.Phones.SmartPhones;

import Items.PhonesAndGadgets.Phones.Phones;

public abstract class SmartPhone extends Phones {
    private String OS;
    private int memory;
    private String camera;
    private String display;

    public SmartPhone(String model, double price, String brand) {
        super(model, price, brand);
    }

    public String getDisplay() {
        return display;
    }

    public String getCamera() {
        return camera;
    }

    public String getOS() {
        return OS;
    }

    public int getMemory() {
        return memory;
    }
}
