package com.javalow.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.code.kaptcha.Producer;
import com.javalow.common.exception.WebBasException;
import com.javalow.common.utils.DateUtils;
import com.javalow.modules.sys.domain.SysCaptcha;
import com.javalow.modules.sys.mapper.SysCaptchaMapper;
import com.javalow.modules.sys.service.SysCaptchaService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.util.Date;

/**
 * <p>
 * 系统验证码 服务实现类
 * </p>
 *
 * @author Satellite
 * @since 2018-11-19
 */
@Service("sysCaptchaServcie")
public class SysCaptchaServiceImpl extends ServiceImpl<SysCaptchaMapper, SysCaptcha> implements SysCaptchaService {

    @Autowired
    private Producer producer;

    @Override
    public BufferedImage getCaptcha(String uuid) {
        if (StringUtils.isBlank(uuid)) {
            throw new WebBasException("uuid不能为空");
        }
        //生成文字验证码
        String code = producer.createText();
        SysCaptcha sysCaptcha = new SysCaptcha();
        sysCaptcha.setUuid(uuid);
        sysCaptcha.setCode(code);
        //5分钟后过期
        sysCaptcha.setExpireTime(DateUtils.addDateMinutes(new Date(), 5));
        this.save(sysCaptcha);
        return producer.createImage(code);
    }

    @Override
    public boolean validate(String uuid, String code) {
        SysCaptcha sysCaptcha = this.getOne(new QueryWrapper<SysCaptcha>().eq("uuid", uuid));
        if (sysCaptcha == null) {
            return false;
        }
        //删除验证码
        this.removeById(uuid);
        if (sysCaptcha.getCode().equalsIgnoreCase(code) && sysCaptcha.getExpireTime().getTime() >= System.currentTimeMillis()) {
            return true;
        }
        return false;
    }
}
