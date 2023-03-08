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
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author Dharmavaram Murali
 */
@Component(service = WorkflowProcess.class,
        property = {"process.label=" + " Third Process Step "})
public class ProcessStep implements WorkflowProcess {

    @Reference
    EmailService emailService;


    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap metaDataMap)
            throws WorkflowException {

        // Getting payload from Workflow - workItem -> workflowData -> payload
        String payloadType = workItem.getWorkflowData().getPayloadType();

        // Check type of payload; there are two - JCR_PATH and JCR_UUID
        if (StringUtils.equals(payloadType, "JCR_PATH")) {
            log.info("Payload type: {}", payloadType);
            // Get the JCR path from the payload
            String path = workItem.getWorkflowData().getPayload().toString();
            log.info("Payload path: {}", path);
        }

        // Get workflow process arguments
        String[] processArguments = metaDataMap.get("PROCESS_ARGS", "Default").split(",");
        log.info("Process args: {}", Arrays.toString(processArguments));

        emailService.getEmail(Constants.TO_EMAIL,
                new String[]{Constants.CC_EMAIL},
                Constants.WORKFLOW_APPROVER_STATUS,
                "Third Step is Successfully approved. Please wait Approval for next step");

    }

}
