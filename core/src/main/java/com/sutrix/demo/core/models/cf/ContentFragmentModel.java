package com.sutrix.demo.core.models.cf;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adapters = Resource.class,
        adaptables = ContentFragment.class,
         defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ContentFragmentModel implements  ContentFragment{

    @ValueMapValue
    private String cfPath;
     @Override
    public String getCfPath() {
        return cfPath;
    }
}
