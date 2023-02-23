package Items.PhonesAndGadgets.Gadgets.FitnessBracelet;

import Items.PhonesAndGadgets.Gadgets.Gadgets;

public abstract class FitnessBracelet extends Gadgets {
    private boolean isFitnessBracelet;

    public FitnessBracelet(String model, double price, String brand) {
        super(model, price, brand);
    }

    public boolean isFitnessBracelet() {
        return isFitnessBracelet;
    }
}
