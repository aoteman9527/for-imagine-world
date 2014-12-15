package com.imagine.world.crawler.models;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by tuanlhd on 12/12/14.
 */
public class Configuration {
    private static final Properties pros = new Properties();
    static {
        try {
            pros.load(Configuration.class.getClassLoader().getResourceAsStream("crawler.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ThreadExecutor properties
     */
    public int corePoolSize = 4;
    public int maxPoolSize = Integer.parseInt(pros.getProperty("thread.max.pool.size"));
    public long keepAliveTime = 2;//minutes

    /**
     * email Properties
     */
    public final String SECRET_MAIL_2_BLOGGER = pros.getProperty("email.secret.email2blogger");
    public final String SMTP_HOST = pros.getProperty("email.smtp.host");
    public final int SMTP_PORT = Integer.parseInt(pros.getProperty("email.smtp.port"));
    public final String SMTP_USERNAME=pros.getProperty("email.smtp.username");
    public final String SMTP_PASSWORD=pros.getProperty("email.smtp.password");

    /**
     * Blogger api v3
     */
    public final String BLOGGER_API_V3_KEY =  pros.getProperty("blogger.api.v3.key");

    /**
     * Constructor
     */
    private static Configuration configuration;
    private Configuration(){}

    public static Configuration i(){
        if(configuration==null)
            configuration=new Configuration();
        return configuration;
    }

    public static int getShutDownTime(){
        return Integer.parseInt(pros.getProperty("thread.shutdown.time"));
    }
}
