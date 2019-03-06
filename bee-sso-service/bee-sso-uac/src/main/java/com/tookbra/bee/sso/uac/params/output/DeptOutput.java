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
public class DeptOutput implements Serializable {
    private static final long serialVersionUID = 9138573865131341541L;

    private Integer id;
    /**
     * 父id
     */
    private Integer parentId;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 同步时间
     */
    private Date syncTime;
}
