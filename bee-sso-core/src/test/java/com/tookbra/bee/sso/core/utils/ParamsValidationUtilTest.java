package com.tookbra.bee.sso.core.utils;

import org.junit.Test;

/**
 * @author tookbra
 * @date 2019/2/18
 * @description
 */
public class ParamsValidationUtilTest {

    @Test
    public void paramsValidate() {
        ParamInput input = new ParamInput();
        input.setAge(100);
        ParamsValidationUtil.validate(input);
    }
}
