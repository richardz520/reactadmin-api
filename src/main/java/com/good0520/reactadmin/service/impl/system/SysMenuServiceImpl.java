package com.good0520.reactadmin.service.impl.system;

import com.alibaba.fastjson.JSONObject;
import com.good0520.reactadmin.core.ServiceException;
import com.good0520.reactadmin.dao.SysMenuMapper;
import com.good0520.reactadmin.model.SysMenu;
import com.good0520.reactadmin.service.system.ISysMenuService;
import com.good0520.reactadmin.core.AbstractService;
import com.good0520.reactadmin.utils.ListUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Good0520
 * @date 2019/09/17
 */
@Service
@Transactional
public class SysMenuServiceImpl extends AbstractService<SysMenu> implements ISysMenuService {
    @Resource
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<JSONObject> getMenuList() {
        return getMenu(0);
    }

    @Override
    public void deleteMenus(int pId) {

        List<SysMenu> pSysMenus = sysMenuMapper.selectByIds(String.valueOf(pId));
        if (ListUtils.isNotEmpty(pSysMenus)) {
            Example example = new Example(SysMenu.class);
            example.createCriteria().andEqualTo("pid", pId);
            List<SysMenu> childMenus = sysMenuMapper.selectByExample(example);
            if (ListUtils.isNotEmpty(childMenus)) {
                for (SysMenu childMenu : childMenus) {
                    deleteMenus(childMenu.getId());
                }
            }
            sysMenuMapper.deleteByIds(String.valueOf(pId));
        } else {
            throw new ServiceException("该菜单不存在！");
        }

    }

    private List<JSONObject> getMenu(int pId) {
        Example example = new Example(SysMenu.class);
        example.setOrderByClause("sort asc");
        example.createCriteria().andEqualTo("pid", pId);
        List<SysMenu> pSysMenus = sysMenuMapper.selectByExample(example);
        if (ListUtils.isNotEmpty(pSysMenus)) {
            List<JSONObject> list = new ArrayList<>(pSysMenus.size());
            for (SysMenu menu : pSysMenus) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("key", menu.getId());
                jsonObject.put("title", menu.getTitle());
                jsonObject.put("path", menu.getPath());
                jsonObject.put("component", menu.getComponent());
                jsonObject.put("sort", menu.getSort());
                jsonObject.put("icon", menu.getIcon());
                jsonObject.put("pid", menu.getPid());
                jsonObject.put("remark", menu.getRemark());
                List<JSONObject> childMenus = getMenu(menu.getId());
                if (ListUtils.isNotEmpty(childMenus)) {
                    jsonObject.put("children", childMenus);
                }
                list.add(jsonObject);
            }
            return list;
        }
        return null;
    }


}
