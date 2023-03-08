package com.sutrix.demo.core.models.features;


import com.sutrix.demo.core.models.features.Features;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
       adapters = Features.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class FeaturesImpl implements Features {

    @Inject
    private String image;

    @Inject
    private String secondimage;

    @Inject
    private String firstbrand;


    @Inject
    private String secondbrand;

    @Inject
    private String firstdescription;

    @Inject
    private String firstlink;

    @Inject
    private String seconddescription;

    @Inject
    private String secondlink;

    /////// First Features
    @Inject
    private String model ;

    @Inject
    private String price ;

    @Inject
    private String processor;

    @Inject
    private String rearcamera;

    @Inject
    private String simtype;

    @Inject
    private String batterycapacity;

    @Inject
    private String warrenty;

    @Inject
    private String ram;

    @Inject
    private String rom;

    /////// Second Features
    @Inject
    private String secondmodel ;

    @Inject
    private String secondprice ;

    @Inject
    private String secondprocessor;

    @Inject
    private String secondrearcamera;

    @Inject
    private String secondsimtype;

    @Inject
    private String secondbatterycapacity;

    @Inject
    private String secondwarrenty;

    @Inject
    private String secondram;

    @Inject
    private String secondrom;


    @Override
    public String getImage() {
        return image;
    }

    @Override
    public String getSecondImage() {
        return secondimage;
    }

    @Override
    public String getFirstBrand() {
        return firstbrand;
    }

    @Override
    public String getSecondBrand() {
        return secondbrand;
    }

    @Override
    public String getFirstDescription() {
        return firstdescription;
    }

    @Override
    public String getFirstLink() {
        return firstlink;
    }

    @Override
    public String getSecondDescription() {
        return seconddescription;
    }

    @Override
    public String getSecondLink() {
        return secondlink;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getPrice() {
        return price;
    }

    @Override
    public String getProcessor() {
        return processor;
    }

    @Override
    public String getRearCamera() {
        return rearcamera;
    }

    @Override
    public String getSimType() {
        return simtype;
    }

    @Override
    public String getBatteryCapacity() {
        return batterycapacity;
    }

    @Override
    public String getWarrenty() {
        return warrenty;
    }

    @Override
    public String getRam() { return ram; }

    @Override
    public String getRom() { return rom; }

    /////// Second Features

    @Override
    public String getSecondModel() {
        return secondmodel;
    }

    @Override
    public String getSecondPrice() {
        return secondprice;
    }

    @Override
    public String getSecondProcessor() {
        return secondprocessor;
    }

    @Override
    public String getSecondRearCamera() {
        return secondrearcamera;
    }

    @Override
    public String getSecondSimType() {
        return secondsimtype;
    }

    @Override
    public String getSecondBatteryCapacity() {
        return secondbatterycapacity;
    }

    @Override
    public String getSecondWarrenty() {
        return secondwarrenty;
    }

    @Override
    public String getSecondRam() {
        return secondram;
    }

    @Override
    public String getSecondRom() {
        return secondrom;
    }

}
