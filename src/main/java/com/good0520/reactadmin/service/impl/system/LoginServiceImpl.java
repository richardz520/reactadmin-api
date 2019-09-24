package com.good0520.reactadmin.service.impl.system;

import com.alibaba.druid.util.Utils;
import com.alibaba.fastjson.JSONObject;
import com.good0520.reactadmin.core.ServiceException;
import com.good0520.reactadmin.dao.SysMenuMapper;
import com.good0520.reactadmin.dao.SysRoleMenuMapper;
import com.good0520.reactadmin.dao.SysUserMapper;
import com.good0520.reactadmin.model.SysMenu;
import com.good0520.reactadmin.model.SysRoleMenu;
import com.good0520.reactadmin.model.SysUser;
import com.good0520.reactadmin.service.system.ILoginService;
import com.good0520.reactadmin.utils.ListUtils;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Good0520
 * @date 2019/9/12
 */
@Service
public class LoginServiceImpl implements ILoginService {

    @Resource
    protected SysUserMapper sysUserMapper;
    @Resource
    protected SysRoleMenuMapper sysRoleMenuMapper;
    @Resource
    private SysMenuMapper sysMenuMapper;


    @Override
    public SysUser getUser(String userName) {
        Example example = new Example(SysUser.class);
        example.createCriteria().andEqualTo("username", userName);

        return sysUserMapper.selectOneByExample(example);
    }

    @Override
    public List<JSONObject> getMenuList(Integer roleId) {
        Example example = new Example(SysRoleMenu.class);
        example.createCriteria().andEqualTo("roleid", roleId);
        List<SysRoleMenu> sysRoleMenuList = sysRoleMenuMapper.selectByExample(example);

        if (ListUtils.isNotEmpty(sysRoleMenuList)) {

            List<Integer> menuIds = Lists.newArrayList();
            for (SysRoleMenu sysRoleMenu : sysRoleMenuList) {
                menuIds.add(sysRoleMenu.getMenuid());
            }
            List<JSONObject> menus = getMenu(0, menuIds);
            if (menus != null) {
                return menus;
            }
        }
        return Lists.newArrayList();
    }

    private List<JSONObject> getMenu(int pId, List<Integer> menuIds) {
        Example example = new Example(SysMenu.class);
        example.setOrderByClause("sort asc");
        example.createCriteria().andEqualTo("pid", pId);
        List<SysMenu> pSysMenus = sysMenuMapper.selectByExample(example);
        if (ListUtils.isNotEmpty(pSysMenus)) {
            List<JSONObject> list = new ArrayList<>(pSysMenus.size());
            for (SysMenu menu : pSysMenus) {
                if (menuIds.contains(menu.getId())) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("id", menu.getId());
                    jsonObject.put("title", menu.getTitle());
                    jsonObject.put("path", menu.getPath());
                    jsonObject.put("component", menu.getComponent());
                    jsonObject.put("sort", menu.getSort());
                    jsonObject.put("icon", menu.getIcon());
                    jsonObject.put("pid", menu.getPid());
                    jsonObject.put("isLink", menu.getIsLink());
                    jsonObject.put("remark", menu.getRemark());
                    List<JSONObject> childMenus = getMenu(menu.getId(), menuIds);
                    if (ListUtils.isNotEmpty(childMenus)) {
                        jsonObject.put("children", childMenus);
                    }
                    list.add(jsonObject);
                }
            }
            return list;
        }
        return null;
    }

    @Override
    public List<SysMenu> getPathList(Integer roleId) {
         return  sysMenuMapper.getPath(roleId);


    }
}
