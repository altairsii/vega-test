/** 
 * Project Name:vega_test 
 * File Name:TimeTest.java 
 * Package Name:com.wyb.myself.jdk8.test 
 * Date:2016年8月19日下午1:11:55 
 * Copyright (c) 2016, chenzhou1025@126.com All Rights Reserved. 
 * 
 */  
  
package com.wyb.myself.jdk8.test;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import org.junit.Test;

/** 
 * ClassName:TimeTest <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2016年8月19日 下午1:11:55 <br/> 
 * @author   wangyongbing 
 * @version   
 * @since    JDK 1.8 
 * @see       
 */
public class TimeTest
{

	@Test
	public void getTimeTest(){
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate.toString());
		localDate = LocalDate.ofYearDay(2014,100);
		System.out.println(localDate.toString());
		localDate = LocalDate.of(2013,Month.FEBRUARY, 25);
		System.out.println(localDate.toString());
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt.toString());
		Clock c = Clock.systemDefaultZone();
		System.out.println(c.millis());
				
	}
}
  
