package Items.PhonesAndGadgets.Tablets;

import Items.PhonesAndGadgets.PhonesAndGadgets;


public abstract class Tablets extends PhonesAndGadgets {
    private String diagonal;

    public Tablets(String model, double price, String brand) {
        super(model, price, brand);
    }
}
