package com.hcbxwy.snail.example.demo.controller.service.impl;

import com.hcbxwy.snail.example.common.BaseServiceImpl;
import com.hcbxwy.snail.example.demo.controller.service.DemoService;
import com.hcbxwy.snail.example.user.pojo.dto.LoginUserDTO;
import org.springframework.stereotype.Service;

/**
 * Demo 接口实现类
 *
 * @author Billson
 * @date 2020/6/30 17:31
 */
@Service
public class DemoServiceImpl extends BaseServiceImpl implements DemoService {

    @Override
    public LoginUserDTO getLoginInfo() {
        return getLoginUser();
    }
}
