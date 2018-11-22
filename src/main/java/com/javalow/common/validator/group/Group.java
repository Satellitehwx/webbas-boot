package com.javalow.common.validator.group;

import javax.validation.GroupSequence;

/**
 * @anthor Satellite
 * Group
 * 定义校验顺序，如果AddGroup组失败，则UpdateGroup组不会再校验
 * http://www.javalow.com
 * @date 2018-11-18-16:06
 **/
@GroupSequence({AddGroup.class, UpdateGroup.class})
public class Group {
}
