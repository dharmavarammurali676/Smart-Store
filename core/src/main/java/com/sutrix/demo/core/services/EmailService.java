package com.sutrix.demo.core.services;

public interface EmailService {

    EmailService getEmail(String addTo, String[] addCc, String setSubject, String setContent);
}
