package com.hcbxwy.snail.example.user.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.hcbxwy.snail.common.entity.LoginUser;
import com.hcbxwy.snail.common.utils.JwtUtil;
import com.hcbxwy.snail.example.user.pojo.entity.UserDO;
import com.hcbxwy.snail.example.user.pojo.vo.LoginVO;
import com.hcbxwy.snail.example.user.service.LoginService;
import com.hcbxwy.snail.example.user.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;

/**
 * 登录模块接口实现类
 *
 * @author Billson
 * @date 2020/6/30 16:50
 */
@Service
@AllArgsConstructor
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Override
    public LoginUser login(LoginVO loginVO) {
        UserDO userDO = userService.getByUsername(loginVO.getUsername());
        if (Objects.isNull(userDO)) {
            log.error("该用户未注册。");
            return null;
        }
        String inputPwd = userService.getPassword(loginVO.getPassword(), userDO.getSalt());
        if (!Objects.equals(userDO.getPassword(), inputPwd)) {
            log.error("密码错误，请重新输入。");
            return null;
        }
        LoginUser loginUser = new LoginUser();
        loginUser.setUserId(userDO.getId())
                .setUsername(userDO.getUsername());
        Map<String, Object> dataMap = BeanUtil.beanToMap(loginUser, false, true);
        String token = JwtUtil.createToken(userDO.getId(), dataMap, null);
        loginUser.setToken(token);
        return loginUser;
    }

    @Override
    public LoginUser getLoginUser(HttpServletRequest request) {
        return (LoginUser) request.getAttribute("loginUserDTO");
    }

    private final UserService userService;
}
