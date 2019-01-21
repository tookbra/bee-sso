package com.tookbra.bee.dingtalk.bean.output.department;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class DepartmentListOutput extends DingTalkOutput {
    private static final long serialVersionUID = -884350219811807935L;

    /**
     * 部门列表
     */
    public List<Department> department;

    @Data
    public static class Department {
        /**
         * 部门id
         */
        private Long id;
        /**
         * 部门名称
         */
        private String name;
        /**
         * 	父部门id，根部门为1
         */
        @JsonProperty("parentid")
        private Long parentId;
        /**
         * 是否同步创建一个关联此部门的企业群，true表示是，false表示不是
         */
        private boolean createDeptGroup;
        /**
         * 当群已经创建后，是否有新人加入部门会自动加入该群, true表示是，false表示不是
         */
        private boolean autoAddUser;
    }

}
