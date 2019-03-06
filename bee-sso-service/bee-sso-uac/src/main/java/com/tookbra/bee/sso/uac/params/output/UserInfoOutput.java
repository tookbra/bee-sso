package com.tookbra.bee.sso.uac.params.output;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author tookbra
 * @date 2019/3/1
 * @description
 */
@Data
@ToString
public class UserInfoOutput implements Serializable {

    private static final long serialVersionUID = 4829684610670012632L;
    private Integer id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 工号
     */
    private String jobNumber;
    /**
     * 是否激活
     */
    private boolean actived;
    /**
     * 头像地址
     */
    private String avatar;
    /**
     * 角色名称
     */
    private String roleName;
}
