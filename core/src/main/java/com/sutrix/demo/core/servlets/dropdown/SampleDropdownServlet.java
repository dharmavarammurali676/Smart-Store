package com.sutrix.demo.core.servlets.dropdown;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.json.JSONArray;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;


@Component(service = Servlet.class,
             immediate = true,
                    property = {
                               "sling.servlet.paths=/bin/sample/dropdown/servlet",
                               "sling.servlet.methods=" + HttpConstants.METHOD_GET })
public class SampleDropdownServlet extends SlingAllMethodsServlet {

    private static final long serialVersionUid = 1L;

    private static final Logger LOGGER = LoggerFactory.getLogger(SampleDropdownServlet.class);

    protected void doPost(SlingHttpServletRequest request, final SlingHttpServletResponse response)
            throws ServletException, IOException {


        String dropdownPath = "/apps/mydemo/components/content/task/cq:dialog/content/items/tabs/items/tab2/items/columns/items/well/items/dropdown/datasource";
        String selectedOptionPath = dropdownPath + "/options/" + request.getParameter("dropdownvalue");
        String[] titleValues = request.getParameterValues(selectedOptionPath + "/apps/mydemo/components/content/task/cq:dialog/content/items/tabs/items/tab1/items/columns/items/well/items/name");
    }
}

