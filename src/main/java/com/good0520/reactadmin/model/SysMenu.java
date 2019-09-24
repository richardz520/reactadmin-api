package com.good0520.reactadmin.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;

@ApiModel(value="SysMenu")
@Table(name = "sys_menu")
public class SysMenu {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value="主键")
    private Integer id;

    /**
     * 标题
     */
    @ApiModelProperty(value="标题")
    private String title;

    /**
     * 路由
     */
    @ApiModelProperty(value="路由")
    private String path;

    /**
     * 组件
     */
    @ApiModelProperty(value="组件")
    private String component;

    /**
     * 排序
     */
    @ApiModelProperty(value="排序")
    private Integer sort;

    /**
     * 图标
     */
    @ApiModelProperty(value="图标")
    private String icon;

    /**
     * 父id
     */
    @ApiModelProperty(value="父id")
    private Integer pid;

    /**
     * 备注
     */
    @ApiModelProperty(value="备注")
    private String remark;

    /**
     * 是否路由
     */
    @ApiModelProperty(value="是否路由")
    private Integer isLink;

    public Integer getIsLink() {
        return isLink;
    }

    public void setIsLink(Integer isLink) {
        this.isLink = isLink;
    }

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
     * 获取标题
     *
     * @return title - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取路由
     *
     * @return path - 路由
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置路由
     *
     * @param path 路由
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取组件
     *
     * @return component - 组件
     */
    public String getComponent() {
        return component;
    }

    /**
     * 设置组件
     *
     * @param component 组件
     */
    public void setComponent(String component) {
        this.component = component;
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取图标
     *
     * @return icon - 图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置图标
     *
     * @param icon 图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 获取父id
     *
     * @return pid - 父id
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 设置父id
     *
     * @param pid 父id
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}