package com.sutrix.demo.core.servlets.order;


import com.day.cq.mailer.MessageGateway;
import com.day.cq.mailer.MessageGatewayService;
import com.sutrix.demo.core.constants.Constants;
import com.sutrix.demo.core.services.EmailService;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service = Servlet.class, immediate = true,
        property = {
                "sling.servlet.methods="+ HttpConstants.METHOD_POST,
                "sling.servlet.paths="+ Constants.ORDER_DELETION_PATH
        })
public class DeleteBookingServlet extends SlingAllMethodsServlet {

    private final static Logger Log = LoggerFactory.getLogger(DeleteBookingServlet.class);

    private static final long serialVersionUID = -7287394343636304212L;

    @Reference
    EmailService emailService;


    @Override
    protected void doPost(SlingHttpServletRequest request,
                          SlingHttpServletResponse response) throws ServletException, IOException {


        String Email = request.getParameter("email");

        ResourceResolver resolver = request.getResourceResolver();
        Resource parentResource = resolver.getResource("/database/orders/bookings");
        Iterable<Resource> childResources = parentResource.getChildren();
        for (Resource childResource : childResources) {
            String childNodeName = childResource.getName();
            if (childNodeName.equals(Email)) {
                resolver.delete(childResource);
                resolver.commit();
                break;

            }
            response.getWriter().write(" Your Order is Deleted");

        }
        emailService.getEmail(Email,
                new String[]{Constants.TO_EMAIL},
                Constants.DELETION_STATUS,
                "Your Order Deleted Successfully &#x1F61E;");
    }
//    public void GeneratedOTP(String Email) {
//        int otp = (int) (Math.random() * 1000000);
//
//        emailService.getEmail(Email,
//                new String[]{},
//                "OTP",
//                "Your Order Deleted OTP : " + otp);
//    }
}






