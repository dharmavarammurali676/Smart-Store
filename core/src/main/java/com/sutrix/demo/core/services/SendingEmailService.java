package com.sutrix.demo.core.services;

import com.sutrix.demo.core.services.impl.SendingEmailServiceImpl;

public interface SendingEmailService {


    ////// Sending Email to Registration
    SendingEmailServiceImpl getSignUp_Email();
}
