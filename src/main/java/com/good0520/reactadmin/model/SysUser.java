package com.good0520.reactadmin.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.*;

@ApiModel(value="SysUser")
@Table(name = "sys_user")
public class SysUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value="")
    private Integer id;

    /**
     * 用户名
     */
    @ApiModelProperty(value="用户名")
    private String username;

    /**
     * 加盐
     */
    @ApiModelProperty(value="加盐")
    private String salt;

    /**
     * 密码
     */
    @ApiModelProperty(value="密码")
    private String password;

    /**
     * 手机号
     */
    @ApiModelProperty(value="手机号")
    private String mobile;

    /**
     * 注册时间
     */
    @Column(name = "create_time")
    @ApiModelProperty(value="注册时间")
    private Date createTime;

    /**
     * 1正常0禁用
     */
    @ApiModelProperty(value="1正常0禁用")
    private Integer status;

    /**
     * 头像
     */
    @ApiModelProperty(value="头像")
    private String headimg;

    /**
     * 角色id
     */
    @ApiModelProperty(value="角色id")
    private Integer roleid;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取加盐
     *
     * @return salt - 加盐
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 设置加盐
     *
     * @param salt 加盐
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取手机号
     *
     * @return mobile - 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取注册时间
     *
     * @return create_time - 注册时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置注册时间
     *
     * @param createTime 注册时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取1正常0禁用
     *
     * @return status - 1正常0禁用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置1正常0禁用
     *
     * @param status 1正常0禁用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取头像
     *
     * @return headimg - 头像
     */
    public String getHeadimg() {
        return headimg;
    }

    /**
     * 设置头像
     *
     * @param headimg 头像
     */
    public void setHeadimg(String headimg) {
        this.headimg = headimg;
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