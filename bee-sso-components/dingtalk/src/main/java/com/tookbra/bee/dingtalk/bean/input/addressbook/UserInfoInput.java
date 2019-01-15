package com.tookbra.bee.dingtalk.bean.input.addressbook;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tookbra.bee.dingtalk.bean.AbstractDingTalkInput;
import com.tookbra.bee.dingtalk.bean.output.addressbook.UserInfoOutput;
import lombok.Data;
import lombok.ToString;

/**
 * @author tookbra
 * @date 2019/1/14
 * @description
 */
@Data
@ToString
public class UserInfoInput extends AbstractDingTalkInput<UserInfoOutput> {

    /**
     * 企业内的userid，企业用来唯一标识一个用户
     */
    @JsonProperty("userid")
    private String userId;
    /**
     * 通讯录语言(默认zh_CN，未来会支持en_US)
     */
    private String lang;


    @Override
    public Class<UserInfoOutput> getClasses() {
        return UserInfoOutput.class;
    }

    @Override
    public String getParam() {
        return null;
    }
}
