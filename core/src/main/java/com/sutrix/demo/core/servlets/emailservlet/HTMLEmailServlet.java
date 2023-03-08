package com.sutrix.demo.core.servlets.emailservlet;

import com.day.cq.mailer.MessageGateway;
import com.day.cq.mailer.MessageGatewayService;
import com.sutrix.demo.core.constants.Constants;
import com.sutrix.demo.core.services.EmailService;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

@Component(service = Servlet.class, immediate = true,
        property = {
                "sling.servlet.methods=" + HttpConstants.METHOD_POST,
                "sling.servlet.paths=" + Constants.EMAIL_SENDING_PATH
        })
public class HTMLEmailServlet extends SlingAllMethodsServlet {

    private static final long serialVersionUID = -7287396217733304212L;

    @Reference
    EmailService emailService;

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset-UTF-8");
        PrintWriter out = response.getWriter();

        String Name = request.getParameter("name");
        String Subject = request.getParameter("subject");
        String Email = request.getParameter("email");
        String Message = request.getParameter("message");

        emailService.getEmail(Email,
                new String[]{Constants.TO_EMAIL},
                "Welcome To Sutrix Solutions",
                Message);

        response.getWriter().write("Email Sent Successfully done to " + Name);
    }
}
