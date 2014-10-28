package com.imagine.world.api;

import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by tuanlhd on 10/28/14.
 */
public class Initialization implements ServletContextListener {
    static Logger LOGGER = Logger.getLogger(Initialization.class.getName());

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        LOGGER.info("========= SYSTEM DOWN =========");
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LOGGER.info("========= SYSTEM START =========");
    }
}
