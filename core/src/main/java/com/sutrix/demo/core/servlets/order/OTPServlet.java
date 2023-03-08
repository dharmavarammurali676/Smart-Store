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
import org.apache.sling.api.resource.ResourceUtil;
import org.apache.sling.api.resource.ValueMap;
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
                "sling.servlet.paths="+ Constants.OTP_SENDER_PATH
        })
public class OTPServlet extends SlingAllMethodsServlet {

    private final static Logger Log = LoggerFactory.getLogger(OTPServlet.class);

    private static final long serialVersionUID = -876547394343633452L;

    @Reference
    EmailService emailService;

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String Pass = request.getParameter("password");

        ResourceResolver resourceResolver = request.getResourceResolver();
        Resource resource = resourceResolver.getResource("/database/signup_database/users");
        for (Resource childResource : resource.getChildren()) {
            if (ResourceUtil.isNonExistingResource(childResource)) {
                continue;
            }
            ValueMap properties = childResource.getValueMap();

            String Password = properties.get("Password", String.class);

            if (Password.equals(Pass)){
                ResourceResolver resolver = request.getResourceResolver();
                Resource parentResource = resolver.getResource("/database/orders/bookings");
                Iterable<Resource> childResources = parentResource.getChildren();
                for (Resource childResource1 : childResources) {
                    String childNodeName = childResource1.getName();
                    if (childNodeName.equals(email)) {
                        resolver.delete(childResource1);
                        resolver.commit();
                        break;
                    }
                }
                response.getWriter().write("Your order is deleted");
            }else {
                response.getWriter().write("Password is Incorrect enter valid password");
            }

            }

      int OTP = (int) (Math.random() * 1000000);

        emailService.getEmail(email,
                new String[]{Constants.TO_EMAIL},
                "OTP",
                "Your Order Deleted OTP : " + OTP);

    }

}
