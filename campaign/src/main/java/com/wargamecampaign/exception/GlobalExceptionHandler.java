package com.wargamecampaign.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 3/9/20にjohnpolhilによって作成されました。
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    MessageSource messageSource;

    @ExceptionHandler(InvalidRequestException.class)
    public ModelAndView handleInvalidRequestException(InvalidRequestException e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(e.getView());
        modelAndView.addObject(e.getModelName(), e.getModel());
        modelAndView.addObject("error", messageSource.getMessage(e.getMessage(), new Object[0], LocaleContextHolder.getLocale()));
        return modelAndView;
    }

}
