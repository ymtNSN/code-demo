package com.example.demo.filter;

import com.example.demo.response.R;
import com.example.demo.util.ExceptionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by @author ymtNSN on 2020/4/15
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e) {
        System.out.println(e.getMessage());
        log.error(ExceptionUtil.getMessage(e));
        return R.error();
    }
}
