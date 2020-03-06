package com.wargamecampaign.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * 2/24/20にjohnpolhilによって作成されました。
 */
@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping
    public String getHomePage(Map<String, Object> model) {
        
        return "index";
    }

}
