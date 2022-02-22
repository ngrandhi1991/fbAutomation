package com.fbmachine.qa.util;

import org.apache.log4j.Logger;

public class Log {
    public static Logger logger = Logger.getLogger(Log.class.getName());

    public static void info(String msg){
        logger.info(msg);
    }
}
