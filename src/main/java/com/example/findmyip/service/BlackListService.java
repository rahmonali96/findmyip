package com.example.findmyip.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class BlackListService {
    private Map<String, Long> map;

    @PostConstruct
    public void init() {
        map = new HashMap<>();
    }

    public void add(String ip) {
        map.put(ip, 1L);
    }

    public void inc(String ip) {
        map.put(ip, map.get(ip) + 1);
    }

    public boolean check(String ip) {
        return map.get(ip) > 5;
    }
}
