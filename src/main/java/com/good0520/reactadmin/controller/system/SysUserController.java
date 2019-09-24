package com.good0520.reactadmin.controller.system;

import com.good0520.reactadmin.core.Result;
import com.good0520.reactadmin.core.ResultGenerator;
import com.good0520.reactadmin.model.SysUser;
import com.good0520.reactadmin.service.system.ISysUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author Good0520
 * @date 2019/09/19
 */
@RestController
@RequestMapping("/api/sys/user")
public class SysUserController {
    @Resource
    private ISysUserService sysUserService;

    @PostMapping("/add")
    public Result add(SysUser sysUser) {

        sysUserService.addNewUser(sysUser);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        sysUserService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping(value = "/updatePwd")
    public Object updatePwd(@RequestParam String pwd) {
        sysUserService.updatePwd(pwd);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(SysUser sysUser) {
        sysUserService.update(sysUser);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        SysUser sysUser = sysUserService.findById(id);
        return ResultGenerator.genSuccessResult(sysUser);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysUser> list = sysUserService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
