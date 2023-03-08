package com.sutrix.demo.core.models.mobile;


import com.day.cq.wcm.api.Page;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.ResourcePath;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;


@Model(adaptables = {Resource.class, SlingAllMethodsServlet.class},
        adapters = Mobile.class,
        resourceType = MobileImpl.RESOURCE_TYPE,
         defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

@Exporter(name = "jackson", extensions = "json", selector ="sample")

//           options = {
//                      @ExporterOption(name = "SerializationFeature.WRAP_ROOT_VALUE", value = "true"),
//                      //@ExporterOption(name = "MapperFeature.SORT_PROPERTIES_ALPHABETICALLY", value ="true")

//@JsonRootName("mobile-Name")
public class MobileImpl implements Mobile {

    private static final Logger LOG = LoggerFactory.getLogger(MobileImpl.class);

    static final String RESOURCE_TYPE = "/apps/mydemo/components/content/mobile";

    @SlingObject
    ResourceResolver resourceResolver;

    @ResourcePath(path= "/content/mydemo/en/mobile-s/iphone")
    @Via("resource")
    Resource resource;

    @ScriptVariable
    Page currentPage;

    @Inject
    private String images;

   @ValueMapValue
    private String mobilename;

    @ValueMapValue
    private String mobilemodel;

    @ValueMapValue
    private String price;

    @ValueMapValue
    private String features;

    @ValueMapValue
    private String link;
//
//    @ValueMapValue
//    private List<String> user;

    @Override
    public String getImages() {
        return images;
    }

    @Override
    public String getMobileName() {
        return mobilename;
    }

    @Override
    public String getMobileModel() {
        return mobilemodel;
    }

    @Override
    public String getPrice() {
        return price;
    }

    @Override
    public String getFeatures() { return features;}

    @Override
    public String getLink() { return link; }

//
//    @Override
//    @JsonProperty("Users list for using this brand")
//    public List<String> getUser() {
//        if (user != null) {
//            return new ArrayList<String>(user);
//        } else {
//            return Collections.emptyList();
//        }
//    }

}
