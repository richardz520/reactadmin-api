package com.good0520.reactadmin.controller.system;

import com.good0520.reactadmin.core.Result;
import com.good0520.reactadmin.core.ResultGenerator;
import com.good0520.reactadmin.service.system.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Good0520
 * @date 2019/9/12
 */
@RestController
@RequestMapping("/api/sys")
public class LoginController {
    @Autowired
    private ILoginService iLoginService;


    @PostMapping("/login")
    public Result login(String username, String password) {
        return ResultGenerator.genSuccessResult(iLoginService.login(username, password));
    }

}
