package com.good0520.reactadmin.service.impl.system;

import com.alibaba.druid.util.Utils;
import com.good0520.reactadmin.core.ServiceException;
import com.good0520.reactadmin.dao.SysUserMapper;
import com.good0520.reactadmin.model.SysUser;
import com.good0520.reactadmin.service.system.ISysUserService;
import com.good0520.reactadmin.core.AbstractService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;


/**
 * @author Good0520
 * @date 2019/09/19
 */
@Service
@Slf4j
@Transactional
public class SysUserServiceImpl extends AbstractService<SysUser> implements ISysUserService {
    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public void addNewUser(SysUser sysUser) {
        Example example = new Example(SysUser.class);
        example.createCriteria().andEqualTo("username", sysUser.getUsername());
        SysUser user = sysUserMapper.selectOneByExample(example);
        if (user != null) {
            throw new ServiceException("用户已存在！");
        }
        sysUser.setPassword(Utils.md5(sysUser.getPassword()));
        sysUser.setCreateTime(new Date());
        sysUserMapper.insertSelective(sysUser);
    }

    @Override
    public void updatePwd(String pwd) {
        Object object = SecurityUtils.getSubject().getPrincipal();
        SysUser user = new SysUser();
        try {
            PropertyUtils.copyProperties(user, object);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        user.setPassword(Utils.md5(pwd));
        sysUserMapper.updateByPrimaryKeySelective(user);
    }
}
