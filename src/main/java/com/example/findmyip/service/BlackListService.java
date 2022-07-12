package com.example.findmyip.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class BlackListService {
    private Map<String, Integer> map;

    @PostConstruct
    public void init() {
        map = new HashMap<>();
    }

    public void add(String ip) {
        map.put(ip, 1);
    }

    public synchronized void inc(String ip) {
        if (!map.containsKey(ip)){
            add(ip);
        }else {
            int l = map.get(ip);
            map.remove(ip);
            map.put(ip, l + 1);
        }
    }

    public boolean check(String ip) {
        return map.get(ip) > 5;
    }

    public Map<String, Integer> getMap() {
        return map;
    }
}
