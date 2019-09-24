package com.good0520.reactadmin.service.system;

import com.alibaba.fastjson.JSONObject;
import com.good0520.reactadmin.model.SysMenu;
import com.good0520.reactadmin.model.SysUser;

import java.util.List;

/**
 * @author Good0520
 * @date 2019/9/12
 */
public interface ILoginService {


    SysUser getUser(String userName);

    List<JSONObject> getMenuList(Integer roleId);

    List<SysMenu> getPathList(Integer roleId);
}
