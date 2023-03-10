package com.sutrix.demo.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.PersistenceException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.servlet.Servlet;

@Component(service = Servlet.class,
              property =
                      {
                              Constants.SERVICE_DESCRIPTION + "=Simple Demo Servlet",
                              "sling.servlet.methods=" + HttpConstants.METHOD_POST,
                              "sling.servlet.paths=" + com.sutrix.demo.core.constants.Constants.CREATE_NODE
                      })
public class CreateNodeServlet extends SlingAllMethodsServlet {
    private static final long serialVersionUID = -159625176093879129L;

    private static final Logger log = LoggerFactory.getLogger(CreateNodeServlet.class);

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) {

        try {
            ResourceResolver resourceResolver = request.getResourceResolver();
            Resource resource = resourceResolver.getResource("page path");
            log.info("Resource is at path {}", resource.getPath());
            Node node = resource.adaptTo(Node.class);
            Node newNode = node.addNode("demoNode", "nt:unstructured");
            newNode.setProperty("name", "Demo Node");
            resourceResolver.commit();
        } catch (RepositoryException e) {
            log.error(e.getMessage(), e);
            e.printStackTrace();
        } catch (PersistenceException e) {
            log.error(e.getMessage(), e);
            e.printStackTrace();
        }
    }

}