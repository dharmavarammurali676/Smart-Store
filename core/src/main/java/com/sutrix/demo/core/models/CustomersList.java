package com.sutrix.demo.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Model(adaptables = SlingHttpServletRequest.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CustomersList {

    private static final Logger log = LoggerFactory.getLogger(CustomersList.class);

    @SlingObject
    private Resource componentResource;     //Used to get the current resource of the component

     @ValueMapValue
    private String title;

    public String getTitle() {
        return title;
    }

    private List<Map<String, String>> addcustomers = new ArrayList<>();

    public List<Map<String, String>> getAddCustomers() {

        return addcustomers;

    }

    @PostConstruct
    protected void init() {

        Resource support = componentResource.getChild("addcustomers");

        if (support != null) {
            for (Resource supports : support.getChildren()) {

                Map<String, String> AddEmail = new HashMap<>();

                AddEmail.put("sno",
                        supports.getValueMap().get("sno", String.class));

                AddEmail.put("surname",
                        supports.getValueMap().get("surname", String.class));

                AddEmail.put("name",
                        supports.getValueMap().get("name", String.class));

                AddEmail.put("email",
                        supports.getValueMap().get("email", String.class));

                AddEmail.put("role",
                        supports.getValueMap().get("role", String.class));

                AddEmail.put("phonenumber",
                        supports.getValueMap().get("phonenumber", String.class));

                AddEmail.put("address",
                        supports.getValueMap().get("address", String.class));


                addcustomers.add(AddEmail);
            }
        }

    }
}
