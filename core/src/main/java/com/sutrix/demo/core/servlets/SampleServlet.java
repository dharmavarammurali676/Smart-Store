package com.sutrix.demo.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;


@Component(service =
                    {Servlet.class
                             }, property = {
        "sling.servlet.methods=get",
        "sling.servlet.paths=/bin/mydemo/hello"
})
public class SampleServlet extends SlingAllMethodsServlet {

    private static final long serialVersionUid = 1L;

    @Override
    protected void doGet(final SlingHttpServletRequest req,
                         final SlingHttpServletResponse resp) throws ServletException, IOException {

        resp.getWriter().print("Hello Welcome");
    }
    }

