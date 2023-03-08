package com.sutrix.demo.core.osgiforemail;

public interface CQMailConfig {

    String getSMPTServerHostName();

    String getSMPTServerPort();

    String getSMPTUser();

    String getSMPTPassword();

    String getFromAddress();

    String getToAddress();

    String[] getCcAddress();

    boolean getSMPTUseSSL();
}
