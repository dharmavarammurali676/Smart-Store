package com.sutrix.demo.core.models.features;

import java.util.List;

public interface Features {

    String getImage();

    String getSecondImage();

    String getFirstBrand();

    String getSecondBrand();

    String getFirstDescription();

    String getFirstLink();

    String getSecondDescription();

    String getSecondLink();

    //// First SmartPhone
    String getModel();

    String getPrice();

    String getProcessor();

    String getRearCamera();

    String getSimType();

    String getBatteryCapacity();

    String getWarrenty();

    String getRam();

    String getRom();

    //// Second SmartPhone
    String getSecondModel();

    String getSecondPrice();

    String getSecondProcessor();

    String getSecondRearCamera();

    String getSecondSimType();

    String getSecondBatteryCapacity();

    String getSecondWarrenty();

    String getSecondRam();

    String getSecondRom();
}
