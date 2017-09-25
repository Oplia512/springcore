package com.springcore.week1.lesson;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author Siarhei Shauchenka at 25.09.17
 */
public class Event {

    private int id;
    private String msg;
    private Date date;
    private DateFormat df;


    public Event() {
        init();
    }

    public Event(Date date, DateFormat dateFormat) {
        init();
        this.date = date;
        this.df = dateFormat;
    }

    private void init(){
        id = new Random().nextInt();
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + df.format(date) +
                '}';
    }
}
