package com.xyz.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Xyz
 * @Date 2021/6/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomException extends RuntimeException{

    private Integer code; //状态码

    private String msg; // 异常信息

    @Override
    public String toString() {
        return "CustomException{" +
                "code=" + code +
                "msg='" + msg + '\'' +
                '}';
    }
}
