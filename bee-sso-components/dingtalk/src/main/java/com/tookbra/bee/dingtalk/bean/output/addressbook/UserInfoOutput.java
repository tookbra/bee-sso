package com.tookbra.bee.dingtalk.bean.output.addressbook;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tookbra.bee.dingtalk.bean.output.DingTalkOutput;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;
import java.util.Map;

/**
 * @author tookbra
 * @date 2019/1/9
 * @description
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
public class UserInfoOutput extends DingTalkOutput {
    private static final long serialVersionUID = -5874714736800599514L;

    /**
     * 员工唯一标识ID（不可修改）
     */
    @JsonProperty("userid")
    private String userId;
    /**
     * 员工名字
     */
    private String name;
    /**
     * 是否已经激活，true表示已激活，false表示未激活
     */
    private boolean active;
    /**
     * 在对应的部门中的排序，Map结构的json字符串，key是部门的Id，value是人员在这个部门的排序值
     * {1:71738366882504}
     */
    private Map orderInDepts;
    /**
     * 是否为企业的管理员，true表示是，false表示不是
     */
    private boolean isAdmin;
    /**
     * 是否为企业的老板，true表示是，false表示不是
     */
    private boolean isBoss;
    /**
     * 在当前isv全局范围内唯一标识一个用户的身份,用户无法修改
     */
    @JsonProperty("unionid")
    private String unionId;
    /**
     * 在对应的部门中是否为主管：Map结构的json字符串，key是部门的Id，value是人员在这个部门中是否为主管，true表示是，false表示不是
     * {1:false}
     */
    private Map isLeaderInDepts;
    /**
     * 是否号码隐藏，true表示隐藏，false表示不隐藏
     */
    private boolean isHide;
    /**
     * 成员所属部门id列表
     */
    private List<Integer> department;
    /**
     * 职位信息
     */
    private String position;
    /**
     * 头像url
     */
    private String avatar;
    /**
     * 入职时间。Unix时间戳 （在OA后台通讯录中的员工基础信息中维护过入职时间才会返回)
     */
    private long hiredDate;
    /**
     * 员工工号
     */
    @JsonProperty("jobNumber")
    private String jobNumber;
    /**
     * 是否是高管
     */
    private boolean isSenior;
}
