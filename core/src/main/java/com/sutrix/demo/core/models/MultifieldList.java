package com.sutrix.demo.core.models;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MultifieldList {
    @ValueMapValue
    private String sno;
    @ValueMapValue
    private String surname;
    @ValueMapValue
    private String name;
    @ValueMapValue
    private String email;
    @ValueMapValue
    private String role;
    @ValueMapValue
    private String phonenumber;
    @ValueMapValue
    private String address;

    public String getSno() {
        return sno;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getAddress() {
        return address;
    }

}
