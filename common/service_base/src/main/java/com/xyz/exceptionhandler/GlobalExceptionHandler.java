package com.xyz.exceptionhandler;

import com.xyz.commonutils.R;
import com.xyz.util.ExceptionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author Xyz
 * @Date 2021/6/27
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    //全局异常处理
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e) {
        e.printStackTrace();
        return R.error().message("执行了全局异常处理...");
    }

    //特定异常处理
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public R error(ArithmeticException e) {
        e.printStackTrace();
        return R.error().message("执行了全局异常处理...");
    }

    //自定义异常处理
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public R error(CustomException e) {
        log.error(ExceptionUtil.getMessage(e));
//        e.printStackTrace();
        return R.error().code(e.getCode()).message(e.getMsg());
    }

}
