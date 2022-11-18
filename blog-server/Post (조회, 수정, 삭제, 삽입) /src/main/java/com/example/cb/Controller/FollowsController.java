package com.example.cb.Controller;

import com.example.cb.DTO.FollowsDto;
import com.example.cb.Entity.Follows;
import com.example.cb.Service.FollowingService;

import com.example.cb.Service.FollowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/follows")
public class FollowsController {
    @Autowired
    private FollowsService followsService;
    @GetMapping("/{followFrom}")
    @PostMapping("/create")
    public String create(HttpServletRequest request, Model model, FollowsDto followsDto) throws InterruptedException {
        followsDto.setFollowTime("1");
        model.addAttribute("name1", followsDto.getFollowFrom());
        model.addAttribute("name2", followsDto.getFollowTo());
        model.addAttribute("ad", (followsService.create(request, model, followsDto)));
        return "index";
    }
}
