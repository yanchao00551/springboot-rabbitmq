package com.power.modules.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    @ResponseBody
    @GetMapping("/index")
    public Map<String,Object> Index(){
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","success");
        return map;
    }
}
