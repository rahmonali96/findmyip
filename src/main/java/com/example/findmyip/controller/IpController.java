package com.example.findmyip.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class IpController {
    @GetMapping("/findmyip")
    public String find(HttpServletRequest request) {
        return request.getRemoteHost();
    }
}
