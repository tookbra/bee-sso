package com.tookbra.bee.sso.uac.params.output;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author tookbra
 * @date 2019/3/4
 * @description
 */
@Data
@ToString
public class RoleOutput implements Serializable {
    private static final long serialVersionUID = -6416780805970266913L;

    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 描述
     */
    private String description;
    /**
     * 同步时间
     */
    private Date syncTime;
}
