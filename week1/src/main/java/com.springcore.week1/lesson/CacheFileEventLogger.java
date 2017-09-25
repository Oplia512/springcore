package com.springcore.week1.lesson;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Siarhei Shauchenka at 25.09.17
 */
public class CacheFileEventLogger extends FileEventLogger {

    private int cacheSize;
    private List<Event> cache;

    public CacheFileEventLogger(String filename, int cacheSize) {
        super(filename);
        this.cacheSize = cacheSize;
        cache = new LinkedList<>();
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);
        if (cache.size() == cacheSize) {
            writeCacheToFile();
            cache.clear();
        }
    }

    private void writeCacheToFile() {
        cache.forEach(super::logEvent);
    }

    public void destroy() {
        if (!cache.isEmpty()) {
            writeCacheToFile();
        }
    }
}
