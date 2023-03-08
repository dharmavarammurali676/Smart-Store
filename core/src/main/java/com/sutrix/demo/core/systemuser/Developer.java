package com.sutrix.demo.core.systemuser;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Lab2020CommonMethods Class.
 *
 * @author riccardo.teruzzi
 */
public class Developer {

    /**
     * Constant for Read Write Service.
     */
    private static final String DEVELOPER_READ_WRITE_SERVICE = "developerReadWriteService";
    /**
     * Constant for Logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(Developer.class);


    /**
     * Gets resource resolver.
     *
     * @param rFactory the r factory
     * @return resource resolver This method is used to get the resource resolver by providing the resource resolver factory.
     */
    public static ResourceResolver getResourceResolver(final ResourceResolverFactory rFactory) {
        ResourceResolver resolver = null;
        Map<String, Object> param = getServiceParams();
        try {
            resolver = rFactory.getServiceResourceResolver(param);
        } catch (LoginException e) {
            LOG.error(e.getMessage(), e);
        }
        return resolver;
    }

    /**
     * @return params
     */
    private static Map<String, Object> getServiceParams() {
        Map<String, Object> param = new HashMap<>();
        param.put(ResourceResolverFactory.SUBSERVICE, DEVELOPER_READ_WRITE_SERVICE);
        return param;
    }

}