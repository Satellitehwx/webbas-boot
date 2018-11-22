package com.javalow.modules.sys.oauth2;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @anthor Satellite
 * OAuth2Token
 * token类
 * http://www.javalow.com
 * @date 2018-11-20-20:42
 **/
public class OAuth2Token implements AuthenticationToken {

    private String token;

    public OAuth2Token(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
