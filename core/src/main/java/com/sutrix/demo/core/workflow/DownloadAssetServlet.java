package com.sutrix.demo.core.workflow;

import com.day.cq.workflow.WorkflowException;
import com.day.cq.workflow.WorkflowService;
import com.day.cq.workflow.WorkflowSession;
import com.day.cq.workflow.exec.WorkflowData;
import com.day.cq.workflow.model.WorkflowModel;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Dharmavaram Murali
 */
@Component(service = Servlet.class,
        property =
                {
                        Constants.SERVICE_DESCRIPTION + "= Download Asset Servlet",
                        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
                        "sling.servlet.paths=" + "/bin/invoke/workflow"
                })
public class DownloadAssetServlet extends SlingAllMethodsServlet {

    /** Default log. */
    protected final transient Logger log = LoggerFactory.getLogger(this.getClass());

    private static final long serialVersionUID = 1L;

    @Reference
    private transient WorkflowService workflowService;

    @Reference
    private transient ResourceResolverFactory resolverFactory;

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {

        Session session = null;


        Map<String, Object> param = new HashMap<>();
        param.put(ResourceResolverFactory.SUBSERVICE, "writeSystemUser");
        ResourceResolver resolver = null;


        WorkflowSession wfSession = workflowService.getWorkflowSession(session);
        WorkflowModel wfModel = null;
        try {
            wfModel = wfSession.getModel("/var/workflow/models/dam/dam_download_asset");
        } catch (WorkflowException e) {
            throw new RuntimeException(e);
        }
        WorkflowData wfData = wfSession.newWorkflowData("JCR_PATH", "/content/dam/we-retail/en/features/cart.png");
        try {
            wfSession.startWorkflow(wfModel, wfData);
        } catch (WorkflowException e) {
            throw new RuntimeException(e);
        }

        try {
            session.save();
        } catch (RepositoryException e) {
            throw new RuntimeException(e);
        }
        session.logout();



    }

}