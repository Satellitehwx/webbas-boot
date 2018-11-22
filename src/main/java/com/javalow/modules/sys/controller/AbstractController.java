package com.javalow.modules.sys.controller;

import com.javalow.modules.sys.domain.SysUser;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @anthor Satellite
 * AbstractController
 * 公共Controller组建
 * http://www.javalow.com
 * @date 2018-11-18-15:54
 **/
public abstract class AbstractController {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected SysUser getUser() {
        return (SysUser) SecurityUtils.getSubject().getPrincipal();
    }

    protected Long getUserId() {
        return getUser().getUserId();
    }

}
