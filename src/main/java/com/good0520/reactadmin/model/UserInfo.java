package com.good0520.reactadmin.model;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Good0520
 * @date 2019/9/24
 */
@Data
public class UserInfo implements Serializable {
    private Integer id;
    private String userName;
    private String headimg;
    private Integer roleid;
    private String token;
    private List<JSONObject> menuList;
    private List<SysMenu> pathList;
}
