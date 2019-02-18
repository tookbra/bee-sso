package com.tookbra.bee.sso.core.utils;

import com.tookbra.bee.model.exception.ParamsException;
import com.tookbra.bee.model.result.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.HibernateValidator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @author tookbra
 * @date 2019/2/18
 * @description
 */
@Slf4j
public class ParamsValidationUtil {


    private static Validator validator = Validation.byProvider(HibernateValidator.class)
            .configure()
            .failFast(true)
            .buildValidatorFactory()
            .getValidator();

    public static <T> BaseResult validate(T... obj) {
        for(int i = 0; i < obj.length; i++) {
            Set<ConstraintViolation<T>> constraintViolations = validator.validate(obj[i]);
            if (constraintViolations.size() <= 0) {
                continue;
            }
            String message = constraintViolations.iterator().next().getMessage();
            log.warn("param invalidate fail={}", message);
            throw new ParamsException(message);
        }
        return new BaseResult();
    }
}
