package com.tookbra.bee.dingtalk.bean.output.department;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tookbra.bee.dingtalk.bean.output.DingTalkOutput;
import lombok.Data;
import lombok.ToString;

/**
 * @author tookbra
 * @date 2019/1/21
 * @description
 */
@Data
@ToString
public class DepartmentInfoOutput extends DingTalkOutput {
    private static final long serialVersionUID = 4387692747782620365L;

    /**
     * 部门id
     */
    private Integer id;
    /**
     * 部门名称
     */
    private String name;
    /**
     * 父部门id，根部门为1
     */
    @JsonProperty("parentid")
    private Integer parentId;
    /**
     * 排序
     */
    private Integer order;
    /**
     * 是否同步创建一个关联此部门的企业群，true表示是，false表示不是
     */
    private boolean createDeptGroup;
    /**
     * 当部门群已经创建后，是否有新人加入部门会自动加入该群，true表示是，false表示不是
     */
    private boolean autoAddUser;
    /**
     * 是否隐藏部门，true表示隐藏，false表示显示
     */
    private boolean deptHiding;
    /**
     * 可以查看指定隐藏部门的其他部门列表，如果部门隐藏，则此值生效，取值为其他的部门id组成的的字符串，使用“|”符号进行分割
     */
    private String deptPermits;
    /**
     * 可以查看指定隐藏部门的其他人员列表，如果部门隐藏，则此值生效，取值为其他的人员userid组成的的字符串，使用“|”符号进行分割
     */
    private String userPermits;
    /**
     * 是否本部门的员工仅可见员工自己，为true时，本部门员工默认只能看到员工自己
     */
    private boolean outerDept;
    /**
     * 本部门的员工仅可见员工自己为true时，可以配置额外可见部门，值为部门id组成的的字符串，使用“|”符号进行分割
     */
    private String outerPermitDepts;
    /**
     * 本部门的员工仅可见员工自己为true时，可以配置额外可见人员，值为userid组成的的字符串，使用“|”符号进行分割
     */
    private String outerPermitUsers;
    /**
     * 企业群群主
     */
    private String orgDeptOwner;
    /**
     * 部门标识字段，开发者可用该字段来唯一标识一个部门，并与钉钉外部通讯录里的部门做映射
     */
    private String sourceIdentifier;
    /**
     * 部门的主管列表，取值为由主管的userid组成的字符串，不同的userid使用“|”符号进行分割
     */
    private String deptManagerUseridList;
    /**
     * 部门群是否包含子部门
     */
    private boolean groupContainSubDept;
}
