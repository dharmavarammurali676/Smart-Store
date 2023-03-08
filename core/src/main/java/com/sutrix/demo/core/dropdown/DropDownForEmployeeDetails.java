package com.sutrix.demo.core.dropdown;


import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

@Model(adaptables = {SlingHttpServletRequest.class,
       Resource.class},defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class DropDownForEmployeeDetails {

    @ChildResource
    protected String employeeid;

    @ChildResource
    protected String employeename;

    @ChildResource
    protected String employeemobileno;

    public DropDownForEmployeeDetails() {
    }

    public DropDownForEmployeeDetails(String employeeid, String employeename, String employeemobileno) {
        this.employeeid = employeeid;
        this.employeename = employeename;
        this.employeemobileno = employeemobileno;
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public String getEmployeename() {
        return employeename;
    }

    public String getEmployeemobileno() {
        return employeemobileno;
    }
}
