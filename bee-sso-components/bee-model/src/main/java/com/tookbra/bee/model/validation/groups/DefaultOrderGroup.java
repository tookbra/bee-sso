package com.tookbra.bee.model.validation.groups;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

/**
 * @author tookbra
 * @date 2019/3/5
 * @description
 */
@GroupSequence({SaveGroup.class, UpdateGroup.class, Default.class})
public interface DefaultOrderGroup {
}
