package com.sutrix.demo.core.workflow.particpant;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.HistoryItem;
import com.adobe.granite.workflow.exec.ParticipantStepChooser;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.Workflow;
import com.adobe.granite.workflow.metadata.MetaDataMap;
import com.day.cq.mailer.MessageGateway;
import com.day.cq.mailer.MessageGatewayService;
import com.sutrix.demo.core.config.WorkFlowConfiguration;
import com.sutrix.demo.core.constants.Constants;
import com.sutrix.demo.core.services.EmailService;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author Dharmavaram Murali
 */
@Component(service = ParticipantStepChooser.class, property =
        {"chooser.label=" + Constants.WORKFLOW_FIRST_APPROVER})
public class DynamicParticipantStep implements ParticipantStepChooser {

    @Reference
    EmailService emailService;

    @Reference
    WorkFlowConfiguration workFlowConfiguration;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public String getParticipant(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap metaDataMap)
            throws WorkflowException {

        log.info("----------< [{}] >----------", this.getClass().getName());

        String participant = workFlowConfiguration.getFirstApprover();

        Workflow workflow = workItem.getWorkflow();

        // Getting the workflow history
        List<HistoryItem> workflowHistory = workflowSession.getHistory(workflow);

        if (!workflowHistory.isEmpty()) {
            // Setting the administrators group to the participant
            participant = workFlowConfiguration.getFirstApprover();
        } else {
            participant = workFlowConfiguration.getFirstApprover();
        }

        emailService.getEmail(Constants.TO_EMAIL,
                new String[]{Constants.CC_EMAIL},
                " Requesting from requester",
                "Hi [" + participant + "], Please Check your Login There Waiting for Approval from requester &#x1F4C2;");

        log.info("----------< Participant: {} >----------", participant);
        return participant;
    }
}

