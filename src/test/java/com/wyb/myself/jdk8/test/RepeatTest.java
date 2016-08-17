/** 
 * Project Name:vega_test 
 * File Name:RepeatTest.java 
 * Package Name:com.wyb.myself.jdk8.test 
 * Date:2016年8月19日上午11:18:56 
 * Copyright (c) 2016, chenzhou1025@126.com All Rights Reserved. 
 * 
 */

package com.wyb.myself.jdk8.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName:RepeatTest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年8月19日 上午11:18:56 <br/>
 * 
 * @author wangyongbing
 * @version
 * @since JDK 1.6
 * @see
 */
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(RepeatsTest.class)
@Target(ElementType.TYPE_USE)
public @interface RepeatTest
{
	String value();
}
