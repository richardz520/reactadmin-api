package com.good0520.reactadmin.controller.system;
import com.alibaba.fastjson.JSONObject;
import com.good0520.reactadmin.core.Result;
import com.good0520.reactadmin.core.ResultGenerator;
import com.good0520.reactadmin.model.SysMenu;
import com.good0520.reactadmin.service.system.ISysMenuService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


/**
* @author Good0520
* @date 2019/09/17
*/
@RestController
@RequestMapping("/api/sys/menu")
public class MenuController {
    @Resource
    private ISysMenuService iSysMenuService;

    @PostMapping("/add")
    public Result add(SysMenu sysMenu) {
        iSysMenuService.save(sysMenu);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        iSysMenuService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(SysMenu sysMenu) {
        iSysMenuService.update(sysMenu);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        SysMenu sysMenu = iSysMenuService.findById(id);
        return ResultGenerator.genSuccessResult(sysMenu);
    }

    @PostMapping("/list")
    public Result list() {

        List<JSONObject> list = iSysMenuService.getMenuList();

        return ResultGenerator.genSuccessResult(list);
    }
}
