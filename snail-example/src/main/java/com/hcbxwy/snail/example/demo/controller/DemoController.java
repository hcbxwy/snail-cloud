package com.hcbxwy.snail.example.demo.controller;

import com.hcbxwy.snail.common.base.BaseController;
import com.hcbxwy.snail.example.demo.controller.service.DemoService;
import com.hcbxwy.snail.common.entity.LoginUser;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Demo
 *
 * @author Billson
 * @date 2020/6/30 17:29
 */
@RestController
@AllArgsConstructor
@RequestMapping("/demo")
public class DemoController extends BaseController {

    @GetMapping("/getLoginUserInfo")
    public LoginUser getLoginUserInfo() {
        return demoService.getLoginInfo();
    }

    private final DemoService demoService;
}
