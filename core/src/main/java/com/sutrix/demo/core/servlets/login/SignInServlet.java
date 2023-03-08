package com.sutrix.demo.core.servlets.login;

import com.sutrix.demo.core.constants.Constants;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.*;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.jcr.api.SlingRepository;
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
                "sling.servlet.paths="+ Constants.USER_SIGNIN_PATH
        })
public class SignInServlet extends SlingAllMethodsServlet {

    private final static Logger Log = LoggerFactory.getLogger(SignInServlet.class);

    private static final long serialVersionUID = -7287396217733304212L;

    @Override
    protected void doPost(SlingHttpServletRequest request,
                          SlingHttpServletResponse response) throws ServletException, IOException {


        String em = request.getParameter("email");
        String pass = request.getParameter("password");

        ResourceResolver resourceResolver = request.getResourceResolver();
        Resource resource = resourceResolver.getResource("/database/signup_database/users");
        for (Resource childResource : resource.getChildren()) {
            if (ResourceUtil.isNonExistingResource(childResource)) {
                continue;
            }
            ValueMap properties = childResource.getValueMap();
            String Email = properties.get("Email", String.class);
            String Password = properties.get("Password", String.class);
            if (em.equals(Email) && pass.equals(Password)) {
                response.sendRedirect("/content/mydemo/sign_up---sign_in/home-page.html");
            } else {

                response.getWriter().write("Given incorrect input - Please try to give valid input");
            }
        }
    }

}


