package com.sutrix.demo.core.services.impl;

import com.sutrix.demo.core.constants.Constants;
import com.sutrix.demo.core.services.EmailService;
import com.sutrix.demo.core.services.SendingEmailService;
import com.sutrix.demo.core.servlets.login.RegistrationServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Auto-Generated
 * Created By : dharmavaram.m
 * Date : 06-03-2023
 * Time : 15:50
 */

@Component(service = SendingEmailServiceImpl.class,immediate = true)
public class SendingEmailServiceImpl implements SendingEmailService {

    @Reference
    EmailService emailService;

    @Reference
    RegistrationServlet registrationServlet;

    private static final Logger LOGGER = LoggerFactory.getLogger(SendingEmailServiceImpl.class);


    ////// Sending Email to Registration
    @Override
    public SendingEmailServiceImpl getSignUp_Email(){




   emailService.getEmail(Constants.TO_EMAIL,new String[]{Constants.CC_EMAIL},
              Constants.REGISTRATION_STATUS,"\"<p style=\\\"border: 2px solid Violet;\\\"> <b>Welcome to Murali Smart Mobile Store &#x1F91D; <br/></b></p><img src=\\\"https://img.91mobiles.com/uploadpanel/ads/090123_iQOO11_5g_970x90.gif\\\" alt=\\\"Flipkart\\\"><br/><br/><body style=\\\"border: 2px solid black;\\\"> <p>Dear Customer,</p><br/> Hi,\" +\n" +
                                                     "\"<p>\" + regUserName + \", You have registered successfully done. In this website have a lot of mobiles and laptops you can choose anything what you want.Here, have a convienentable discounts, good sales and services.<br/>\" +\n" +
                                                     "\"<p>Regards,</p> <br/>\" + \"<p><b><i>MURALI SMART STORE</i></b></p><br/><img src=\\\"https://m.media-amazon.com/images/S/aplus-media-library-service-media/91de491f-48db-4d3a-97e0-32ad185d0e15.__CR0,0,1464,600_PT0_SX1464_V1___.jpg\\\" alt=\\\"Flipkart\\\"><br/>\" +\n" +
                                                     "\"<img src=\\\"https://m.media-amazon.com/images/S/aplus-media-library-service-media/24f678ee-bcc1-4387-9054-9a6dab2036e1.__CR0,0,1464,600_PT0_SX1464_V1___.jpg\\\" alt=\\\"Flipkart\\\"><br/>\" +\n" +
                                                     "\"<img src=\\\"https://m.media-amazon.com/images/S/aplus-media-library-service-media/770660c2-b0ae-4137-a632-a81b2b2de5aa.__CR0,0,1464,600_PT0_SX1464_V1___.jpg\\\" alt=\\\"Flipkart\\\"><br/>\" +\n" +
                                                     "\"<h4><a href=\\\"https://www.flipkart.com/mobile-phones-store\\\">Click here..</a></h4><br/>\" +\n" +
                                                     "\"<p  style=\\\"border: 2px solid red;\\\" >Developer Name  : DHARMAVARAM MURALI,<br/>\" +\n" +
                                                     "\" Developer Number &#128222; : +91 9100459554 </p> <br/></body>\"");
        return null;
    }

//    @Override
//    public SendingEmailServiceImpl getBooking_Email(){
//        emailService.getEmail(Constants.TO_EMAIL,new String[]{Constants.CC_EMAIL},
//                               Constants.BOOKING_STATUS,"\"<b style=\\\"color:green;\\\"> Free Delivery &#x1F4F1; <u><img src=\\\"https://th.bing.com/th/id/OIP.DCCxDtEiOlDNdWn2G3I_6AAAAA?pid=ImgDet&rs=1\\\" alt=\\\"Delivery\\\"></u><br/></b><b> We've just shipped your order!</b><br/><b>Dear Customer,</b> <br/><p> Congratulations <b>\" + firstName + lastName + \"</b>, Your SmartPhone booking confirmed. <br/><p> Your Order ID :\" + random + \" </p><br/>. This is just a quick update to let you know that your order is now in the mail and on it's way to you. To track your shipment and view its delivery status, <i> Click the link below</i></p> <br/> \" +\n" +
//                        "                                \"<br/> But remember, refreshing the tracking over and over won't make your package move any faster,So in the meantime.why not head over to out <b>FAQs</b> for instant photography tips and tricks? That way, as soon as your package arrives, You'll be ready to roll<br/>  <br/> <b style=\\\"color:red;\\\"> Payment details : &#x1F51C; <br/> <button class=\\\"button \\\" style=\\\"color:blue;\\\">Track your order &#x27A1;</button> or <p><a href=\\\"https://www.amazon.in/mobile-phones/b/?ie=UTF8&node=1389401031&ref_=nav_cs_mobiles\\\">Visit our Store !</a></p>\",")
//    }
}
