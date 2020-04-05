package com.wargamecampaign.controller;

import com.wargamecampaign.exception.InvalidRequestException;
import com.wargamecampaign.model.AccountEntity;
import com.wargamecampaign.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.sql.SQLException;

/**
 * 3/5/20にjohnpolhilによって作成されました。
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(path = "/login")
    public String login(@ModelAttribute AccountEntity accountEntity) {
        return "account/accountLogin";
    }

    @GetMapping(path = "/login/error")
    public String loginError(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        String errorMessage = null;
        if (session != null) {
            AuthenticationException ex = (AuthenticationException) session
                    .getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
            if (ex != null) {
                errorMessage = ex.getMessage();
            }
        }
        model.addAttribute("error", errorMessage);
        return "account/accountLogin";
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
