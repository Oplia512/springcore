package com.springcore.week1.lesson;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author Siarhei Shauchenka at 25.09.17
 */
public class FileEventLogger implements EventLogger {

    private String filename;
    private File file;

    public FileEventLogger(String filename) {
        this.filename = filename;
    }

    protected void init() throws NullPointerException{
        this.file = new File(filename);
    }

    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, event.toString(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
