package com.good0520.reactadmin.service.impl.system;

import com.alibaba.fastjson.JSONObject;
import com.good0520.reactadmin.core.ServiceException;
import com.good0520.reactadmin.dao.SysMenuMapper;
import com.good0520.reactadmin.dao.SysRoleMapper;
import com.good0520.reactadmin.dao.SysRoleMenuMapper;
import com.good0520.reactadmin.model.SysMenu;
import com.good0520.reactadmin.model.SysRole;
import com.good0520.reactadmin.model.SysRoleMenu;
import com.good0520.reactadmin.service.system.ISysRoleService;
import com.good0520.reactadmin.core.AbstractService;
import com.good0520.reactadmin.utils.ListUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;


/**
 * @author Good0520
 * @date 2019/09/18
 */
@Service
@Transactional
public class SysRoleServiceImpl extends AbstractService<SysRole> implements ISysRoleService {
    @Resource
    private SysRoleMapper sysRoleMapper;

    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;
    @Resource
    private SysMenuMapper sysMenuMapper;

    @Override
    public void addNewRole(String name, String remark, String menuIds) {
        SysRole sysRole = new SysRole();
        sysRole.setName(name);
        sysRole.setRemark(remark);
        sysRole.setCreateTime(new Date());
        sysRoleMapper.insertSelective(sysRole);

        insertRoleMenu(menuIds, sysRole);
    }

    private void insertRoleMenu(String menuIds, SysRole sysRole) {
        HashSet<Integer> hashSet = new HashSet<>();
        List<SysMenu> menuList = sysMenuMapper.selectByIds(menuIds);
        if (ListUtils.isNotEmpty(menuList)) {
            for (SysMenu sysMenu : menuList) {
                hashSet.add(sysMenu.getId());
                hashSet.add(sysMenu.getPid());
            }
        }
        hashSet.remove(0);
        for (Integer id : hashSet) {
            SysRoleMenu sysRoleMenu = new SysRoleMenu();
            sysRoleMenu.setMenuid(id);
            sysRoleMenu.setRoleid(sysRole.getId());
            sysRoleMenuMapper.insertSelective(sysRoleMenu);
        }
    }

    @Override
    public void deleteRole(Integer roleId) {
        deleteRoleMenu(roleId);
        sysRoleMapper.deleteByIds(String.valueOf(roleId));
    }

    private void deleteRoleMenu(Integer roleId) {
        Example example = new Example(SysRoleMenu.class);
        example.createCriteria().andEqualTo("roleid", roleId);
        List<SysRoleMenu> sysRoleMenuList = sysRoleMenuMapper.selectByExample(example);
        if (ListUtils.isNotEmpty(sysRoleMenuList)) {
            for (SysRoleMenu sysRoleMenu : sysRoleMenuList) {
                sysRoleMenuMapper.delete(sysRoleMenu);
            }
        }
    }

    @Override
    public void updateRole(Integer id, String name, String remark, String menuIds) {
        SysRole sysRole = sysRoleMapper.selectByPrimaryKey(id);
        if (sysRole == null) {
            throw new ServiceException("该角色不存在！");
        }
        sysRole.setName(name);
        sysRole.setRemark(remark);
        sysRoleMapper.updateByPrimaryKeySelective(sysRole);
        deleteRoleMenu(id);
        insertRoleMenu(menuIds, sysRole);
    }

    @Override
    public JSONObject roleDetail(Integer roleId) {
        SysRole role = sysRoleMapper.selectByPrimaryKey(roleId);
        if (role == null) {
            throw new ServiceException("该角色不存在");
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", role.getId());
        jsonObject.put("name", role.getName());
        jsonObject.put("remark", role.getRemark());
        List<Integer> menuList = new ArrayList<>();
        Example example = new Example(SysRoleMenu.class);
        example.createCriteria().andEqualTo("roleid", roleId);
        List<SysRoleMenu> sysRoleMenuList = sysRoleMenuMapper.selectByExample(example);
        if (ListUtils.isNotEmpty(sysRoleMenuList)) {
            for (SysRoleMenu sysRoleMenu : sysRoleMenuList) {
                menuList.add(sysRoleMenu.getMenuid());
            }
        }
        jsonObject.put("menuList", menuList);
        return jsonObject;
    }
}
