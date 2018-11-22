package com.javalow.modules.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.javalow.modules.sys.domain.SysUser;

import java.util.List;

/**
 * @anthor Satellite
 * SysUserMapper
 * 系统用户Mapper接口
 * http://www.javalow.com
 * @date 2018-11-18-16:08
 **/
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 查询用户的所有权限
     *
     * @param userId 用户ID
     */
    List<String> queryAllPerms(Long userId);

    /**
     * 查询用户的所有菜单ID
     */
    List<Long> queryAllMenuId(Long userId);

    /**
     * 根据用户名，查询系统用户
     */
    SysUser queryByUserName(String username);

}
