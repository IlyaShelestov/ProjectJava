package Items.PhonesAndGadgets.Phones.MobilePhones;

import Items.PhonesAndGadgets.Phones.Phones;

public abstract class MobilePhone extends Phones {
    private String Speakerphone;
    private String callerID;

    public MobilePhone(String model, double price, String brand) {
        super(model, price, brand);
    }

    public String getSpeakerphone() {
        return Speakerphone;
    }

    public String getCallerID() {
        return callerID;
    }

}
