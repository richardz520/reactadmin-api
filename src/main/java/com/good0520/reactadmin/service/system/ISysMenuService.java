package com.good0520.reactadmin.service.system;
import com.alibaba.fastjson.JSONObject;
import com.good0520.reactadmin.model.SysMenu;
import com.good0520.reactadmin.core.Service;

import java.util.List;


/**
* @author Good0520
* @date 2019/09/17
*/
public interface ISysMenuService extends Service<SysMenu> {


    List<JSONObject> getMenuList();
    void deleteMenus(int pId);
}
