package com.sutrix.demo.core.dropdown;


import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

@Model(adaptables = {SlingHttpServletRequest.class,
       Resource.class},defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class DropDownForAddEmail {

    @SlingObject
    ResourceResolver resourceResolver;

    @ChildResource
    private String email;


    public DropDownForAddEmail() {
    }

    public DropDownForAddEmail(String email) {
        this.email = email;
    }


    public String getEmail() {
        return email;
    }
}
