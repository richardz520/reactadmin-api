package com.good0520.reactadmin.controller.system;

import com.good0520.reactadmin.core.Result;
import com.good0520.reactadmin.core.ResultGenerator;
import com.good0520.reactadmin.core.ServiceException;
import com.good0520.reactadmin.model.SysUser;
import com.good0520.reactadmin.service.system.ILoginService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Good0520
 * @date 2019/9/12
 */
@RestController
@Slf4j
@RequestMapping("/api/sys")
public class LoginController {
    @Autowired
    private ILoginService iLoginService;


    @PostMapping("/login")
    public Result login(String username, String password) {

        Subject subject = SecurityUtils.getSubject();
        SysUser user=iLoginService.getUser(username);
        try {
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
            subject.login(usernamePasswordToken);
            user.setPassword("");

            return ResultGenerator.genSuccessResult(user);
        } catch (IncorrectCredentialsException e) {
            throw new ServiceException("密码错误！");
        } catch (LockedAccountException e) {
            throw new ServiceException("该账号已禁用！");
        } catch (AuthenticationException e) {
            throw new ServiceException("该用户不存在！");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ServiceException("未知错误！");
        }

    }

    @PostMapping(value = "/logout")
    public Object logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return ResultGenerator.genSuccessResult();
    }

}
