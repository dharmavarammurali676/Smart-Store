package com.sutrix.demo.core.services.impl;

import com.day.cq.mailer.MessageGateway;
import com.day.cq.mailer.MessageGatewayService;
import com.sutrix.demo.core.services.EmailService;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = EmailService.class, immediate = true)
public class EmailServiceImpl implements EmailService {

    private static final Logger LOG = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Reference
    MessageGatewayService messageGatewayService;

    @Override
    public EmailService getEmail(String addTo, String[]addCc, String setSubject, String setContent) {

        try {
            if (messageGatewayService != null) {
                MessageGateway<HtmlEmail> gateway = messageGatewayService.getGateway(HtmlEmail.class);
                HtmlEmail htmlEmail = new HtmlEmail();
                htmlEmail.addTo(addTo);
                htmlEmail.addCc(addCc);
                htmlEmail.setSubject(setSubject);
                htmlEmail.setContent(setContent,"text/html");
                gateway.send(htmlEmail);
            }
        } catch (EmailException e) {

        }
        return null;
    }
}
