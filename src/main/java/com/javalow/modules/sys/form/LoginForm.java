package com.javalow.modules.sys.form;

/**
 * @anthor Satellite
 * LoginForm
 * 登陆表单
 * http://www.javalow.com
 * @date 2018-11-19-22:49
 **/
public class LoginForm {

    private String username;
    private String password;
    private String captcha;
    private String uuid;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}