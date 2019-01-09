package com.tookbra.bee.dingtalk.bean.result.addressbook;

import com.tookbra.bee.dingtalk.bean.result.BaseResult;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class DeptUser extends BaseResult {
    private static final long serialVersionUID = 4132847088620524493L;

    /**
     * userId列表
     */
    private List<String> userIds;
}
