package com.good0520.reactadmin.service.system;
import com.good0520.reactadmin.model.SysUser;
import com.good0520.reactadmin.core.Service;


/**
* @author Good0520
* @date 2019/09/19
*/
public interface ISysUserService extends Service<SysUser> {

    void addNewUser(SysUser sysUser);
}
