package com.sutrix.demo.core.services.impl;

import com.sutrix.demo.core.services.SmartStoreService;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author : Dharmavaram Murali,
 * @Date : 07-03-2023,
 * @Time : 15:57
 */
@Component(service = SmartStoreService.class,immediate = true)
public class SmartStoreServiceImpl implements SmartStoreService {

    private static final Logger LOG = LoggerFactory.getLogger(SmartStoreServiceImpl.class);

    @Override
    public SmartStoreServiceImpl OTPGenerated(){

        int otp = (int) (Math.random() * 1000000);

        return null;
    }


}
