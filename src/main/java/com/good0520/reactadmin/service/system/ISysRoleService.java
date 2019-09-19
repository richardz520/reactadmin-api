package com.good0520.reactadmin.service.system;
import com.alibaba.fastjson.JSONObject;
import com.good0520.reactadmin.model.SysRole;
import com.good0520.reactadmin.core.Service;


/**
* @author Good0520
* @date 2019/09/18
*/
public interface ISysRoleService extends Service<SysRole> {


    void addNewRole(String name,String remark,String menuIds);
    void deleteRole(Integer roleId);

    void updateRole(Integer id,String name, String remark, String menuIds);

    JSONObject roleDetail(Integer roleId);
}
