package com.good0520.reactadmin.dao;

import com.good0520.reactadmin.core.Mapper;
import com.good0520.reactadmin.model.SysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysMenuMapper extends Mapper<SysMenu> {

    List<SysMenu>  getPath(@Param("roleId")Integer roleId);
}