package com.javalow.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.javalow.modules.sys.domain.SysCaptcha;

import java.awt.image.BufferedImage;

/**
 * <p>
 * 系统验证码 服务类
 * </p>
 *
 * @author Satellite
 * @since 2018-11-19
 */
public interface SysCaptchaService extends IService<SysCaptcha> {

    /**
     * 获取验证码图片
     *
     * @param uuid
     * @return
     */
    BufferedImage getCaptcha(String uuid);

    /**
     * 验证码效验
     *
     * @param uuid uuid
     * @param code 验证码
     * @return
     */
    boolean validate(String uuid, String code);
}
