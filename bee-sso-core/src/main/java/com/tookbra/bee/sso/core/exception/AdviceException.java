package com.tookbra.bee.sso.core.exception;

import com.tookbra.bee.model.exception.ApiException;
import com.tookbra.bee.model.exception.BizException;
import com.tookbra.bee.model.exception.ParamsException;
import com.tookbra.bee.model.exception.enums.ExceptionEnum;
import com.tookbra.bee.model.result.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author tookbra
 * @date 2019/2/15
 * @description
 */
@Slf4j
@ControllerAdvice
@Order(200)
public class AdviceException {

    /**
     * 参数异常
     * @param e
     * @return
     */
    @ExceptionHandler(ParamsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public BaseResult paramsException(BizException e) {
        log.info("参数异常:{}", e);
        return BaseResult.error(e.getCode(), e.getMessage());
    }

    /**
     * 业务异常
     * @param e
     * @return
     */
    @ExceptionHandler(BizException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public BaseResult bizException(BizException e) {
        log.info("业务异常:{}", e);
        return BaseResult.error(e.getCode(), e.getMessage());
    }

    /**
     * 服务异常
     */
    @ExceptionHandler(ApiException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public BaseResult apiException(ApiException e) {
        log.error("服务异常:{}", e);
        return BaseResult.error(e.getCode(), e.getMessage());
    }

    /**
     * 未知异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public BaseResult serverException(Exception e) {
        log.error("运行时异常:{}", e);
        return BaseResult.error(ExceptionEnum.SERVICE_ERROR.getCode(), ExceptionEnum.SERVICE_ERROR.getMessage());
    }
}
