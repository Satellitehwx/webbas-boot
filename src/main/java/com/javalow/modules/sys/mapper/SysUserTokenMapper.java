package com.javalow.modules.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.javalow.modules.sys.domain.SysUserToken;

/**
 * <p>
 * 系统用户Token Mapper 接口
 * </p>
 *
 * @author Satellite
 * @since 2018-11-19
 */
public interface SysUserTokenMapper extends BaseMapper<SysUserToken> {

    SysUserToken queryByToken(String token);

}
