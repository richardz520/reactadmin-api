package com.good0520.reactadmin.configurer.shiro;

import com.good0520.reactadmin.model.SysUser;
import com.good0520.reactadmin.service.system.ILoginService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Good0520
 * @date 2019/9/23
 */
public class CustomShiroRealm extends AuthorizingRealm {
    @Autowired
    private ILoginService iLoginService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //从token获取用户信息，token代表用户输入
        String username = (String)authenticationToken.getPrincipal();

        SysUser user =  iLoginService.getUser(username);
        if (user==null){
            return null;
        }
        //账户冻结
        if (user.getStatus() == 0) {
            throw new LockedAccountException();
        }
        return new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getName());
    }
}
