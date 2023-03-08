package com.sutrix.demo.core.servlets.order;

import com.sutrix.demo.core.constants.Constants;
import com.sutrix.demo.core.services.EmailService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author : Dharmavaram Murali,
 * @Date : 07-03-2023,
 * @Time : 18:32
 */
@Component(service = Servlet.class, immediate = true,
        property = {
                "sling.servlet.methods=" + HttpConstants.METHOD_POST,
                "sling.servlet.paths=" + Constants.SHOW_ORDER_PATH,
                "sling.servlet.selectors=js"
        })
public class ShowOrdersServlet extends SlingAllMethodsServlet {

    private static final long serialVersionUID = -7287394343636304212L;

    @Reference
    EmailService emailService;

    @Override
    protected void doPost(SlingHttpServletRequest request,
                          SlingHttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        String Email = request.getParameter("email");
        ResourceResolver resourceResolver = request.getResourceResolver();
        Resource resource = resourceResolver.getResource("/database/orders/bookings");
        if (resource != null) {
            Resource childResource = resource.getChild(Email);
            if (childResource != null) {
                Node child = childResource.adaptTo(Node.class);
                emailService.getEmail(Constants.TO_EMAIL,
                        new String[]{Constants.CC_EMAIL},
                        "ID",
                        "Your Order ID : " + child);
                response.getWriter().write("Your Orders ID's sent your registered Email");
            } else {
                response.getWriter().write("Order is does not exist");
            }
        }
    }
}


