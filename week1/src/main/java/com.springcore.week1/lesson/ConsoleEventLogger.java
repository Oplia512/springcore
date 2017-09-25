package com.springcore.week1.lesson;

/**
 * @author Siarhei Shauchenka at 25.09.17
 */
public class ConsoleEventLogger implements EventLogger{

    public void logEvent(Event msg){
        System.out.println(msg);
    }
}
