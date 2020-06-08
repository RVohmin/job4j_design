package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public class SoftCache {
    private final Reader reader = new Reader();
    private final Map<String, SoftReference<String>> cacheMap = new HashMap<>();

    public String getText(String key) {
        SoftReference<String> softReference = cacheMap.get(key);
        if (softReference == null) {
            String text = reader.getTextfromFile(key);
            softReference = new SoftReference<>(text);
            cacheMap.put(key, softReference);
        }
        return cacheMap.get(key).get();
    }

    public void clearCache() {
        cacheMap.clear();
    }

    public boolean isInCache(String file) {
        return cacheMap.get(file) != null;
    }
}
