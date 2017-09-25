package com.springcore.week1.lesson;

import java.util.Collection;

/**
 * @author Siarhei Shauchenka at 25.09.17
 */
public class CombinedEventLogger implements EventLogger {

    private Collection<EventLogger> loggers;

    public CombinedEventLogger(Collection<EventLogger> loggers) {
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) {
        loggers.forEach(logger -> logger.logEvent(event));
    }
}
