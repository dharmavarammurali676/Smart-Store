package com.sutrix.demo.core.servlets.search;


import com.day.cq.commons.jcr.JcrConstants;
import com.day.cq.mailer.MessageGateway;
import com.day.cq.mailer.MessageGatewayService;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component(service = Servlet.class, immediate = true,
        property = {
                "sling.servlet.methods=POST",
                "sling.servlet.paths=/smartphone/search/delete/order"
        })
public class DeleteBookingServlet extends SlingAllMethodsServlet {

    private final static Logger Log = LoggerFactory.getLogger(DeleteBookingServlet.class);

    private static final long serialVersionUID = -7287394343636304212L;


    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {


        String Email = request.getParameter("email");

        Map<String, String> queryParameterMap = new HashMap<>();
        queryParameterMap.put("path", "/database/orders/bookings");
        queryParameterMap.put("type", JcrConstants.NT_UNSTRUCTURED);
        queryParameterMap.put("1_property", "sling:resourceType");
        queryParameterMap.put("1_property.value", "/apps/mydemo/components/content/search");

        response.getWriter().write(queryParameterMap.toString());

    }
}






