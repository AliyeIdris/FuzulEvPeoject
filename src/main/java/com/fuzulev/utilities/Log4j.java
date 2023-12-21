package com.fuzulev.utilities;

import org.apache.log4j.Logger;

/**
 * @author : user
 * @created : 21.12.2023,00:41
 * @Email :aliyeidiris@gmail.com
 **/
public class Log4j {
    private static Logger logger=Logger.getLogger(Log4j.class.getName());
    public static void info(String message){
        logger.info(message);
    }
    public static void debug(String message){
        logger.debug(message);
    }
    public static void error(String message){
        logger.error(message);
    }
    public static void fatal(String message){
        logger.fatal(message);
    }
    public static void warn(String message){
        logger.warn(message);
    }
}
