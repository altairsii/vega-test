/** 
 * Project Name:vega_test 
 * File Name:SerializableTest.java 
 * Package Name:com.wyb.myself.serializable 
 * Date:2016年8月21日上午10:17:57 
 * Copyright (c) 2016, chenzhou1025@126.com All Rights Reserved. 
 * 
 */

package com.wyb.myself.serializable;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.Marshalling;
import org.jboss.marshalling.MarshallingConfiguration;
import org.junit.Test;
import org.msgpack.MessagePack;
import org.msgpack.template.Template;
import org.msgpack.template.TemplateReference;

import com.alibaba.fastjson.JSON;
import com.wyb.myself.model.MethodHandleModelTest;

/**
 * ClassName:SerializableTest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年8月21日 上午10:17:57 <br/>
 * 
 * @author wangyongbing
 * @version
 * @since JDK 1.8
 * @see
 */
public class SerializableTest
{

	@Test
	public void jdkLengthTest()
	{
		MethodHandleModelTest mhmt = new MethodHandleModelTest();
		List<MethodHandleModelTest> a = new ArrayList<>();
		a.add(mhmt);
		a.add(mhmt);
		a.add(mhmt);
		mhmt.setId(10000);
		mhmt.setName("this is a test");
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream os;
		try
		{
			os = new ObjectOutputStream(bos);
			os.writeObject(a);
			os.flush();
			os.close();
			byte[] b = bos.toByteArray();
			System.out.println("The jdk serializable length is :" + b.length);
			bos.close();
			b = JSON.toJSONString(a).getBytes();
			System.out.println("The fastjson serializable length is :" + b.length);
			MessagePack msgpack = new MessagePack();
			msgpack.register(MethodHandleModelTest.class);
			b = msgpack.write(a);
			System.out.println("The MessagePack serializable length is :" + b.length);

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
