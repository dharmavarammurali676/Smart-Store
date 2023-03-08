package com.sutrix.demo.core.servlets.login;


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
import org.apache.sling.models.annotations.Model;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service = Servlet.class, immediate = true,
        property = {
                "sling.servlet.methods=" + HttpConstants.METHOD_POST,
                "sling.servlet.paths=" + Constants.USER_DELETION_PATH
        })
public class DeleteAccount extends SlingAllMethodsServlet {

    private final static Logger LOGGER = LoggerFactory.getLogger(DeleteAccount.class);

    private static final long serialVersionUID = -796304212L;

    @Reference
    EmailService emailService;

    @Override
    protected void doPost(SlingHttpServletRequest request,
                          SlingHttpServletResponse response) throws ServletException, IOException {

        String Email = request.getParameter("email");

        ResourceResolver resourceResolver = request.getResourceResolver();
        Resource resource = resourceResolver.getResource("/database/signup_database/users");
        Iterable<Resource> childResource = resource.getChildren();
        for (Resource childResources : childResource) {
            String childName = childResources.getName();
            if (childName.equals(Email)) {
                resourceResolver.delete(childResources);
                resourceResolver.commit();
            }
            response.getWriter().write("Your Account is deleted ");
        }
        emailService.getEmail(Constants.TO_EMAIL,
                new String[]{Constants.CC_EMAIL},
                Constants.ACCOUNT_STATUS,
                "Your SmartStore Website Account is Deleted");

    }
}
