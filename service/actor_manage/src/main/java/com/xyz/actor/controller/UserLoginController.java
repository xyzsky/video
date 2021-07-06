package com.xyz.actor.controller;

import com.xyz.commonutils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Xyz
 * @Date 2021/7/6
 */
@Api(tags = "用户登录接口")
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserLoginController {

    @PostMapping("/login")
    public R login() {
        return R.ok().data("token","admin");
    }

    @PostMapping("/info")
    public R info() {
        return R.ok().data("name","xyz").data("image","http://www.sdl");
    }
}
