package com.sutrix.demo.core.workflow.processstep;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;
import com.day.cq.mailer.MessageGateway;
import com.day.cq.mailer.MessageGatewayService;
import com.sutrix.demo.core.constants.Constants;
import com.sutrix.demo.core.services.EmailService;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Auto-Generated
 * Created By : dharmavaram.m
 * Date : 06-03-2023
 * Time : 12:47
 */
@Component(service = WorkflowProcess.class,
        property =
                {"process.label=" + "Approved Process Step"})
public class ApprovedProcessStep implements WorkflowProcess {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Reference
    EmailService emailService;

    @Override
    public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap metaDataMap)
            throws WorkflowException {

        log.info("Executing approved workflow process step");

        // Getting the metadata map
        MetaDataMap map = workItem.getWorkflow().getWorkflowData().getMetaDataMap();

        // Putting some values in the map
        map.put("Data", "Data from the first step");

        emailService.getEmail(Constants.TO_EMAIL,
                new String[]{Constants.CC_EMAIL},
                Constants.WORKFLOW_STATUS,
                "<b>Congratulation, Your Request is approved by Administrator</b> &#x1F44D;." +
                        " Please wait Approval for next step");

    }

}