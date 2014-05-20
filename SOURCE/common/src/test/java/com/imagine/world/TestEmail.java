package com.imagine.world;

import junit.framework.TestCase;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 * Created by letuan on 5/20/14.
 */
public class TestEmail extends TestCase {
    public void testSendMailHtml() throws EmailException {
        String host = "smtp.gmail.com";
        int port = 465;
        String username = "dang.capchemgio@gmail.com";
        String password = "soicodon!@#";
        boolean useTls = true;
        boolean useSsl = true;
        String fromAlias = "CLOUD TV";
        String fromEmail = "dang.capchemgio@gmail.com";

        String body = "asjhajkdh askdjhaskjdhakjshd";

        HtmlEmail mail = new HtmlEmail();

        mail.setHostName(host);
        mail.setDebug(false);
        mail.setAuthentication(username, password);
        mail.setTLS(useTls);
        mail.setSSL(useSsl);
        mail.setSmtpPort(port);
        mail.setSslSmtpPort(String.valueOf(port));
        mail.setCharset("utf-8");

        mail.setFrom(fromEmail,fromAlias);

        mail.addTo("tuanlhdnl@gmail.com", "");
        mail.setSubject(" effectiveSubject ");
        mail.setTextMsg(body);

        mail.send();

    }
}
