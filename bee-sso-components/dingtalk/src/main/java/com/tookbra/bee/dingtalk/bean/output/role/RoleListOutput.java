package com.tookbra.bee.dingtalk.bean.output.role;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tookbra.bee.dingtalk.bean.PageInfo;
import com.tookbra.bee.dingtalk.bean.output.DingTalkOutput;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author tookbra
 * @date 2019/1/21
 * @description
 */
@Data
@ToString
public class RoleListOutput extends DingTalkOutput {
    private static final long serialVersionUID = -7536725702791866483L;

    /**
     *
     */
    @JsonProperty("result")
    private PageInfo<RoleGroup> result;

    @Data
    @ToString
    public static class RoleGroup {
        /**
         * 角色组id
         */
        private Long groupId;
        /**
         * 角色名称
         */
        private String name;

        /**
         * 角色列表
         */
        @JsonProperty("roles")
        private List<Role> roles;
    }

    @Data
    @ToString
    public static class Role {
        /**
         * 角色id
         */
        @JsonProperty("id")
        private Long id;
        /**
         * 角色名称
         */
        private String name;
    }
}
