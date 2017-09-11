package com.blue.ssm.log;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description:
 * @email:
 * @author: lizhixin
 * @createDate: 13:44 2017/9/11
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SystemLog {

    /** 要执行的操作类型比如：add操作 **/
    public String operationType() default "";

    /** 要执行的具体操作比如：添加用户 **/
    public String operationName() default "";

}
