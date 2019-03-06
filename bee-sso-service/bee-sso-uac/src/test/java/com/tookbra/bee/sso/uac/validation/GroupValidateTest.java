package com.tookbra.bee.sso.uac.validation;

import com.tookbra.bee.model.validation.groups.SaveGroup;
import com.tookbra.bee.model.validation.groups.UpdateGroup;
import com.tookbra.bee.sso.uac.params.input.MenuInput;
import org.hibernate.validator.HibernateValidator;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @author tookbra
 * @date 2019/3/5
 * @description
 */
public class GroupValidateTest {

    private Validator validator = null;

    @Before
    public void init() {
         validator = Validation.byProvider(HibernateValidator.class)
                .configure()
                .failFast(true)
                .buildValidatorFactory()
                .getValidator();
    }

    @Test
    public void UpdateGroupTest() {
        MenuInput input = new MenuInput();
        input.setMenuId(1);
        input.setName("test");
        input.setMenuType(0);
        Set<ConstraintViolation<MenuInput>> validate = validator.validate(input, UpdateGroup.class);
        for (ConstraintViolation<MenuInput> item : validate) {
            System.out.println(item);
        }
    }

    @Test
    public void SaveGroupTest() {
        MenuInput input = new MenuInput();
        input.setMenuId(1);
        input.setName("test");
        input.setMenuType(0);
        Set<ConstraintViolation<MenuInput>> validate = validator.validate(input, SaveGroup.class);
        for (ConstraintViolation<MenuInput> item : validate) {
            System.out.println(item);
        }
    }
}
