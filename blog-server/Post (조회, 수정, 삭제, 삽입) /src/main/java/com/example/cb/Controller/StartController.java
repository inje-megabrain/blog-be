package com.example.cb.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {
    @GetMapping("/")   //Form 데이터 받기
    public String index(){
        return "index";
    }
}
