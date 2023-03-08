package com.sutrix.demo.core.models.navimage;


import com.sutrix.demo.core.models.navimage.NavImage;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = NavImage.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class NavImageImpl implements NavImage {


    @Inject
    private String image;

    public String getImage() {
        return image;
    }


}
