package com.javalow.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.javalow.common.utils.Result;
import com.javalow.modules.sys.domain.SysUserToken;

/**
 * <p>
 * 系统用户Token 服务类
 * </p>
 *
 * @author Satellite
 * @since 2018-11-19
 */
public interface SysUserTokenService extends IService<SysUserToken> {

    /**
     * 生成token
     *
     * @param userId 用户ID
     */
    Result createToken(long userId);

    /**
     * 退出，修改token值
     *
     * @param userId 用户ID
     */
    void logout(long userId);

}
