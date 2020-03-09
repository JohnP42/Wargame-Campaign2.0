package com.wargamecampaign.controller;

import com.wargamecampaign.model.AccountEntity;
import com.wargamecampaign.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.sql.SQLException;

/**
 * 3/5/20にjohnpolhilによって作成されました。
 */
@Controller
@RequestMapping("account")
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public String newAccount(@ModelAttribute AccountEntity accountEntity) {
        return "account/accountCreate";
    }

    @PostMapping
    public String createAccount(@Valid @ModelAttribute AccountEntity accountEntity,
                                BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "account/accountCreate";
        }
        accountService.create(accountEntity);
        return "account/accountSuccess";
    }

}
