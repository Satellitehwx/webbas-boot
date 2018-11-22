package com.javalow.common.validator;

import com.javalow.common.exception.WebBasException;
import org.apache.commons.lang.StringUtils;

/**
 * @anthor Satellite
 * Assert
 * 数据效验
 * http://www.javalow.com
 * @date 2018-11-18-16:03
 **/
public abstract class Assert {

    public static void isBlank(String str, String message) {
        if (StringUtils.isBlank(str)) {
            throw new WebBasException(message);
        }
    }

    public static void isNull(Object object, String message) {
        if (object == null) {
            throw new WebBasException(message);
        }
    }

}
