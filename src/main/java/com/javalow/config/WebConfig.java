package com.javalow.config;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @anthor Satellite
 * WebConfig
 * WEB MVC 配置
 * http://www.javalow.com
 * @date 2018-11-19-18:03
 **/
public class WebConfig implements WebMvcConfigurer {

    /*@Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter jackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper = jackson2HttpMessageConverter.getObjectMapper();

        //生成json时，将所有Long转换成String
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
        simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
        objectMapper.registerModule(simpleModule);

        jackson2HttpMessageConverter.setObjectMapper(objectMapper);
        converters.add(0, jackson2HttpMessageConverter);
    }*/

}
