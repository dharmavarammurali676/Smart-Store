package com.sutrix.demo.core.models.buy;

import com.fasterxml.jackson.annotation.JacksonInject;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
       adapters = Buy.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class BuyImpl implements Buy {

    @Inject
    private String title;

    @Inject
    private String image;
    @Inject
    private String model;

    @Inject
    private String description;
    @Inject
    private String price;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getImage() {
        return image;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getPrice() {
        return price;
    }
}
