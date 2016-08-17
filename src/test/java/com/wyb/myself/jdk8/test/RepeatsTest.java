/** 
 * Project Name:vega_test 
 * File Name:RepeatsTest.java 
 * Package Name:com.wyb.myself.jdk8.test 
 * Date:2016年8月19日上午11:22:16 
 * Copyright (c) 2016, chenzhou1025@126.com All Rights Reserved. 
 * 
 */

package com.wyb.myself.jdk8.test;
/** 
 * ClassName:RepeatsTest <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2016年8月19日 上午11:22:16 <br/> 
 * @author   wangyongbing 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
public @interface RepeatsTest
{
	RepeatTest[] value();
}
