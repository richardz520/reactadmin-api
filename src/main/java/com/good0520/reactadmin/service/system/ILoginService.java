package com.good0520.reactadmin.service.system;

import com.good0520.reactadmin.model.SysUser;

/**
 * @author Good0520
 * @date 2019/9/12
 */
public interface ILoginService {


    SysUser login(String userName, String password);
}
