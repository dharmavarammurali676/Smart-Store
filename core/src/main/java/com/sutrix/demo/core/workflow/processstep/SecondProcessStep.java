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
 * @author Dharmavaram Murali
 */
@Component(service = WorkflowProcess.class,
        property = {"process.label=" + "Second Process Step"})
public class SecondProcessStep implements WorkflowProcess {

    @Reference
    EmailService emailService;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap metaDataMap)
            throws WorkflowException {

        log.info("Executing second workflow process step");

        // Getting the metadata map
        MetaDataMap map = workItem.getWorkflow().getWorkflowData().getMetaDataMap();

        // Getting the data stored
        String data = (String) map.get("Data");

        log.info("Data from the first step: {}", data);

        emailService.getEmail(Constants.TO_EMAIL,
                new String[]{Constants.CC_EMAIL},
                "Approver Status",
                "<b>Second Step is Successfully approved</b> &#x1F44E;. Please wait Approval for next step");
    }

}
