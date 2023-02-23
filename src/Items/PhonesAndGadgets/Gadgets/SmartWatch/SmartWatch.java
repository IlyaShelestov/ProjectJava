package Items.PhonesAndGadgets.Gadgets.SmartWatch;

import Items.PhonesAndGadgets.Gadgets.Gadgets;

public abstract class SmartWatch extends Gadgets {
    private String notifications; //откуда приходят уведомления Telegram,Facebook,Instagram

    public SmartWatch(String model, double price, String brand) {
        super(model, price, brand);
    }

    public String getNotifications() {
        return notifications;
    }
}
