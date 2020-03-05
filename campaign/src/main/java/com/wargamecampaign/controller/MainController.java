package com.wargamecampaign.controller;

import com.wargamecampaign.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    AccountService accountService;

    @GetMapping
    public String getHomePage(Map<String, Object> model) {
        
        return "index";
    }

}
