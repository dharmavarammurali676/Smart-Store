package com.sutrix.demo.core.servlets.emailservlet;

import com.day.cq.mailer.MessageGateway;
import com.day.cq.mailer.MessageGatewayService;
import com.sutrix.demo.core.constants.Constants;
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
                "sling.servlet.methods="+ HttpConstants.METHOD_POST,
                "sling.servlet.paths="+ Constants.CHAT_WITH_DEVELOPER_PATH
        })
public class ChatServlet extends SlingAllMethodsServlet {

    private static final long serialVersionUID = -7287396217733304212L;

    @Reference
    MessageGatewayService messageGatewayService;

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        try {

            response.setContentType("text/html;charset-UTF-8");
            PrintWriter out = response.getWriter();

            String Message = request.getParameter("message");

//            emailService.getEmail(Constants.TO_EMAIL,
//                    new String[]{},
//                    "Chat",
//                    Message);


           if (messageGatewayService != null) {
               MessageGateway<HtmlEmail> gateway = messageGatewayService.getGateway(HtmlEmail.class);

               HtmlEmail htmlEmail = new HtmlEmail();
               htmlEmail.addTo(Constants.TO_EMAIL);
               htmlEmail.setSubject("Chat");
               htmlEmail.setContent(Message, "text/html");
               gateway.send(htmlEmail);
           }
              response.getWriter().write("Your Chat is Sent ");
        } catch (EmailException e) {
        }
    }
}