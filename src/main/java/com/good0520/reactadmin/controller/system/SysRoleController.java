package com.good0520.reactadmin.controller.system;

import com.good0520.reactadmin.core.Result;
import com.good0520.reactadmin.core.ResultGenerator;
import com.good0520.reactadmin.model.SysRole;
import com.good0520.reactadmin.service.system.ISysRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author Good0520
 * @date 2019/09/18
 */
@RestController
@RequestMapping("/api/sys/role")
public class SysRoleController {
    @Resource
    private ISysRoleService iSysRoleService;

    @PostMapping("/add")
    public Result add(String name, String remark, String menuIds) {
        iSysRoleService.addNewRole(name, remark, menuIds);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        iSysRoleService.deleteRole(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestParam Integer id,String name, String remark, String menuIds) {
        iSysRoleService.updateRole(id, name, remark, menuIds);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        return ResultGenerator.genSuccessResult(iSysRoleService.roleDetail(id));
    }

    @PostMapping("/list")
    public Result list() {
        List<SysRole> list = iSysRoleService.findAll();
        return ResultGenerator.genSuccessResult(list);
    }
}
