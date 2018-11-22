package com.javalow.modules.sys.service.impl;

import com.javalow.common.utils.Constant;
import com.javalow.modules.sys.domain.SysMenu;
import com.javalow.modules.sys.domain.SysUser;
import com.javalow.modules.sys.domain.SysUserToken;
import com.javalow.modules.sys.mapper.SysMenuMapper;
import com.javalow.modules.sys.mapper.SysUserMapper;
import com.javalow.modules.sys.mapper.SysUserTokenMapper;
import com.javalow.modules.sys.service.ShiroService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @anthor Satellite
 * ShiroServiceImpl
 * Shiro Service 接口的实现
 * http://www.javalow.com
 * @date 2018-11-20-20:55
 **/
@Service
public class ShiroServiceImpl implements ShiroService {

    @Autowired
    private SysUserMapper SysUserMapper;

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Autowired
    private SysUserTokenMapper sysUserTokenMapper;

    /**
     * 根据用户id获取用户权限列表
     *
     * @param userId 用户id
     * @return
     */
    @Override
    public Set<String> getUserPermissions(long userId) {
        List<String> permsList;
        //如果是系统管理员拥有最高权限
        if (userId == Constant.SUPER_ADMIN) {
            List<SysMenu> menuList = sysMenuMapper.selectList(null);
            permsList = new ArrayList<>(menuList.size());
            for (SysMenu menu : menuList) {
                permsList.add(menu.getPerms());
            }
        } else {
            permsList = SysUserMapper.queryAllPerms(userId);
        }
        //用户权限列表
        Set<String> permsSet = new HashSet<>();
        for (String perms : permsList) {
            if (StringUtils.isBlank(perms)) {
                continue;
            }
            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
        }
        return permsSet;
    }

    @Override
    public SysUserToken queryByToken(String token) {
        return sysUserTokenMapper.queryByToken(token);
    }

    @Override
    public SysUser queryUser(Long userId) {
        return SysUserMapper.selectById(userId);
    }
}
