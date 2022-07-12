package com.example.findmyip.controller;

import com.example.findmyip.service.BlackListService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class IpController {
    private final BlackListService service;

    public IpController(BlackListService service) {
        this.service = service;
    }

    @GetMapping("/findmyip")
    public String find(HttpServletRequest request) {
        String ip = request.getRemoteHost();
        service.inc(ip);
        return service.check(ip) ? "You are blocked" : "You are welcome";
    }
}
