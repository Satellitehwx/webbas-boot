package com.javalow.modules.sys.service;

import com.javalow.modules.sys.domain.SysUser;
import com.javalow.modules.sys.domain.SysUserToken;

import java.util.Set;

/**
 * @anthor Satellite
 * ShiroService
 * Shiro 相关接口
 * http://www.javalow.com
 * @date 2018-11-20-20:40
 **/
public interface ShiroService {

    /**
     * 获取用户权限列表
     *
     * @param userId 用户id
     * @return
     */
    Set<String> getUserPermissions(long userId);

    SysUserToken queryByToken(String token);

    /**
     * 根据用户ID，查询用户
     *
     * @param userId
     */
    SysUser queryUser(Long userId);

}
