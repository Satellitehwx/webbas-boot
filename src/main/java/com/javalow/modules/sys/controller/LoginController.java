package com.javalow.modules.sys.controller;

import com.javalow.common.utils.Result;
import com.javalow.modules.sys.domain.SysUser;
import com.javalow.modules.sys.form.LoginForm;
import com.javalow.modules.sys.service.SysCaptchaService;
import com.javalow.modules.sys.service.SysUserService;
import com.javalow.modules.sys.service.SysUserTokenService;
import org.apache.commons.io.IOUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

/**
 * @anthor Satellite
 * LoginController
 * 登陆控制器
 * http://www.javalow.com
 * @date 2018-11-19-22:19
 **/

@RestController
public class LoginController extends AbstractController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysUserTokenService sysUserTokenService;

    @Autowired
    private SysCaptchaService sysCaptchaService;


    /**
     * 验证码
     */
    @GetMapping("captcha.jpg")
    public void captcha(HttpServletResponse response, String uuid) throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //获取图片验证码
        BufferedImage image = sysCaptchaService.getCaptcha(uuid);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);
    }

    @PostMapping("/sys/login")
    public Map<String, Object> login(@RequestBody LoginForm form) {
        boolean captcha = sysCaptchaService.validate(form.getUuid(), form.getCaptcha());
        if (!captcha) {
            return Result.error("验证码不正确");
        }
        //用户信息
        SysUser user = sysUserService.queryByUserName(form.getUsername());
        //账号不存在、密码错误
        if (user == null || !user.getPassword().equals(new Sha256Hash(form.getPassword(), user.getSalt()).toHex())) {
            return Result.error("账号或密码不正确");
        }
        //账号锁定
        if (user.getStatus() == 0) {
            return Result.error("账号已被锁定,请联系管理员");
        }
        //生成token，并保存到数据库
        Result result = sysUserTokenService.createToken(user.getUserId());
        return result;
    }

    /**
     * 退出
     */
    @PostMapping("/sys/logout")
    public Result logout() {
        sysUserTokenService.logout(getUserId());
        return Result.ok();
    }

}
