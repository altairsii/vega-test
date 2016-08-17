package com.wyb.myself.asm.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class ASMTest implements Opcodes{

	@Test
	public void asmTest() {
		ClassWriter cw = new ClassWriter(0);
		FieldVisitor fv;
		MethodVisitor mv;

		cw.visit(52, ACC_PUBLIC + ACC_SUPER, "vega_test/ASMTTest", null, "java/lang/Object", null);

		cw.visitSource("ASMTTest.java", null);

		{
		fv = cw.visitField(ACC_PRIVATE, "name", "Ljava/lang/String;", null, null);
		fv.visitEnd();
		}
		{
		mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
		mv.visitCode();
		Label l0 = new Label();
		mv.visitLabel(l0);
		mv.visitLineNumber(3, l0);
		mv.visitVarInsn(ALOAD, 0);
		mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
		mv.visitInsn(RETURN);
		Label l1 = new Label();
		mv.visitLabel(l1);
		mv.visitLocalVariable("this", "Lvega_test/ASMTTest;", null, l0, l1, 0);
		mv.visitMaxs(1, 1);
		mv.visitEnd();
		}
		{
		mv = cw.visitMethod(ACC_PUBLIC, "getName", "()Ljava/lang/String;", null, null);
		mv.visitCode();
		Label l0 = new Label();
		mv.visitLabel(l0);
		mv.visitLineNumber(8, l0);
		mv.visitVarInsn(ALOAD, 0);
		mv.visitFieldInsn(GETFIELD, "vega_test/ASMTTest", "name", "Ljava/lang/String;");
		mv.visitInsn(ARETURN);
		Label l1 = new Label();
		mv.visitLabel(l1);
		mv.visitLocalVariable("this", "Lvega_test/ASMTTest;", null, l0, l1, 0);
		mv.visitMaxs(1, 1);
		mv.visitEnd();
		}
		{
		mv = cw.visitMethod(ACC_PUBLIC, "setName", "(Ljava/lang/String;)V", null, null);
		mv.visitCode();
		Label l0 = new Label();
		mv.visitLabel(l0);
		mv.visitLineNumber(12, l0);
		mv.visitVarInsn(ALOAD, 0);
		mv.visitVarInsn(ALOAD, 1);
		mv.visitFieldInsn(PUTFIELD, "vega_test/ASMTTest", "name", "Ljava/lang/String;");
		Label l1 = new Label();
		mv.visitLabel(l1);
		mv.visitLineNumber(13, l1);
		mv.visitInsn(RETURN);
		Label l2 = new Label();
		mv.visitLabel(l2);
		mv.visitLocalVariable("this", "Lvega_test/ASMTTest;", null, l0, l2, 0);
		mv.visitLocalVariable("name", "Ljava/lang/String;", null, l0, l2, 1);
		mv.visitMaxs(2, 2);
		mv.visitEnd();
		}
		cw.visitEnd();
		
		try {
			IOUtils.write(cw.toByteArray(), new FileOutputStream("C:\\Users\\wangyongbing\\Desktop\\ASMTTest.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
