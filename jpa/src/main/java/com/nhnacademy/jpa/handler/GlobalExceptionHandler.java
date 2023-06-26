package com.nhnacademy.jpa.handler;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ModelAndView handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("message", "주민을 삭제할 수 없습니다. 주민이 다른 데이터와 연관되어 있습니다.");
        return mav;
    }
}