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

@Component(service = Servlet.class, immediate = true,
        property = {
                "sling.servlet.methods=" + HttpConstants.METHOD_POST,
                "sling.servlet.paths=" + Constants.BOOKING_SERVLET_PATH
        })
public class BookingServlet extends SlingAllMethodsServlet {

    private static final long serialVersionUID = -7287396217733304212L;
    private final static Logger Log = LoggerFactory.getLogger(BookingServlet.class);

    @Reference
    EmailService emailService;

    @Override
    protected void doPost(SlingHttpServletRequest request,
                          SlingHttpServletResponse response) throws ServletException, IOException {


        try {
            ResourceResolver resourceResolver = request.getResourceResolver();
            Resource resource = resourceResolver.getResource("/database/orders/bookings");
            Log.info("Resource is at path {}", resource.getPath());
            int random = (int) (Math.random() * 1000000000);

            response.setContentType("text/html;charset-UTF-8");
            PrintWriter out = response.getWriter();

            String firstName = request.getParameter("firstname");
            String lastName = request.getParameter("lastname");
            String Gender = request.getParameter("gender");
            String Email = request.getParameter("email");
            String phoneNumber = request.getParameter("phonenumber");
            String Address = request.getParameter("address");
            String PostalCode = request.getParameter("postalcode");
            String Mobile = request.getParameter("mobiles");
            String Model = request.getParameter("models");
            String Payment = request.getParameter("payment");

            Calendar calendar = Calendar.getInstance();

            Node node = resource.adaptTo(Node.class);

            Resource resource1 = resourceResolver.getResource("/database/orders/bookings/" + Email);

            if (resource1 == null) {
                ////////// Parent Node
                Node parentnode = node.addNode(Email, "nt:unstructured");
                ////////// Child Node
                Node childnode = parentnode.addNode(String.valueOf(random), "nt:unstructured");
                ////////// Properties
                childnode.setProperty("Firstname", firstName);
                childnode.setProperty("Lastname", lastName);
                childnode.setProperty("Gender", Gender);
                childnode.setProperty("Email", Email);
                childnode.setProperty("PhoneNumber", phoneNumber);
                childnode.setProperty("Brand", Mobile);
                childnode.setProperty("Address", Address);
                childnode.setProperty("Postal Code", PostalCode);
                childnode.setProperty("Model", Model);
                childnode.setProperty("Payment Mode", Payment);
                childnode.setProperty("Ordered Date", String.valueOf(calendar.getTime()));
                resourceResolver.commit();
                response.setContentType("text/html");
                response.getWriter().write("Your Order is Placed with " + Email);
            } else {

                    Node parentNode = resource1.adaptTo(Node.class);
                    if (parentNode != null) {
                        ////////// Child Node
                        Node childnode = parentNode.addNode(String.valueOf(random), "nt:unstructured");
                        ////////// Properties
                        childnode.setProperty("Firstname", firstName);
                        childnode.setProperty("Lastname", lastName);
                        childnode.setProperty("Gender", Gender);
                        childnode.setProperty("Email", Email);
                        childnode.setProperty("PhoneNumber", phoneNumber);
                        childnode.setProperty("Brand", Mobile);
                        childnode.setProperty("Address", Address);
                        childnode.setProperty("Postal Code", PostalCode);
                        childnode.setProperty("Model", Model);
                        childnode.setProperty("Payment Mode", Payment);
                        childnode.setProperty("Ordered Date", String.valueOf(calendar.getTime()));
                        resourceResolver.commit();
                        response.setContentType("text/html");
                        response.getWriter().write("Your Order is Placed with " + Email);
                    }
                }
            /////.....Sending Email

            emailService.getEmail(Email,
                    new String[]{Constants.TO_EMAIL},
                    Constants.BOOKING_STATUS,
                    "<b style=\"color:green;\"> Free Delivery &#x1F4F1;" +
                            "<u><img src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTarKwYK-fY0N9PobdTy2fV18oTVa_INiG0TQ&usqp=CAU " +
                            "alt=\"Delivery\"></u><br/></b><b> We've just shipped your order!</b><br/><b>Dear Customer,</b> <br/><p> Congratulations <b>"
                            + firstName + lastName + "</b>, Your SmartPhone booking confirmed. <br/><p> Your Order ID :" + random +
                            " </p><br/>. This is just a quick update to let you know that your order is now in the mail and on it's way to you." +
                            " To track your shipment and view its delivery status, <i> Click the link below</i></p> <br/> " +
                            "<br/> But remember, refreshing the tracking over and over won't make your package move any faster,So in the meantime." +
                            "why not head over to out <b>FAQs</b> for instant photography tips and tricks? That way, as soon as your package arrives, You'll be ready to roll<br/>" +
                            "<br/> <b style=\"color:red;\"> Payment details : &#x1F51C; <br/> <button class=\"button \" " +
                            "style=\"color:blue;\">Track your order &#x27A1;</button> or <p><a href=\"https://www.amazon.in/mobile-phones/b/?ie=UTF8&node=1389401031&ref_=nav_cs_mobiles\">Visit our Store !</a></p>");

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


