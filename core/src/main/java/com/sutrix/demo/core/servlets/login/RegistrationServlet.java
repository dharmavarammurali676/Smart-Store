package com.sutrix.demo.core.servlets.login;


import com.day.cq.mailer.MessageGateway;
import com.day.cq.mailer.MessageGatewayService;
import com.sutrix.demo.core.bean.SignupUser;
import com.sutrix.demo.core.constants.Constants;
import com.sutrix.demo.core.services.EmailService;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.jcr.api.SlingRepository;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.*;
import javax.jcr.lock.LockException;
import javax.jcr.nodetype.ConstraintViolationException;
import javax.jcr.nodetype.NoSuchNodeTypeException;
import javax.jcr.version.VersionException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

@Component(service = Servlet.class, immediate = true,
        property = {
                "sling.servlet.methods=" + HttpConstants.METHOD_POST,
                "sling.servlet.paths=" + Constants.USER_REGISTRATION_PATH
        })
public class RegistrationServlet extends SlingAllMethodsServlet {

    private final static Logger Log = LoggerFactory.getLogger(RegistrationServlet.class);
    private static final long serialVersionUID = -7287396217733304212L;
    @Reference
    MessageGatewayService messageGatewayService;

    @Reference
    EmailService emailService;

    @Override
    protected void doPost(SlingHttpServletRequest request,
                          SlingHttpServletResponse response) throws ServletException, IOException {

        try {

            ResourceResolver resourceResolver = request.getResourceResolver();
            Resource resource = resourceResolver.getResource("/database/signup_database/users");
            Log.info("Resource is at path {}", resource.getPath());
            response.setContentType("text/html");
            PrintWriter printWriter = response.getWriter();

            String regUserName = request.getParameter("username");
            String regPassword = request.getParameter("password");
            String regRepass = request.getParameter("repassword");
            String regEmail = request.getParameter("email");
            String regMobileNumber = request.getParameter("mobileno");

            ////////// Create New Node
            Node node = resource.adaptTo(Node.class);
            Node childnodes = node.addNode(regEmail, "nt:unstructured");
            childnodes.setProperty("Username", regUserName);
            childnodes.setProperty("Password", regPassword);
            childnodes.setProperty("ConfirmPassword", regRepass);
            childnodes.setProperty("Email", regEmail);
            childnodes.setProperty("ContactNumber", regMobileNumber);
            resourceResolver.commit();

            response.setContentType("text/html");
            response.getWriter().write("New registration created successfully done !.......Can Try to login");

            ///....Set the time for the email to be sent
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.SECOND, 10);
            Date time = calendar.getTime();

            /////.....Sending Email
            emailService.getEmail(regEmail,
                    new String[]{Constants.TO_EMAIL},
                    Constants.REGISTRATION_STATUS,
                    "<p style=\"border: 2px solid Violet;\"> <b>Welcome to Murali Smart Mobile Store &#x1F91D; <br/></b></p><img src=\"https://img.91mobiles.com/uploadpanel/ads/090123_iQOO11_5g_970x90.gif\" alt=\"Flipkart\"><br/><br/><body style=\"border: 2px solid black;\"> <p>Dear Customer,</p><br/> Hi," +
                            "                                <p>" + regUserName + ", You have registered successfully done. In this website have a lot of mobiles and laptops you can choose anything what you want.Here, have a convienentable discounts, good sales and services.<br/>" +
                            "                                <p>Regards,</p> <br/>+ <p><b><i>MURALI SMART STORE</i></b></p><br/><img src=\"https://m.media-amazon.com/images/S/aplus-media-library-service-media/91de491f-48db-4d3a-97e0-32ad185d0e15.__CR0,0,1464,600_PT0_SX1464_V1___.jpg\" alt=\"Flipkart\"><br/>" +
                            "                                <img src=\"https://m.media-amazon.com/images/S/aplus-media-library-service-media/24f678ee-bcc1-4387-9054-9a6dab2036e1.__CR0,0,1464,600_PT0_SX1464_V1___.jpg\" alt=\"Flipkart\"><br/>" +
                            "                                <img src=\"https://m.media-amazon.com/images/S/aplus-media-library-service-media/770660c2-b0ae-4137-a632-a81b2b2de5aa.__CR0,0,1464,600_PT0_SX1464_V1___.jpg\" alt=\"Flipkart\"><br/>" +
                            "                                <h4><a href=\"https://www.flipkart.com/mobile-phones-store\">Click here..</a></h4><br/>" +
                            "                                <p  style=\"border: 2px solid red;\" >Developer Name  : DHARMAVARAM MURALI,<br/>" +
                            "                                 Developer Number &#128222; : +91 9100459554 </p> <br/></body>");


        } catch (LockException e) {
            throw new RuntimeException(e);
        } catch (ItemExistsException e) {
            throw new RuntimeException(e);
        } catch (ConstraintViolationException e) {
            throw new RuntimeException(e);
        } catch (ValueFormatException e) {
            throw new RuntimeException(e);
        } catch (PathNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchNodeTypeException e) {
            throw new RuntimeException(e);
        } catch (VersionException e) {
            throw new RuntimeException(e);
        } catch (RepositoryException e) {
            throw new RuntimeException(e);
        }


    }

}






