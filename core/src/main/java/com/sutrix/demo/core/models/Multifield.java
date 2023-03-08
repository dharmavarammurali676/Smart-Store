package com.sutrix.demo.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.*;

@Model(adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Multifield {
    @ValueMapValue
    private String title;
    @ChildResource
    private List<MultifieldList> multifieldLists;

    public String getTitle() {
        return title;
    }

    public List<MultifieldList> getMultifieldLists() {
        return multifieldLists;
    }



}





