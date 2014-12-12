package com.imagine.world.crawler.models;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by tuanlhd on 12/12/14.
 */
public class Configuration {
    private static final Properties pros = new Properties();
    static {
        try {
            pros.load(new FileInputStream(ClassLoader.getSystemResource("").getFile()+ "crawler.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ThreadExecutor properties
     */
    public static int corePoolSize = 4;
    public static int maxPoolSize = Integer.parseInt(pros.getProperty("thread.max.pool.size"));
    public static long keepAliveTime = 2;//minutes

    /**
     * email Properties
     */
    public static final String SECRET_MAIL_2_BLOGGER = pros.getProperty("email.secret.email2blogger");
    public static final String SMTP_HOST = pros.getProperty("email.smtp.host");
    public static final int SMTP_PORT = Integer.parseInt(pros.getProperty("email.smtp.port"));
    public static final String SMTP_USERNAME=pros.getProperty("email.smtp.username");
    public static final String SMTP_PASSWORD=pros.getProperty("email.smtp.password");

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
