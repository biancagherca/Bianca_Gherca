package ro.sci.week_05.PhoneModels;

import ro.sci.week_05.PhoneManufacturers.Apple;

import java.awt.*;

public class Iphone11 extends Apple {
    public static final int BATTERY_LIFE = 17;


    public Iphone11(String imeiCode, Color color, String material) {
        super(imeiCode, color, material);
    }
}
