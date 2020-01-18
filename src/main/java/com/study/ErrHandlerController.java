package com.study;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrHandlerController {
	@Autowired
	MessageSource messageSource;

	static Logger log=LoggerFactory.getLogger(ErrHandlerController.class);
    /**
     * 方法参数校验
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public RespMsg handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error(e.getMessage(), e);
        return RespMsg.buildResult(501,  e.getBindingResult().getFieldError().getDefaultMessage());
    }
    @ResponseBody
    @ExceptionHandler(BindException.class)
    public RespMsg handleBindException(BindException e) {
    	Locale locale=LocaleContextHolder.getLocale();
    	System.err.println("local="+locale);
        log.error(e.getMessage()+e);
        System.out.println(e.getBindingResult());
        String message=messageSource.getMessage(e.getBindingResult().getFieldError(), locale);
        return RespMsg.buildResult(505,message);
    }
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public RespMsg excetion(Exception e) {
    	log.error(e.getMessage(), e);
    	return RespMsg.buildResult(500,"系统错误");
    }
    
    

}
