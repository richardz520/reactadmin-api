package com.good0520.reactadmin.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;

@ApiModel(value="SysRoleMenu")
@Table(name = "sys_role_menu")
public class SysRoleMenu {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value="主键")
    private Integer id;

    /**
     * 菜单id
     */
    @ApiModelProperty(value="菜单id")
    private Integer menuid;

    /**
     * 角色id
     */
    @ApiModelProperty(value="角色id")
    private Integer roleid;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取菜单id
     *
     * @return menuid - 菜单id
     */
    public Integer getMenuid() {
        return menuid;
    }

    /**
     * 设置菜单id
     *
     * @param menuid 菜单id
     */
    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    /**
     * 获取角色id
     *
     * @return roleid - 角色id
     */
    public Integer getRoleid() {
        return roleid;
    }

    /**
     * 设置角色id
     *
     * @param roleid 角色id
     */
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }
}