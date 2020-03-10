package com.wargamecampaign.controller;

import com.wargamecampaign.exception.InvalidRequestException;
import com.wargamecampaign.model.AccountEntity;
import com.wargamecampaign.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
        try {
            accountService.create(accountEntity);
        } catch (DuplicateKeyException e) {
            throw new InvalidRequestException("loc.accountEntity.duplicate", "account/accountCreate", accountEntity);
        }
        return "account/accountSuccess";
    }

}
