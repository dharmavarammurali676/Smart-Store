package com.sutrix.demo.core.dropdown;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Model(adaptables = SlingHttpServletRequest.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class DropDownModelForEE {

    private static final Logger log = LoggerFactory.getLogger(DropDownModelForEE.class);

    @SlingObject
    private Resource componentResource;     //Used to get the current resource of the component

    private List<Map<String, String>> addemails = new ArrayList<>();
    private List<Map<String,String>> employeedetails = new ArrayList<>();

    public List<Map<String, String>> getAddEmails() {

        return addemails;

    }
    public List<Map<String,String>> getEmployeeDetails(){

        return  employeedetails;
    }

    @PostConstruct
    protected void init() {

        Resource support = componentResource.getChild("addemails");

        if (support!=null){
            for (Resource supports : support.getChildren()){

                Map<String, String> AddEmail = new HashMap<>();

                AddEmail.put("addemails",
                         supports.getValueMap().get("addemails",String.class));

                addemails.add(AddEmail);
            }
        }

        Resource supportPoints = componentResource.getChild("employeedetails");

        //now we will get the listregulars resource which holds the data in different item node.
        if (supportPoints != null) {
            for (Resource supportPoint : supportPoints.getChildren()) {

                Map<String, String> AddEmployee = new HashMap<>();


                // Saving the property into a map, which will be fetched in HTML.
                AddEmployee.put("employeeid",
                        supportPoint.getValueMap().get("employeeid", String.class));

                AddEmployee.put("employeename",
                        supportPoint.getValueMap().get("employeename", String.class));

                AddEmployee.put("mobileno",
                        supportPoint.getValueMap().get("mobileno", String.class));


                employeedetails.add(AddEmployee);
            }
        }

    }

}
