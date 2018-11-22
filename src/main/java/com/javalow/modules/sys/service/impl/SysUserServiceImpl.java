package com.javalow.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javalow.common.utils.PageUtils;
import com.javalow.common.utils.Query;
import com.javalow.modules.sys.domain.SysUser;
import com.javalow.modules.sys.mapper.SysUserMapper;
import com.javalow.modules.sys.service.SysUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @anthor Satellite
 * SysUserServiceImpl
 * 系统用户Servcie接口的实现
 * http://www.javalow.com
 * @date 2018-11-18-16:16
 **/
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String username = (String) params.get("username");
        Long createUserId = (Long) params.get("createUserId");

        Page<SysUser> page = (Page<SysUser>) this.page(
                new Query<SysUser>(params).getPage(),
                new QueryWrapper<SysUser>()
                        .like(StringUtils.isNotBlank(username), "username", username)
                        .eq(createUserId != null, "create_user_id", createUserId));
        return new PageUtils(page);
    }

    @Override
    public List<String> queryAllPerms(Long userId) {
        return null;
    }

    @Override
    public List<Long> queryAllMenuId(Long userId) {
        return null;
    }

    @Override
    public SysUser queryByUserName(String username) {
        return baseMapper.queryByUserName(username);
    }

    @Override
    public void update(SysUser user) {

    }

    @Override
    public void deleteBatch(Long[] userIds) {

    }

    @Override
    public boolean updatePassword(Long userId, String password, String newPassword) {
        return false;
    }
}
