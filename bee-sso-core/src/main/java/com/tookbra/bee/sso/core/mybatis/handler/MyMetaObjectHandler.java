package com.tookbra.bee.sso.core.mybatis.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;

/**
 * @author tookbra
 * @date 2019/2/15
 * @description
 */
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        Object createTime = getFieldValByName(getCreateTimeFieldName(), metaObject);
        if (createTime == null) {
            setFieldValByName(getCreateTimeFieldName(), LocalDateTime.now(), metaObject);
        }

        Object deleted = getFieldValByName(getDeletedFieldName(), metaObject);
        if (deleted == null) {
            setFieldValByName(getDeletedFieldName(), false, metaObject);
        }

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName(getUpdateTimeFieldName(), LocalDateTime.now(), metaObject);
    }

    public String getCreateTimeFieldName() {
        return "createdTime";
    }

    public String getUpdateTimeFieldName() {
        return "modifyTime";
    }

    public String getDeletedFieldName() {
        return "deleted";
    }


}
