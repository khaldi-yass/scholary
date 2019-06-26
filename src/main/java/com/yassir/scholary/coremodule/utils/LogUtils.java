package com.yassir.scholary.coremodule.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public final class LogUtils {

    private static Map<Class, Logger> classLoggers = new HashMap<>();

    private LogUtils() {
    }

    public static void debug(Class clazz, String message) {
        Logger logger = getLogger(clazz);
        if (logger.isDebugEnabled()) {
            logger.debug(message);
        }
    }

    public static void info(Class clazz, String message) {
        Logger logger = getLogger(clazz);
        if (logger.isInfoEnabled()) {
            logger.info(message);
        }
    }

    public static void warn(Class clazz, String message) {
        Logger logger = getLogger(clazz);
        if (logger.isWarnEnabled()) {
            logger.warn(message);
        }
    }

    public static void error(Class clazz, String message) {
        Logger logger = getLogger(clazz);
        if (logger.isErrorEnabled()) {
            logger.error(message);
        }
    }

    public static void trace(Class clazz, String message) {
        Logger logger = getLogger(clazz);
        if (logger.isTraceEnabled()) {
            logger.trace(message);
        }
    }

    private static Logger getLogger(Class clazz) {
        return classLoggers.computeIfAbsent(clazz, c -> {
            Logger log = LoggerFactory.getLogger(clazz);
            classLoggers.put(clazz, log);
            return log;
        });
    }

}
