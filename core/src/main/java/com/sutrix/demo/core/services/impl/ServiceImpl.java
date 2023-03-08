package com.sutrix.demo.core.services.impl;

import com.day.cq.mailer.MessageGateway;
import com.day.cq.mailer.MessageGatewayService;
import com.sutrix.demo.core.services.Service;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = Service.class, immediate = true)
public class ServiceImpl implements Service {

    private static final Logger LOG = LoggerFactory.getLogger(ServiceImpl.class);

    @Reference
    MessageGatewayService messageGatewayService;

    @Override
    public Service getEmail() {

        try {
            if (messageGatewayService != null) {
                MessageGateway<HtmlEmail> gateway = messageGatewayService.getGateway(HtmlEmail.class);
                HtmlEmail htmlEmail = new HtmlEmail();
                htmlEmail.addTo("muralisutrixsolutions@gmail.com");
                htmlEmail.addCc("dharmavarammurali13@gmail.com");
                htmlEmail.setSubject("");
                htmlEmail.setContent("","text/html");
                gateway.send(htmlEmail);

            }
        } catch (EmailException e) {

        }
        return null;
    }
}
