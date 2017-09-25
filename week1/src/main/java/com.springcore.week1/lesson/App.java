package com.springcore.week1.lesson;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.security.auth.login.Configuration;
import java.util.Map;

/**
 * @author Siarhei Shauchenka at 25.09.17
 */
public class App {

    private final Client client;
    private final Map<EventType, EventLogger> eventLoggerMap;
    private final EventLogger defaultLogger;

    public App(Client client, EventLogger defaultLogger, Map<EventType, EventLogger> eventLoggerMap) {
        this.client = client;
        this.eventLoggerMap = eventLoggerMap;
        this.defaultLogger = defaultLogger;
    }

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext("spring.xml");
        appContext.registerShutdownHook();
        App app = appContext.getBean("app", App.class);
        Event event1 = appContext.getBean("event", Event.class);
        Thread.sleep(1000);
        Event event2 = appContext.getBean("event", Event.class);
        Event event3 = appContext.getBean("event", Event.class);
        event1.setMsg("Hello!");
        event2.setMsg("Bye!");
   //     event3.setMsg("Third!");

        app.logEvent(EventType.INFO, event1);
        app.logEvent(EventType.ERROR, event2);
      //  app.logEvent(event3);
    }

    public void logEvent(EventType eventType, Event msg){
        EventLogger eventLogger = eventLoggerMap.get(eventType);
        if (eventLogger == null){
            eventLogger = defaultLogger;
        }
        eventLogger.logEvent(msg);
    }
}
