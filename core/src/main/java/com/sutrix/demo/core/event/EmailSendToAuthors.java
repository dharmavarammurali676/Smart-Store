package com.sutrix.demo.core.event;

import com.day.cq.mailer.MessageGateway;
import com.day.cq.mailer.MessageGatewayService;
import com.day.cq.replication.ReplicationAction;
import com.day.cq.replication.ReplicationActionType;
import com.sutrix.demo.core.constants.Constants;
import org.apache.commons.mail.HtmlEmail;
import org.apache.sling.api.servlets.HttpConstants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Component(service = EventHandler.class,
        immediate = true,
        property = {
                EventConstants.EVENT_TOPIC + "=" + ReplicationAction.EVENT_TOPIC,
                "sling.servlet.methods="+HttpConstants.METHOD_GET,
                "sling.servlet.paths="+Constants.EMAIL_SEND_TO_AUTHOR_P_U
        })
public class EmailSendToAuthors implements EventHandler {

    private static final long serialVersionUID = -7287396217733304212L;

    @Reference
    MessageGatewayService messageGatewayService;

    private static final Logger LOG = LoggerFactory.getLogger(ReplicationEventListener.class);

    public void handleEvent(final Event event) {
        try {
            LOG.info("\n Event Type : {} ", event.getTopic());
            if (ReplicationAction.fromEvent(event).getType().equals(ReplicationActionType.ACTIVATE)) {
                LOG.info("\n Pages/Assets Activated :  {}", ReplicationAction.fromEvent(event).getPath());
            if (messageGatewayService != null) {
                MessageGateway<HtmlEmail> gateway = messageGatewayService.getGateway(HtmlEmail.class);

                HtmlEmail htmlEmail = new HtmlEmail();
                htmlEmail.addTo("dharmavarammurali2103@gmail.com");
                htmlEmail.addCc("dharmavarammurali13@gmail.com");
                htmlEmail.setAuthentication("admin","admin");
                htmlEmail.setSubject("Information");
                htmlEmail.setContent(ReplicationAction.fromEvent(event).getPath()+".<br/>   <br/>This path published/Activated by author.Email will be sent to the last modified user.", "text/html");
                gateway.send(htmlEmail);
            }
        }
            if (ReplicationAction.fromEvent(event).getType().equals(ReplicationActionType.DEACTIVATE)) {
                LOG.info("\n Pages/Assets Deactivated :  {}", ReplicationAction.fromEvent(event).getPath());
                if (messageGatewayService != null) {
                    MessageGateway<HtmlEmail> gateway = messageGatewayService.getGateway(HtmlEmail.class);

                    HtmlEmail htmlEmail = new HtmlEmail();
                    htmlEmail.addTo("dharmavarammurali2103@gmail.com");
                    htmlEmail.addCc("dharmavarammurali13@gmail.com");
                    htmlEmail.setAuthentication("admin","admin");
                    htmlEmail.setSubject("Information");
                    htmlEmail.setContent(ReplicationAction.fromEvent(event).getPath()+".<br/>   <br/>This path Unpublished/Deactivated by author.Email will be sent to the last modified user.", "text/html");
                    gateway.send(htmlEmail);
                }
            }

        } catch (Exception e) {
            LOG.error("\n Error while Activating/Deactivating - {} So Not sending a mail to author ", e.getMessage());
        }
    }
}
