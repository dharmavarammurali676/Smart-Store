package com.sutrix.demo.core.config.impl;

import com.sutrix.demo.core.config.CQMailConfig;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = CQMailConfig.class,
        immediate = true)

@Designate(ocd = CQMailServiceConfigurationImpl.CQMailServiceConfiguration.class)
    public class CQMailServiceConfigurationImpl implements CQMailConfig  {

        private static final Logger LOGGER = LoggerFactory.getLogger(CQMailServiceConfigurationImpl.class);

    private String SMPTServerHostName;

    private String SMPTServerPort;

    private String SMPTUser;

    private String SMPTPassword;

    private String FromAddress;

    private String ToAddress;

    private String[] CcAddress;

    private boolean SMPTUseSSL;


        @Activate
        @Modified
        protected void activate(final CQMailServiceConfiguration configuration) {
            SMPTServerHostName = configuration.SMPTServerHostName();
            SMPTServerPort = configuration.SMPTServerPort();
            SMPTUser = configuration.SMPTUser();
            SMPTPassword = configuration.SMPTPassword();
            FromAddress = configuration.FromAddress();
            ToAddress = configuration.ToAddress();
            CcAddress = configuration.CcAddress();
            SMPTUseSSL = configuration.SMPTUseSSL();
        }


    @ObjectClassDefinition(name = "Day CQ Mail Service Configuration", description = "Created by Murali for sending emails to authors")
    public @interface CQMailServiceConfiguration {

        @AttributeDefinition(name = "SMPT server host name",
                description = "The mailer uses this SMTP server to send messages (smtp.host)",
                type = AttributeType.STRING)
        public String SMPTServerHostName();

        @AttributeDefinition(name = "SMPT server port",
                description = "Port number to use to connect to the SMTP server (smtp.port)",
                type = AttributeType.STRING)
        public String SMPTServerPort();

        @AttributeDefinition(name = "SMPT User",
                description = "The user for authentication through SMTP (smtp.user)",
                type = AttributeType.STRING)
        public String SMPTUser();

        @AttributeDefinition(name = "SMPT Password",
                description = "This password generated in your gmail account",
                type = AttributeType.STRING)
        public String SMPTPassword();

        @AttributeDefinition(name = "From Address",
                description = "enter from email address",
                type = AttributeType.STRING)
        public String FromAddress();

        @AttributeDefinition(name = "To Address",
                description = "enter to email address",
                type = AttributeType.STRING)
        public String ToAddress();

        @AttributeDefinition(name = "Cc Address",
                description = "Multiple email for multiple authors",
                type = AttributeType.STRING)
        public String[] CcAddress();

        @AttributeDefinition(name = "SMPT Use SSL",
                description = "please enter smpt mail",
                type = AttributeType.BOOLEAN)
        public boolean SMPTUseSSL();
    }


    @Override
    public String getSMPTServerHostName() {
        return SMPTServerHostName;
    }

    @Override
    public String getSMPTServerPort() {
        return SMPTServerPort;
    }

    @Override
    public String getSMPTUser() {
        return SMPTUser;
    }

    @Override
    public String getSMPTPassword() {
        return SMPTPassword;
    }

    @Override
    public String getFromAddress() {
        return FromAddress;
    }

    @Override
    public String getToAddress() {
        return ToAddress;
    }

    @Override
    public String[] getCcAddress() {
        return CcAddress;
    }

    @Override
    public boolean getSMPTUseSSL() {
        return SMPTUseSSL;
    }
}


