package com.good0520.reactadmin.service.impl.system;

import com.alibaba.druid.util.Utils;
import com.good0520.reactadmin.core.ServiceException;
import com.good0520.reactadmin.dao.SysUserMapper;
import com.good0520.reactadmin.model.SysUser;
import com.good0520.reactadmin.service.system.ILoginService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Good0520
 * @date 2019/9/12
 */
@Service
public class LoginServiceImpl implements ILoginService {

    @Resource
    protected SysUserMapper sysUserMapper;


    @Override
    public SysUser login(String userName, String password) {
        if (StringUtils.isEmpty(userName)) {
            throw new ServiceException("用户名不能为空！");
        }
        Example example = new Example(SysUser.class);
        example.createCriteria().andEqualTo("username", userName);

        List<SysUser> users = sysUserMapper.selectByExample(example);
        if (users != null && users.size() > 0) {
            if(users.get(0).getStatus()!=1){
                throw new ServiceException("该账号已禁用！");
            }
            if (users.get(0).getPassword().equals(Utils.md5(password))) {
                users.get(0).setPassword("");
                return  users.get(0);
            }
            throw new ServiceException("密码错误！");
        }
        throw new ServiceException("该用户不存在！");
    }
}
