package com.sutrix.demo.core.workflow;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;
import com.day.cq.mailer.MessageGateway;
import com.day.cq.mailer.MessageGatewayService;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Dharmavaram Murali
 */
@Component(property = {
        (Constants.SERVICE_DESCRIPTION + "= Another Sample Configuration"),
        ("process.label= Email Work Flow Process")
})
public class MyWorkFlowProcess  implements WorkflowProcess {

    protected final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Reference
    private MessageGatewayService messageGatewayService;
    @Override
    public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap metaDataMap) throws WorkflowException {

        try {
            LOG.info("Executed Started");
            MessageGateway<Email> messageGateway;
            Email email = new SimpleEmail();

            String toUsers = "muralisutrixsolutions@gmail.com";
            String ccUsers = "dharmavarammurali13@gmail.com";


            email.addTo(toUsers);
            email.addCc(ccUsers);
            email.setSubject("This Page is Activated  - Custom Process Step ");
            email.setFrom("dharmavarammurali2103@gmail.com");
            email.setMsg("This message is to inform Page/Asset is Activated");

            messageGateway = messageGatewayService.getGateway(Email.class);
            messageGateway.send((Email) email);
        }
        catch (Exception exception){
            LOG.error("Some Error {}",exception.getMessage());

        }

    }
}
