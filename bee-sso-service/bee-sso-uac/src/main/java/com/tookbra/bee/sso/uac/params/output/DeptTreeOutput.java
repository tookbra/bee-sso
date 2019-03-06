package com.tookbra.bee.sso.uac.params.output;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author tookbra
 * @date 2019/3/4
 * @description
 */
@Data
@ToString
public class DeptTreeOutput implements Serializable {
    private static final long serialVersionUID = 2476405361907504092L;

    private Integer id;

    private Integer parentId;

    private String deptName;

    private List<DeptTreeOutput> children;
}
